package com.example.SistemaBiblioteca.service;

import com.example.SistemaBiblioteca.dto.LibroDTO;
import com.example.SistemaBiblioteca.exception.ConflictException;
import com.example.SistemaBiblioteca.exception.NotFoundException;
import com.example.SistemaBiblioteca.mapper.Mapper;
import com.example.SistemaBiblioteca.model.Libro;
import com.example.SistemaBiblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// se implementa lo definido en la interfaz
// definicion que es el service
@Service
public class LibroService implements ILibroService {
    /*
     * Area de implementacion o logica de los metodos definidos en la interfaz
     */

    // inyección del repository para poder manipular datos o invocarlos
    @Autowired
    LibroRepository repo;

    // logica para traer los datos
    /*
     * Este metodo/funcion es de tipo list que se basa en al modelo DTO.
     * 1. retorna todo lo encontrado por la repo con eso se usa el ".findAll()".
     * 2. luego se usa el ".stream()" que sustituye el for o la iteracion uno por uno los
     * datos, este lo hace de forma mas rapida (en terminos de codigo, cantidad de lines, etc.),
     * nombrado como el que permitira el flujo de datos.
     * 3. ".map(Mapper::toDTO)" mapeara/generara el flujo mediante la plantilla DTO relacionando
     * lo encontrado a cada campo (definido en el Mapper.class) se usa la funcion toDTO (nombrado asi en la declaracion del mapper)
     * 4. y el ".toList()" todo lo anterior de tipo list o en formato de lista sera el flujo.
     */
    @Override
    public List<LibroDTO> traerDatos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }


    // Logica para traer por id
    @Override
    public Optional<LibroDTO> traerPorId(Integer id) {
        // se busca el libro por el id que se ingreso
        Optional<Libro> libroEsta = repo.findById(id);
        // if apra saber si el dato se encontro, de no ser asi
        // devuelve un excepcion de tipo NotFound
        if (!libroEsta.isPresent())
            throw new NotFoundException("El libro con el id: " + id + " no existe");
        // mapea
        return repo.findById(id).map(Mapper::toDTO);
    }

    // Logica para crear libro
    @Override
    public LibroDTO crear(LibroDTO libroDTO) {
        // se obtiene el ISBN que se ingreso en el DTO
        String ISBN = libroDTO.getISBN();
        // se busca el ISBN usando la consulta definida en el Repository
        var libroEsta = repo.existsByISBN(ISBN);
        // si el libro no esta se enviara la excepcion de Conflicto por existir ese dato
        // se hace esto para evitar el error de MySQL ya que se definio el ISBN como unico
        if (libroEsta) {
            throw new ConflictException("El ISBN ya esta registrado");
        }

        /*
         * Se crea la variable libro para guardar los datos ingresdos en el DTO
         * se asocia cada campo con su contraparte del DTO
         */
        var libro = Libro.builder()
                .titulo(libroDTO.getTitulo())
                .autor(libroDTO.getAutor())
                .ISBN(libroDTO.getISBN())
                .anioPublicacion(libroDTO.getAnioPublicacion())
                .genero(libroDTO.getGenero())
                .cantidadDisponible(libroDTO.getCantidadDisponible())
                .build();
        // se retorna de forma mapeda lo guardado
        return Mapper.toDTO(repo.save(libro));
    }

    // metodo para actualizar libro por Id
    @Override
    public LibroDTO actualizarLibro(Integer id, LibroDTO libroDTO) {

        // validaciones para evitar errores
        // busqueda para si existe el producto
        Libro libro = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("No se puede actualizar. El libro con ID: " + id + ", no existe."));
        // si existe el dato intentara guardar con lo ingresado
        // pero si el Json esta vacio manda un mensaje clasificado con Conflic
        if (libroDTO.isTotalmenteVacio()) throw new ConflictException("No se envio nada a actualizar");

        /*
         * Para manipular n.cabtidad de campos se utiliza una herramienta de Spring
         * pero me dio errores si no se ingresa todos los campos y los deja con nulos o prederterminados
         * eliminando lo que no se actualizo.
         * por tal motivo se uso los clasicos if, ademas que manipulo una poca cantidad de capos,
         * cada if compara si se ingreso algo en el campo esperado, si existe un dato se guarda
         * y si no se imite el campo
         */
        if (libroDTO.getTitulo() != null && !libroDTO.getTitulo().isBlank()) libro.setTitulo(libroDTO.getTitulo());
        if (libroDTO.getAutor() != null && !libroDTO.getAutor().isBlank()) libro.setAutor(libroDTO.getAutor());
        if (libroDTO.getISBN() != null && !libroDTO.getISBN().isBlank()) libro.setISBN(libroDTO.getISBN());
        if (libroDTO.getAnioPublicacion() != null) libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
        if (libroDTO.getGenero() != null && !libroDTO.getGenero().isBlank()) libro.setGenero(libroDTO.getGenero());
        if (libroDTO.getCantidadDisponible() != null) {
            if (libroDTO.getCantidadDisponible() < 0) throw new ConflictException("La cantidad no puede ser negativo");
            libro.setCantidadDisponible(libroDTO.getCantidadDisponible());
        }

        // se guarda lo obtenido y se mapea
        return Mapper.toDTO(repo.save(libro));
    }

    // Logica para eliminar el dato
    @Override
    public void eliminar(Integer id) {
        // busca la existencia del dato con el id obtenido
        // si no existe manda una excepcion
        if (!repo.existsById(id))
            throw new NotFoundException("Dato con el " + id + " no fue encontrado");
        // Se hace la eliminacion
        repo.deleteById(id);

    }

    // Logica de busqueda por termino
    @Override
    public List<LibroDTO> busquedaPorTermino(String termino) {
        // se retorna todo lo encontrado que cumpla una de las 2 condiciones
        // ignorando las Mayusculas y Minusculas.
        // en este caso se busca con contenido del termino en el campo y no por coincidencia exacta
        return repo.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(termino, termino)
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }
}
