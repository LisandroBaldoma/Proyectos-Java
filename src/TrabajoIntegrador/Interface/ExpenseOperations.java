package TrabajoIntegrador.Interface;

import TrabajoIntegrador.entity.Expense;
import java.util.List;
import java.util.stream.Collectors;
import java.time.YearMonth;
import java.util.Map;
import java.time.LocalDate;

public interface ExpenseOperations {

    double calculateTotal(List<Expense> expenses);
    List<Expense> filterByCategory(List<Expense> expenses, String category);
    List<Expense> filterByDateRange(List<Expense> expenses, LocalDate start, LocalDate end);
    String getMostExpensiveCategory(List<Expense> expenses);
    String getMostUsedPaymentMethod(List<Expense> expenses);
    double getMaxExpenseAmount(List<Expense> expenses);
    Map<String, Double> getTotalByCurrency(List<Expense> expenses);
    Map<YearMonth, Double> getTotalByMonth(List<Expense> expenses);
    List<Expense> filterByTag(List<Expense> expenses, String tag);



}
