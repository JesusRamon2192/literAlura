Claro, aquí tienes un `README.md` básico y bien estructurado para tu proyecto **Literalura**, adaptado a lo que ya implementaste en tu clase `Principal.java`.

---

## 📚 Literalura

**Literalura** es una aplicación Java basada en consola que permite consultar libros de dominio público a través de la API de [Gutendex](https://gutendex.com/), guardarlos en una base de datos y realizar consultas sobre ellos y sus autores.

Desarrollado como parte del **Alura Challenge Backend**.

---

### 🔧 Tecnologías utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* H2 / PostgreSQL / MySQL (según tu configuración)
* API externa: [Gutendex](https://gutendex.com/)
* Maven

---

### 🚀 Funcionalidades implementadas

Desde un menú interactivo en consola, el usuario puede:

1. 🔍 **Buscar libro por título**
   Consulta la API externa con el nombre del libro y guarda la información del libro y su autor en la base de datos.

2. 📚 **Listar libros registrados**
   Muestra todos los libros almacenados en la base de datos.

3. 🧑‍💼 **Listar autores registrados**
   Muestra todos los autores almacenados en la base de datos.

4. 🧓 **Listar autores vivos en un determinado año**
   Solicita un año por consola y muestra los autores que estaban vivos en ese año.

5. 🌐 **Listar libros por idioma**
   Filtra los libros registrados en la base de datos por idioma (`es`, `en`, etc.).

---

### ⚙️ Instalación y ejecución

1. Clona este repositorio:

   ```bash
   git clone https://github.com/tu_usuario/literalura.git
   cd literalura
   ```

2. Compila el proyecto con Maven:

   ```bash
   mvn clean install
   ```

3. Ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

---

### 📂 Estructura del proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/alurachallenge/literalura/
│   │       ├── model/           # Clases Entidad (Libro, Autor, etc.)
│   │       ├── repository/      # Interfaces JPA Repository
│   │       ├── service/         # Consumo de API y conversión de datos
│   │       └── principal/       # Clase Principal con el menú
│   └── resources/
│       └── application.properties
```

---

### 📝 Notas técnicas

* El campo de idioma se maneja como un string (por ejemplo `"es"` para español).
* Se usa `Spring Data JPA` para persistencia automática de entidades.
* Los métodos en los repositorios usan convenciones de nombre (`findBy...`) para generar las consultas automáticamente.
* Para evitar errores de inyección, asegúrate de que las entidades `Libro` y `Autor` estén correctamente anotadas con `@Entity` y tengan sus atributos bien definidos.

---


### 🧑‍💻 Autor

Desarrollado por Jesus Arnoldo Ramon Oyervides en Alura Cursos

