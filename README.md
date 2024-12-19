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
   - `id`: Identificador único.
   - `titulo`: Título del libro.
   - `isbn`: Código ISBN del libro.
   - `idAutor`: Relación con el autor.
   - `idEditorial`: Relación con la editorial.
   - `fechaPublicacion`: Fecha de publicación.

2. **Autor**
   - `id`: Identificador único.
   - `nombre`: Nombre del autor.
   - `apellido`: Apellido del autor.
   - `biografia`: Breve descripción del autor.

3. **Editorial**
   - `id`: Identificador único.
   - `nombre`: Nombre de la editorial.
   - `pais`: País de origen de la editorial.

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
   git clone https://github.com/Ale2030/libreria-api.git
   cd libreria-api
