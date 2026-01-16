-- Los IDs no se incluyen porque son auto_increment
-- Se usa IGNORE para evitar errores por duplicado de ISBN en reinicios
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Don Quijote de la Mancha', 'Miguel de Cervantes', 1605, 'Novela', 5, '9788424116248');
INSERT IGNORE INTO libro (libro.titulo, libro.autor, libro.anio_publicacion, libro.genero, libro.cantidad_disponible, libro.isbn) VALUES ('Cien años de soledad', 'Gabriel García Márquez', 1967, 'Realismo Mágico', 10, '9780307474728');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('1984', 'George Orwell', 1949, 'Distopía', 15, '9780451524935');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('El Principito', 'Antoine de Saint-Exupéry', 1943, 'Infantil', 20, '9780156012195');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Crónica de una muerte anunciada', 'Gabriel García Márquez', 1981, 'Novela', 8, '9781400034956');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Rayuela', 'Julio Cortázar', 1963, 'Novela', 4, '9788420412177');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Fahrenheit 451', 'Ray Bradbury', 1953, 'Ciencia Ficción', 12, '9781451673319');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('El Aleph', 'Jorge Luis Borges', 1949, 'Ficción', 6, '9788420633305');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('La ciudad y los perros', 'Mario Vargas Llosa', 1963, 'Novela', 9, '9788420422152');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Pedro Páramo', 'Juan Rulfo', 1955, 'Realismo Mágico', 7, '9788437601656');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Orgullo y Prejuicio', 'Jane Austen', 1813, 'Romance', 11, '9780141439517');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('El resplandor', 'Stephen King', 1977, 'Terror', 14, '9780307743657');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Fundación', 'Isaac Asimov', 1951, 'Ciencia Ficción', 18, '9780553293357');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Matar a un ruiseñor', 'Harper Lee', 1960, 'Drama', 3, '9780061120084');
INSERT IGNORE INTO libro (titulo, autor, anio_publicacion, genero, cantidad_disponible, isbn) VALUES ('Sapiens: De animales a dioses', 'Yuval Noah Harari', 2011, 'Historia', 25, '9780062310200');