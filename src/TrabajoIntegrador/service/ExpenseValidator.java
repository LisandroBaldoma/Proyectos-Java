package TrabajoIntegrador.service;

import TrabajoIntegrador.entity.Expense;
import TrabajoIntegrador.exception.InvalidExpense;

public class ExpenseValidator {
    public static void validateExpense(Expense expense) throws InvalidExpense {
        if (expense.getAmount() <= 10) {
            throw new InvalidExpense("El monto debe ser mayor a 10.");
        }
        if (expense.getDescription().isEmpty()) {
            throw new InvalidExpense("La descripción no puede estar vacía.");
        }
        if (!ExpenseGenerator.isCategoryValid(expense.getCategory())) {
            throw new InvalidExpense("La categoría no es válida: " + expense.getCategory());
        }
    }
}
