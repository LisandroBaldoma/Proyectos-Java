package TrabajoIntegrador.entity;

import TrabajoIntegrador.exception.InvalidExpense;

import java.time.LocalDate;
import java.util.List;

public class Expense {
    private static int nextId = 1;
   // private static List<Category> availableCategories;

    private int id;
    private double amount;           // Monto del gasto
    private LocalDate date;               // Fecha del gasto
    private String category;         // Categoría del gasto (e.g., comida, transporte)
    private String description;      // Descripción del gasto
    private String paymentMethod;    // Método de pago (e.g., efectivo, tarjeta)
    private String currency;         // Moneda del gasto (e.g., USD, EUR)
    private List<String> tags;       // Etiquetas para clasificar el gasto

    public Expense() {
    }

    public Expense(double amount, LocalDate date, String category, String description, String paymentMethod, String currency, List<String> tags) {

        this.id = generateId();
        this.amount = amount;
        this.date = date;
        this.category = category.toLowerCase();
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.currency = currency;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    private static int generateId(){
        return nextId++;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", currency='" + currency + '\'' +
                ", tags=" + tags +
                '}';
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }


}




