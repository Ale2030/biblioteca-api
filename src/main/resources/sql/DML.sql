USE libreria;

INSERT INTO autores (nombre, fecha_nacimiento, nacionalidad, biografia, activo)
VALUES 
('Gabriel García Márquez', '1927-03-06', 'Colombiana', 'Escritor colombiano, autor de "Cien años de soledad".', TRUE),
('Isabel Allende', '1942-08-02', 'Chilena', 'Autora chilena conocida por "La casa de los espíritus".', TRUE),
('J.K. Rowling', '1965-07-31', 'Británica', 'Creadora de la saga de Harry Potter.', TRUE),
('Stephen King', '1947-09-21', 'Estadounidense', 'Maestro del terror, autor de "El resplandor".', TRUE),
('George Orwell', '1903-06-25', 'Británica', 'Autor de "1984" y "Rebelión en la granja".', TRUE);

INSERT INTO editoriales (nombre_editorial, oficina_editorial, activo)
VALUES 
('Penguin Random House', 'Nueva York, EE.UU.', TRUE),
('Editorial Planeta', 'Barcelona, España', TRUE),
('HarperCollins', 'Londres, Reino Unido', TRUE),
('Santillana', 'Madrid, España', TRUE),
('Ediciones B', 'Buenos Aires, Argentina', TRUE);

INSERT INTO libros (genero, titulo, id_autor, id_editorial, fecha_publicacion, activo)
VALUES 
('Realismo mágico', 'Cien años de soledad', 1, 2, '1967-05-30', TRUE),
('Ficción histórica', 'La casa de los espíritus', 2, 2, '1982-11-12', TRUE),
('Fantasía', 'Harry Potter y la piedra filosofal', 3, 3, '1997-06-26', TRUE),
('Terror', 'El resplandor', 4, 1, '1977-01-28', TRUE),
('Distopía', '1984', 5, 4, '1949-06-08', TRUE);
