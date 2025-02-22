package TrabajoIntegrador.service;

import TrabajoIntegrador.Interface.ExpenseOperations;
import TrabajoIntegrador.entity.Expense;

import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.time.YearMonth;
import java.util.Map;

public class ExpenseService implements ExpenseOperations {

    @Override
    public double calculateTotal(List<Expense> expenses) {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    @Override
    public List<Expense> filterByCategory(List<Expense> expenses, String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @Override
    public List<Expense> filterByDateRange(List<Expense> expenses, LocalDate start, LocalDate end) {
        return expenses.stream()
                .filter(expense -> !expense.getDate().isBefore(start) && !expense.getDate().isAfter(end))
                .toList();
    }

    @Override
    public String getMostExpensiveCategory(List<Expense> expenses) {
        return expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getAmount)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    @Override
    public String getMostUsedPaymentMethod(List<Expense> expenses) {
        return expenses.stream()
                .collect(Collectors.groupingBy(Expense::getPaymentMethod, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    @Override
    public double getMaxExpenseAmount(List<Expense> expenses) {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .max()
                .orElse(0);
    }

    @Override
    public Map<String, Double> getTotalByCurrency(List<Expense> expenses) {
        return expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCurrency, Collectors.summingDouble(Expense::getAmount)));
    }

    @Override
    public Map<YearMonth, Double> getTotalByMonth(List<Expense> expenses) {
        return expenses.stream()
                .collect(Collectors.groupingBy(expense -> YearMonth.from(expense.getDate()), Collectors.summingDouble(Expense::getAmount)));
    }

    @Override
    public List<Expense> filterByTag(List<Expense> expenses, String tag) {
        return expenses.stream()
                .filter(expense -> expense.getTags().contains(tag))
                .toList();
    }




}
