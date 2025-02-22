package TrabajoIntegrador.test.service;

import TrabajoIntegrador.entity.Expense;
import TrabajoIntegrador.service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;


@DisplayName("Pruebas para ExpenseService")

class ExpenseServiceTest {

    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseService();
    }

    @Test
    @DisplayName("Calcular el total de gastos")
    void testCalculateTotal() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(100.0, LocalDate.now(), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante")),
                new Expense(50.0, LocalDate.now(), "transporte", "Taxi", "efectivo", "USD", List.of("movilidad")),
                new Expense(200.0, LocalDate.now(), "compras", "Ropa", "tarjeta", "USD", List.of("ropa"))
        );

        // WHEN
        double total = expenseService.calculateTotal(expenses);

        // THEN
        assertEquals(350.0, total);
    }

    @Test
    @DisplayName("Calcular total con lista vacía")
    void testCalculateTotal_EmptyList() {
        // GIVEN
        List<Expense> expenses = List.of(); // Lista vacía

        // WHEN
        double total = expenseService.calculateTotal(expenses);

        // THEN
        assertEquals(0.0, total, "El total de una lista vacía debe ser 0.0");
    }

    @Test
    @DisplayName("Calcular total con valores negativos")
    void testCalculateTotal_WithNegativeValues() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(100.0, LocalDate.now(), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante")),
                new Expense(-50.0, LocalDate.now(), "reembolso", "Devolución", "tarjeta", "USD", List.of("error")),
                new Expense(200.0, LocalDate.now(), "compras", "Ropa", "tarjeta", "USD", List.of("ropa"))
        );

        // WHEN
        double total = expenseService.calculateTotal(expenses);

        // THEN
        assertEquals(250.0, total, "El total debe restar los valores negativos");
    }

    @Test
    @DisplayName("Filtrar por categoría con lista vacía")
    void testFilterByCategory_EmptyList() {
        // GIVEN
        List<Expense> expenses = List.of();

        // WHEN
        List<Expense> result = expenseService.filterByCategory(expenses, "comida");

        // THEN
        assertTrue(result.isEmpty(), "Debe devolver una lista vacía si no hay gastos");
    }

    @Test
    @DisplayName("Filtrar gastos por categoría existente")
    void testFilterByCategory_Existing() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(50.0, LocalDate.now(), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante")),
                new Expense(100.0, LocalDate.now(), "transporte", "Taxi", "efectivo", "USD", List.of("movilidad")),
                new Expense(30.0, LocalDate.now(), "comida", "Cena", "tarjeta", "USD", List.of("delivery"))
        );

        // WHEN
        List<Expense> result = expenseService.filterByCategory(expenses, "comida");

        // THEN
        assertEquals(2, result.size(), "Debe devolver exactamente 2 gastos de 'comida'");
        assertEquals("comida", result.get(0).getCategory(), "Los gastos deben ser de la categoría 'comida'");
    }

    @Test
    @DisplayName("Filtrar por categoría inexistente")
    void testFilterByCategory_NonExisting() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(50.0, LocalDate.now(), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante")),
                new Expense(100.0, LocalDate.now(), "transporte", "Taxi", "efectivo", "USD", List.of("movilidad"))
        );

        // WHEN
        List<Expense> result = expenseService.filterByCategory(expenses, "educación");

        // THEN
        assertTrue(result.isEmpty(), "Debe devolver una lista vacía si la categoría no existe");
    }

    @Test
    @DisplayName("Filtrar por categoría ignorando mayúsculas/minúsculas")
    void testFilterByCategory_CaseInsensitive() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(50.0, LocalDate.now(), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante")),
                new Expense(100.0, LocalDate.now(), "Comida", "Cena", "efectivo", "USD", List.of("cena"))
        );

        // WHEN
        List<Expense> result = expenseService.filterByCategory(expenses, "COMIDA");

        // THEN
        assertEquals(2, result.size(), "Debe devolver los 2 gastos, sin importar mayúsculas");
    }

    @Test
    @DisplayName("Filtrar por rango de fechas con lista vacía")
    void testFilterByDateRange_EmptyList() {
        // GIVEN
        List<Expense> expenses = List.of();
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);

        // WHEN
        List<Expense> result = expenseService.filterByDateRange(expenses, start, end);

        // THEN
        assertTrue(result.isEmpty(), "Debe devolver una lista vacía si no hay gastos");
    }

    @Test
    @DisplayName("Filtrar gastos dentro del rango de fechas")
    void testFilterByDateRange_WithinRange() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(50.0, LocalDate.of(2024, 1, 5), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante")),
                new Expense(100.0, LocalDate.of(2024, 1, 15), "transporte", "Taxi", "efectivo", "USD", List.of("movilidad")),
                new Expense(30.0, LocalDate.of(2024, 2, 1), "comida", "Cena", "tarjeta", "USD", List.of("delivery"))
        );
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);

        // WHEN
        List<Expense> result = expenseService.filterByDateRange(expenses, start, end);

        // THEN
        assertEquals(2, result.size(), "Debe devolver 2 gastos dentro del rango");
    }

    @Test
    @DisplayName("Filtrar por rango de fechas sin coincidencias")
    void testFilterByDateRange_NoMatches() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(50.0, LocalDate.of(2023, 12, 15), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante")),
                new Expense(100.0, LocalDate.of(2023, 12, 20), "transporte", "Taxi", "efectivo", "USD", List.of("movilidad"))
        );
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);

        // WHEN
        List<Expense> result = expenseService.filterByDateRange(expenses, start, end);

        // THEN
        assertTrue(result.isEmpty(), "Debe devolver una lista vacía si ningún gasto está en el rango");
    }

    @Test
    @DisplayName("Filtrar gastos en los límites del rango")
    void testFilterByDateRange_LimitsIncluded() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(50.0, LocalDate.of(2024, 1, 1), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante")),
                new Expense(100.0, LocalDate.of(2024, 1, 31), "transporte", "Taxi", "efectivo", "USD", List.of("movilidad"))
        );
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);

        // WHEN
        List<Expense> result = expenseService.filterByDateRange(expenses, start, end);

        // THEN
        assertEquals(2, result.size(), "Debe incluir los gastos en la fecha exacta de los límites");
    }

    @Test
    @DisplayName("Filtrar por rango de fechas con start > end")
    void testFilterByDateRange_InvalidRange() {
        // GIVEN
        List<Expense> expenses = List.of(
                new Expense(50.0, LocalDate.of(2024, 1, 5), "comida", "Almuerzo", "tarjeta", "USD", List.of("restaurante"))
        );
        LocalDate start = LocalDate.of(2024, 1, 31);
        LocalDate end = LocalDate.of(2024, 1, 1);

        // WHEN
        List<Expense> result = expenseService.filterByDateRange(expenses, start, end);

        // THEN
        assertTrue(result.isEmpty(), "Debe devolver una lista vacía si el rango es inválido (start > end)");
    }





}