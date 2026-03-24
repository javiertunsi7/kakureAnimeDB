# 🎬 KarureAnime — Videoclub Backend

Aplicación de backend en **Java Vanilla** con arquitectura **MVC** para gestionar una base de datos de películas anime. Permite insertar y consultar películas mediante consola, conectando con una base de datos **MySQL**.

---

## 📋 Descripción

KarureAnime es un proyecto de gestión de un videoclub de anime. A través de la terminal, el usuario puede:
- **Crear** una nueva película introduciendo sus datos por teclado (Scanner)
- **Leer** todas las películas almacenadas en la base de datos e imprimirlas por pantalla

---

## 📸 Capturas de Pantalla

![Terminal DB](https://github.com/user-attachments/assets/e7213a30-ebc2-4eb5-9be8-9306874b657b)

![DataDB](https://github.com/user-attachments/assets/10d405b6-e5e1-466e-ba3f-56d7f7acec60)

---

## 🗂️ Estructura del proyecto

```
src/
├── Main.java                          # Punto de entrada de la aplicación
├── config/
│   └── DBManager.java                 # Gestión de la conexión a MySQL
├── model/
│   └── Movies.java                    # Modelo de datos (entidad película)
├── repository/
│   └── MovieRepositoryImpl.java       # Acceso directo a la base de datos (CRUD)
├── controller/
│   └── MovieController.java           # Capa de control entre vista y repositorio
└── view/
    └── MovieView.java                 # Capa de vista: Scanner e impresión en pantalla
```

---

## 🏗️ Arquitectura MVC

```
[ MovieView ]  →  [ MovieController ]  →  [ MovieRepositoryImpl ]  →  [ MySQL ]
   Vista               Controlador               Repositorio             Base de datos
```

| Capa | Clase | Responsabilidad |
|---|---|---|
| Vista | `MovieView` | Recoge datos del usuario (Scanner) y muestra resultados |
| Controlador | `MovieController` | Recibe peticiones de la vista y las delega al repositorio |
| Repositorio | `MovieRepositoryImpl` | Ejecuta las queries SQL contra la base de datos |
| Modelo | `Movies` | Define los atributos de una película |
| Config | `DBManager` | Abre y cierra la conexión con MySQL |

---

## 🗃️ Base de datos

**Motor:** MySQL  
**Base de datos:** `karureanime_app`  
**Tabla:** `movies`

### Esquema SQL

```sql
CREATE DATABASE IF NOT EXISTS karureanime_app;
USE karureanime_app;

CREATE TABLE movies (
    id       INT          AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(45)  NOT NULL,
    year     INT          NOT NULL,
    duration FLOAT        NOT NULL,
    genre    VARCHAR(45)  NOT NULL,
    studio   VARCHAR(45)  NOT NULL,
    rating   FLOAT        NOT NULL,
    poster   VARCHAR(255) NOT NULL,
    synopsis TEXT         NOT NULL
);
```

> ⚠️ Si ya tienes la tabla creada con tipos incorrectos, ejecuta este ALTER:
> ```sql
> USE karureanime_app;
> ALTER TABLE movies
>   MODIFY COLUMN year     INT          NOT NULL,
>   MODIFY COLUMN poster   VARCHAR(255) NOT NULL,
>   MODIFY COLUMN synopsis TEXT         NOT NULL;
> ```

---

## ⚙️ Configuración de la conexión

En `config/DBManager.java` están definidas las credenciales de conexión:

```java
private static final String URL      = "jdbc:mysql://localhost:3306/karureanime_app";
private static final String USER     = "root";
private static final String PASSWORD = "1234";
```

Modifica estos valores si tu configuración de MySQL es diferente.

---

## ▶️ Cómo ejecutar

### Requisitos previos

- Java 11 o superior
- MySQL 8.0 o superior (con MySQL Workbench opcional)
- Conector JDBC de MySQL (`mysql-connector-j`) añadido al classpath del proyecto

### Pasos

1. Clona el repositorio
   ```bash
   git clone https://github.com/tu-usuario/karureanime-app.git
   ```

2. Crea la base de datos ejecutando el SQL del apartado anterior en MySQL Workbench

3. Abre el proyecto en IntelliJ IDEA

4. Añade el conector JDBC en `File > Project Structure > Libraries`

5. Ejecuta `Main.java`

6. Sigue las instrucciones en la terminal:
   ```
   Escribe el título de la película:
   > Spirited Away
   Escribe el año (ej: 2023):
   > 2001
   Escribe la duración en minutos (ej: 120):
   > 125
   ...
   ```

---

## 🎬 Ejemplo de salida en pantalla

```
Conexión BBDD exitosa
Película creada con éxito
Conexión cerrada con éxito
Conexión BBDD exitosa
Título: Spirited Away | Año: 2001 | Duración: 125 min | Género: Fantasia | Estudio: Studio Ghibli | Puntuación: 8.6
Título: Princess Mononoke | Año: 1997 | Duración: 134 min | Género: Aventura | Estudio: Studio Ghibli | Puntuación: 8.7
Conexión cerrada con éxito
```

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Uso |
|---|---|
| Java 11+ | Lenguaje principal |
| MySQL 8 | Base de datos relacional |
| JDBC | Conexión Java ↔ MySQL |
| IntelliJ IDEA | IDE de desarrollo |
| MySQL Workbench | Gestión visual de la BD |

---
