package TrabajoIntegrador.Interface;

import TrabajoIntegrador.entity.Expense;

@FunctionalInterface
public interface ExpenseValidator {
    boolean validate(Expense expense);
}
