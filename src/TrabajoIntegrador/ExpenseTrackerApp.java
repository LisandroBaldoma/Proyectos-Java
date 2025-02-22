package TrabajoIntegrador;

import TrabajoIntegrador.Dao.Imple.ExpenseDaoH2Impl;
import TrabajoIntegrador.Dao.Imple.ExpenseDaoListImpl;
import TrabajoIntegrador.service.CategoryService;
import TrabajoIntegrador.service.DataBase.ExpenseAbmService;
import TrabajoIntegrador.service.ExpenseGenerator;
import TrabajoIntegrador.entity.Expense;
import TrabajoIntegrador.entity.Category;
import TrabajoIntegrador.service.ExpenseService;
import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        System.out.println("APP CONTROL DE GASTOS" );
        // PRUEBAS CON EXPENSE

        try {
            CategoryService categoryService = new CategoryService();

            List<Category> categories = categoryService.loadCategories();

            ExpenseGenerator.setAvailableCategories(categories);

            // Agregar categorías
            categoryService.addCategory(new Category("Food", "Gastos en comida", null, "#FF5733", "food_icon", true));
            categoryService.addCategory(new Category("Transport", "Gastos en transporte", null, "#33FF57", "transport_icon", true));
            categoryService.addCategory(new Category("Health", "Gastos en salud", null, "#5733FF", "health_icon", true));

            // Mostrar todas las categorías
            System.out.println("Categorías registradas:");
            for (Category category : categoryService.getAllCategories()) {
                System.out.println(category);
            }

            // Buscar una categoría
            Category foundCategory = categoryService.findCategoryByName("Food");
            System.out.println("Categoría encontrada: " + (foundCategory != null ? foundCategory : "No encontrada"));

            // Intentar eliminar una categoría
            categoryService.removeCategory("Transport");

            // Mostrar categorías después de eliminar
            System.out.println("Categorías después de eliminar:");
            for (Category category : categoryService.getAllCategories()) {
                System.out.println(category);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            //List<Category> categories = CategoryGenerator.loadCategories();

            //ExpenseGenerator.setAvailableCategories(categories);


            List<Expense> expenses = ExpenseGenerator.createRandomExpenses(15);

            // Instanciamos el servicio
            ExpenseService service = new ExpenseService();

            // Pruebas de métodos del servicio
            System.out.println("Total Gastado: " + service.calculateTotal(expenses));

            System.out.println("Filtrar por categoría (Ej: Food): ");
            service.filterByCategory(expenses, "Food").forEach(System.out::println);

            System.out.println("Filtrar por rango de fechas (últimos 7 días): ");
            service.filterByDateRange(expenses, LocalDate.now().minusDays(7), LocalDate.now())
                    .forEach(System.out::println);

            System.out.println("Categoría con más gasto: " + service.getMostExpensiveCategory(expenses));
            System.out.println("Método de pago más usado: " + service.getMostUsedPaymentMethod(expenses));
            System.out.println("Mayor gasto registrado: " + service.getMaxExpenseAmount(expenses));

            System.out.println("Gastos totales por moneda:");
            service.getTotalByCurrency(expenses).forEach((currency, total) ->
                    System.out.println(currency + ": " + total));

            System.out.println("Gastos totales por mes:");
            service.getTotalByMonth(expenses).forEach((month, total) ->
                    System.out.println(month + ": " + total));

            System.out.println("Filtrar por etiqueta (Ej: test): ");
            service.filterByTag(expenses, "test").forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        ExpenseAbmService expenseService = new ExpenseAbmService(new ExpenseDaoH2Impl());
        //ExpenseAbmService expenseService = new ExpenseAbmService(new ExpenseDaoListImpl());

        // Crear un gasto de prueba
        Expense expense = new Expense(
                150.75,
                LocalDate.now(),
                "Alimentación",
                "Cena en restaurante",
                "Tarjeta de crédito",
                "USD",
                Arrays.asList("restaurante", "cena")
        );

        // Guardar en la base de datos
        int generatedId = expenseService.saveExpense(expense);
        System.out.println("Gasto registrado con ID: " + generatedId);
    }


}

