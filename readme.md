# Proyecto de Finanzas Personales

Este proyecto de Finanzas Personales es una aplicación Java que permite gestionar y analizar gastos de manera sencilla. El propósito es proporcionar una herramienta básica para registrar, filtrar y obtener estadísticas de las transacciones personales.

## 🚀 Descripción General
La aplicación permite:
- Registrar gastos con detalles como monto, fecha, categoría, método de pago, descripción, moneda y etiquetas.
- Filtrar gastos por diferentes criterios (categoría, método de pago, rango de fechas, etc.).
- Obtener estadísticas, como la categoría con más gastos, el método de pago más utilizado y el gasto máximo registrado.
- Validar la información de cada gasto para evitar errores.

## 📁 Estructura del Proyecto
La aplicación está organizada de la siguiente manera:

- **Archivo Principal:**
  - `ExpenseTrackerApp.java`: Punto de entrada principal para ejecutar la aplicación.

- **Configuración:**
  - `config/JdbcConfig.java`: Configuración de la conexión JDBC con la base de datos H2.

- **DAO (Data Access Object):**
  - `Dao/ExpenseDao.java`: Interfaz para operaciones de base de datos sobre `Expense`.
  - `Dao/Imple/ExpenseDaoH2Impl.java`: Implementación del DAO para la base de datos H2.
  - `Dao/Imple/ExpenseDaoListImpl.java`: Implementación alternativa usando listas (para pruebas sin base de datos).

- **Entidades:**
  - `entity/Expense.java`: Representa un gasto con propiedades como `amount`, `date`, `category`, etc.
  - `entity/Category.java`: Representa las categorías disponibles para clasificar los gastos.
  - `entity/User.java`: Clase para representar a los usuarios del sistema.

- **Excepciones:**
  - `exception/InvalidDbConnection.java`: Manejo de errores personalizados para problemas de conexión.
  - `exception/InvalidExpense.java`: Excepción personalizada para gastos inválidos.

- **Interfaces:**
  - `Interface/ExpenseOperations.java`: Métodos funcionales para operaciones sobre los gastos.
  - `Interface/ExpenseValidator.java`: Interfaz para validar la información de un gasto.
  - `Interface/CategoryOperations.java`: Métodos funcionales para operaciones sobre categorías.
  - `Interface/CategoryValidator.java`: Interfaz para validar la información de una categoría.

- **Servicios:**
  - `service/ExpenseService.java`: Implementa las operaciones principales para filtrar, calcular totales y generar estadísticas.
  - `service/ExpenseGenerator.java`: Se encarga de la generación de gastos aleatorios para pruebas.
  - `service/CategoryService.java`: Manejo de categorías y operaciones relacionadas.
  - `service/CategoryGenerator.java`: Generación de categorías aleatorias.
  - `service/DataBase/ExpenseAbmService.java`: Servicio para operaciones CRUD con la base de datos.

- **Pruebas:**
  - `test/service/ExpenseGeneratorTest.java`: Pruebas unitarias para la generación de gastos.
  - `test/service/ExpenseServiceTest.java`: Pruebas unitarias para el servicio de gastos.
  - `test/service/DataBase/ExpenseAbmServiceTest.java`: Pruebas de operaciones CRUD en la base de datos.

## ⚙️ Instalación y Ejecución
1. Clonar el repositorio:
```bash
  git clone https://github.com/tu-usuario/proyecto-finanzas.git
```
2. Abrir el proyecto en IntelliJ IDEA.
3. Asegurarse de tener configurado el JDK 17 o superior.
4. Configurar la base de datos H2 en el archivo `JdbcConfig.java`.
5. Ejecutar la aplicación desde el método `main` en `ExpenseTrackerApp.java`.

## 💡 Uso
La aplicación genera gastos aleatorios y permite aplicar filtros y análisis desde la consola. Ejemplo de ejecución:
```bash
Total gastado: $1500.00
Gasto máximo: $300.00
Categoría con más gastos: Alimentación
Método de pago más utilizado: Tarjeta de crédito
```

## 🛠️ Tecnologías Utilizadas
- Java 17
- IntelliJ IDEA
- H2 Database (JDBC)
- JUnit 5 (para pruebas unitarias)
- Mockito (para pruebas de servicios)

## 🤝 Contribuciones
Las contribuciones son bienvenidas. Si deseas colaborar, realiza un fork del repositorio y envía un pull request.

## 📄 Licencia
Este proyecto está bajo la licencia MIT. Puedes ver el archivo `LICENSE` para más detalles.

