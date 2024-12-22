# API Librería - Sistema de Biblioteca Digital 📚

Este proyecto es una **API RESTful** desarrollada en **Spring Boot**, que permite la gestión de libros, autores y editoriales para una biblioteca digital. Incluye funcionalidades para crear, leer, actualizar y eliminar registros.

---

## 🚀 Características
- **Gestión de Libros**: Registrar, consultar, actualizar y eliminar libros.
- **Gestión de Autores**: Administrar los autores asociados a los libros.
- **Gestión de Editoriales**: Controlar la información de las editoriales.

---

## 🗂️ Estructura del Proyecto
### Entidades Principales
1. **Libro**
   - `idLibro`: Identificador único.
   - `genero`: Genero del libro.
   - `titulo`: Título del libro.
   - `idAutor`: Relación con el autor.
   - `idEditorial`: Relación con la editorial.
   - `fechaPublicacion`: Fecha de publicación.
   - `activo`: Indica si el libro está disponible o activo en el sistema. (Valor booleano: true para activo, false para inactivo).

2. **Autor**
   - `idAutor`: Identificador único.
   - `nombre`: Nombre completo del autor.
   - `fechaNacimiento`: Fecha de nacimento del autor.
   - `nacionalidad`: Nacionalidad del autor.
   - `biografia`: Breve descripción del autor.
   - `activo`:Indica si el autor está disponible o activo en el sistema. (Valor booleano: true para activo, false para inactivo).

3. **Editorial**
   - `idEditorial`: Identificador único.
   - `nombreEditorial`: Nombre de la editorial.
   - `oficinaEditorial`: Oficinas de la editorial.
   - `idLibro`: Relacion con el libro.
   - `activo`:Indica si la editorial está disponible o activo en el sistema. (Valor booleano: true para activo, false para inactivo).

---

## 🔧 Tecnologías Utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (Base de datos relacional)

---

## 📄 Endpoints

### Libros
- **GET** `/api/libros` - Obtener todos los libros.
- **GET** `/api/libros/{id}` - Obtener un libro por su ID.
- **POST** `/api/libros` - Crear un nuevo libro.
- **PUT** `/api/libros/{id}` - Actualizar un libro.
- **DELETE** `/api/libros/{id}` - Eliminar un libro.

### Autores
- **GET** `/api/autores` - Obtener todos los autores.
- **GET** `/api/autores/{id}` - Obtener un autor por su ID.
- **POST** `/api/autores` - Crear un nuevo autor.
- **PUT** `/api/autores/{id}` - Actualizar un autor.
- **DELETE** `/api/autores/{id}` - Eliminar un autor.

### Editoriales
- **GET** `/api/editoriales` - Obtener todas las editoriales.
- **GET** `/api/editoriales/{id}` - Obtener una editorial por su ID.
- **POST** `/api/editoriales` - Crear una nueva editorial.
- **PUT** `/api/editoriales/{id}` - Actualizar una editorial.
- **DELETE** `/api/editoriales/{id}` - Eliminar una editorial.

---

## ⚙️ Instalación y Uso

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Ale2030/biblioteca-api.git
   cd biblioteca-api
