package TrabajoIntegrador.service;
import java.time.LocalDate;
import java.util.*;
import TrabajoIntegrador.entity.Expense;
import TrabajoIntegrador.entity.Category;

public class ExpenseGenerator {

    private static List<Category> availableCategories = new ArrayList<>();

    public static void setAvailableCategories(List<Category> categories) {
        availableCategories = categories;
    }

    public static List<Expense> createRandomExpenses(int count) {
        List<Expense> expenses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            expenses.add(createRandomExpense());
        }
        return expenses;
    }

    public static Expense createRandomExpense() {
        Random random = new Random();

        double amount = 10 + (1000 - 10) * random.nextDouble();
        LocalDate date = LocalDate.now().minusDays(random.nextInt(365));
        List<String> categories = Arrays.asList("Food", "Transport", "Entertainment", "Health", "Shopping");
        String category = categories.get(random.nextInt(categories.size()));
        String description = "Random expense " + random.nextInt(1000);
        List<String> paymentMethods = Arrays.asList("Cash", "Credit Card", "Debit Card", "PayPal");
        String paymentMethod = paymentMethods.get(random.nextInt(paymentMethods.size()));
        List<String> currencies = Arrays.asList("USD", "EUR", "GBP", "JPY", "MXN");
        String currency = currencies.get(random.nextInt(currencies.size()));
        List<String> tags = new ArrayList<>(Arrays.asList("random", "test"));

        if (random.nextBoolean()) {
            tags.add("urgent");
        }

        return new Expense(amount, date, category, description, paymentMethod, currency, tags);
    }

    public static boolean isCategoryValid(String categoryName) {
        return availableCategories.stream()
                .anyMatch(category -> category.getName().equalsIgnoreCase(categoryName));
    }
}
