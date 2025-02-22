package TrabajoIntegrador.entity;
import java.util.List;

public class User {

    private String name;              // Nombre del usuario
    private String email;             // Correo electrónico del usuario
    private List<Expense> expenses;   // Lista de gastos asociados al usuario
    private int id;                   // Identificador único del usuario
    private String password;          // Contraseña del usuario
    private String role;              // Rol del usuario (e.g., "admin", "regular")

    public User(String name, String email, List<Expense> expenses, int id, String password, String role) {
        this.name = name;
        this.email = email;
        this.expenses = expenses;
        this.id = id;
        this.password = password;
        this.role = role;
    }

    // Método para agregar un gasto
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Método para eliminar un gasto por su índice
    public void removeExpense(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
        }
    }

    // Método para actualizar un gasto
    public void updateExpense(int index, Expense newExpense) {
        if (index >= 0 && index < expenses.size()) {
            expenses.set(index, newExpense);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

//  La clase User debe tener propiedades como name, email y un arreglo de expenses.

// Crear métodos como addExpense(), removeExpense() y updateExpense() en la clase User.

// Implementar manejo de excepciones para gestionar errores comunes, como intentos de acceso a elementos inexistentes en la lista.

// Crear excepciones personalizadas como ExpenseNotFoundException.

// Utilizar bloques try-catch para manejar estas excepciones en métodos como removeExpense() y updateExpense().
