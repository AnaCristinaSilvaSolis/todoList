# ✅ API de Gestión de Tareas (ToDo List)

API RESTful desarrollada con **Spring Boot 3**, que permite a los usuarios crear, consultar, actualizar y eliminar tareas. Ideal para practicar conceptos fundamentales como controladores, servicios, DTOs y persistencia de datos.

---

## 🚀 Tecnologías Utilizadas

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Lombok (anotaciones individuales)
- PostgreSQL
- Maven

---

## 📂 Estructura del Proyecto
├── controller
│ └── TaskController.java
├── dto
│ └── TaskDTO.java
├── entity
│ └── Task.java
├── repository
│ └── ITaskRepository.java
├── service
│ ├── ITaskService.java
│ └── TaskServiceImpl.java
└── resources
└── application.properties


---

## 🔌 Endpoints Disponibles

### 📄 Obtener todas las tareas
- **GET** `/api/v1/tasks`
- 📥 Parámetros: ninguno
- 📤 Respuesta: lista de tareas en formato JSON

---

### 🔍 Obtener tarea por ID
- **GET** `/api/v1/task/{id}`
- 📥 Parámetros: ID de la tarea
- 📤 Respuesta: una tarea

---

### 📝 Crear una nueva tarea
- **POST** `/api/v1/task/create`
- 📥 Body JSON:

~~~json
{
  "titulo": "Estudiar Spring Boot",
  "descripcion": "Practicar rutas y lógica de negocio",
  "fechaLimite": "2025-07-25",
  "completado": false
}
~~~
- 📤 Respuesta: tarea 

### 📝 Actualizar una tarea existente
- **PUT** `/api/v1/task/update/{id}`
- 📥 Body JSON (igual al de creación)
- 📤 Respuesta: tarea actualizada

### ❌ Eliminar una tarea
- **DELETE** `/api/v1/task/delete/{id}`
- 📥 Parámetro: ID de la tarea
- 📤 Respuesta: mensaje de confirmación o código 204
---
## ⚙️ Requisitos Previos
- Java 21
- Maven
- IDE (recomendado: IntelliJ o VS Code con Spring Extension Pack)
- Postman para probar los endpoints
---
## 🧪 Cómo Probar la API
1. Clona este repositorio
2. Compila y ejecuta el proyecto
3. Accede a la API en:: http://localhost:8080/api/v1/
4. Usa Postman para probar los endpoints. No olvides usar el header: Content-Type: application/json

## 🛠️ Posibles Mejoras Futuras
- Validación con anotaciones (@NotNull, @Size, etc.)
- Manejo de excepciones globales con @ControllerAdvice
- Documentación con Swagger
- Persistencia en base de datos PostgreSQL o MySQL
- Autenticación y autorización con Spring Security

## 📚 Autor
Desarrollado por Ana Cristina Silva Solis - Proyecto de práctica con Spring Boot
📧 Contacto: cristinasilvasolis09@gmail.com

## 📄 Licencia
Este proyecto se distribuye bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
