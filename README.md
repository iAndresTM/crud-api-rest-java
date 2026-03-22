# 🛒 API REST de Productos con Spring Boot + PostgreSQL

---

## 📌 Descripción del proyecto

Este proyecto consiste en el desarrollo de una **API RESTful** utilizando **Spring Boot** que permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una entidad llamada **Producto**.

La aplicación está conectada a una base de datos **PostgreSQL**, donde se almacenan los datos de los productos.

---

## 🎯 Objetivo del proyecto

El objetivo principal es:

* Comprender cómo funciona una API REST en Java
* Implementar persistencia de datos con JPA (Java Persistence API)
* Conectar una aplicación Spring Boot con una base de datos PostgreSQL
* Aplicar buenas prácticas básicas en el desarrollo backend

---

## 🧱 Arquitectura del proyecto

El proyecto sigue una arquitectura en capas:

```
src/main/java
│
├── Entities       → Representación de tablas en la BD
├── Repositories   → Acceso a datos (JPA)
├── Controllers    → Endpoints de la API
```

---

## 📦 Entidad: Producto

```java
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
}
```

### 🔍 Explicación de anotaciones

### `@Entity`

* Indica que esta clase es una **entidad JPA**
* Se mapea directamente a una tabla en la base de datos
* El nombre de la tabla por defecto será el nombre de la clase (`producto`)

---

### `@Id`

* Define la **clave primaria** de la tabla
* Es el identificador único de cada registro

---

### `@GeneratedValue(strategy = GenerationType.IDENTITY)`

* Indica que el valor del ID será generado automáticamente
* `IDENTITY` significa que la base de datos se encarga de autoincrementarlo

---

## 🗄️ Repositorio

```java
public interface ProductoRepository extends JpaRepository<Producto, Long>
```

### ¿Qué hace?

* Permite interactuar con la base de datos sin escribir SQL
* Proporciona métodos listos como:

| Método     | Descripción                 |
| ---------- | --------------------------- |
| findAll()  | Obtener todos los registros |
| findById() | Buscar por ID               |
| save()     | Guardar o actualizar        |
| delete()   | Eliminar                    |

---

## 🌐 Controlador (API REST)

```java
@RestController
@RequestMapping("/productos")
public class ProductoController
```

---

### 🔍 Explicación de anotaciones

### `@RestController`

* Indica que la clase es un controlador REST
* Combina `@Controller` + `@ResponseBody`
* Retorna datos en formato JSON automáticamente

---

### `@RequestMapping("/productos")`

* Define la ruta base de los endpoints
* Todos los endpoints empezarán con `/productos`

---

### `@Autowired`

* Permite la **inyección de dependencias**
* Spring se encarga de crear e inyectar el objeto automáticamente

---

## 🔄 Endpoints del CRUD

---

### 🟢 GET - Obtener todos los productos

```java
@GetMapping
public List<Producto> getAllProductos()
```

* Retorna una lista de productos
* URL: `GET /productos`

---

### 🟡 GET - Obtener producto por ID

```java
@GetMapping("/{id}")
```

* Busca un producto específico
* URL: `GET /productos/{id}`

---

### 🔵 POST - Crear producto

```java
@PostMapping
public Producto createProducto(@RequestBody Producto producto)
```

#### `@RequestBody`

* Convierte el JSON recibido en un objeto Java

---

### 🟠 PUT - Actualizar producto

```java
@PutMapping("/{id}")
```

* Actualiza un producto existente

---

### 🔴 DELETE - Eliminar producto

```java
@DeleteMapping("/{id}")
```

* Elimina un producto por ID

---

## 🔌 Configuración de la base de datos

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/apirest_db
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧠 Explicación de propiedades

### `spring.jpa.hibernate.ddl-auto=update`

* Crea o actualiza las tablas automáticamente

### `spring.jpa.show-sql=true`

* Muestra las consultas SQL en consola

---

## 🚀 Ejemplo de uso

### Crear producto

```json
{
  "nombre": "Play Station 4",
  "precio": 200.54
}
```

---

## 🧠 Conclusión

Este proyecto demuestra:

* Cómo construir una API REST desde cero
* Cómo conectar con PostgreSQL
* Cómo usar JPA para persistencia
* Cómo estructurar un backend básico profesional

---

