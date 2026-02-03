## 🧠 **Evaluación Conjunta 2 – Microservicio de Simulación de Inversiones**

Este proyecto es una aplicación backend construida en **Java** con **Spring Boot**, diseñada para implementar un microservicio que permita:

✅ Recibir inversiones de usuarios
✅ Seleccionar productos financieros adecuados
✅ Calcular ganancias esperadas
✅ Agregar simulaciones históricas por usuario

📁 Lenguaje: Java
📌 Frameworks: Spring Boot, Spring Data JPA
📌 Persistencia: JPA (ORM)

---

## 🧾 **Descripción General**

Esta evaluación tenía como objetivo desarrollar una API REST que permitiera:

✔ Registrar usuarios
✔ Registrar productos financieros
✔ Simular una inversión dada una lista de productos y un capital disponible
✔ Devolver al cliente (por JSON) una simulación detallada con productos seleccionados, ganancia total y retorno estimado

La idea era aplicar conceptos de:

🔹 Arquitectura en capas
🔹 DTOs para transferencia segura de datos
🔹 Repositorios para acceso a base de datos
🔹 Controladores REST
🔹 Lógica de negocio para cálculos financieros

---

## 🛠️ **Estructura del Proyecto**

La estructura principal del proyecto es:

```
src/
 └── main/
     ├── java/
     │   └── espe/edu/ec/prueba/
     │       ├── controllers
     │       ├── DTO
     │       ├── entities
     │       ├── Repository
     │       └── services
     └── resources/
         └── application.properties
```

✔ **controllers** – REST endpoints
✔ **DTO** – Objetos de transferencia
✔ **entities** – Modelos persistidos
✔ **Repository** – Interfaces JPA
✔ **services** – Lógica de negocio

---

## 📌 **Endpoints Implementados**

### **POST /simulaciones**

Recibe:

```json
{
  "usuarioId": "uuid-de-usuario",
  "capitalDisponible": 10000,
  "productos": [
      {
          "nombre": "Fondo A",
          "precio": 1000,
          "porcentajeGanancia": 8.5
      }
  ]
}
```

Retorna un objeto `Simulacion` con:

* Productos seleccionados
* Ganancia total
* Retorno estimado

---

### **GET /simulaciones/{usuarioId}**

Devuelve todas las simulaciones almacenadas para ese usuario.

---

## 📊 **Cómo se calcula la simulación**

Cada producto se evalúa secuencialmente:

🔸 Se suma el costo si no excede el capital disponible
🔸 Se calcula ganancia:

```
gananciaEsperada = costo * (porcentajeRetorno / 100)
```

🔸 Se acumulan ganancias y retorno final.

---

## 📌 **Qué se logró**

✅ Modelo de entidades para usuario, producto y simulación
✅ DTO para recepción de simulación
✅ Lógica base de negocio para calcular una simulación funcional
✅ Endpoint POST para simular
❌ Endpoint GET por usuario funcionó parcialmente por el error de consulta
❌ Persistencia completa de simulaciones en base de datos no fue verificada

---

## 📥 **Requisitos para ejecutar el proyecto**

1. Java 17+
2. Maven
3. Base de datos (PostgreSQL o H2 en memoria)
4. Configurar `application.properties`

---

## 📦 **Dependencias principales**

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

---
