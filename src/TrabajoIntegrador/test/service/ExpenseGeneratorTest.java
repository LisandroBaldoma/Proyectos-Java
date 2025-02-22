package TrabajoIntegrador.test.service;

import TrabajoIntegrador.entity.Category;
import TrabajoIntegrador.entity.Expense;
import TrabajoIntegrador.service.ExpenseGenerator;

import TrabajoIntegrador.service.ExpenseService;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseGeneratorTest {


    @Test
    @DisplayName("Generar lista de gastos aleatorios con tamaño correcto")
    void testCreateRandomExpenses() {
        // GIVEN
        int count = 5;

        // WHEN
        List<Expense> expenses = ExpenseGenerator.createRandomExpenses(count);

        // THEN
        assertEquals(count, expenses.size(), "Debe generar exactamente " + count + " gastos");
        expenses.forEach(expense -> assertNotNull(expense, "Cada gasto generado debe ser válido"));
    }

    @Test
    @DisplayName("Crear gasto aleatorio genera datos válidos")
    void testCreateRandomExpense() {
        // WHEN

        Expense expense = ExpenseGenerator.createRandomExpense();

        // THEN
        assertNotNull(expense, "El gasto generado no debe ser nulo");
        assertTrue(expense.getAmount() > 0, "El monto debe ser mayor a 0");
        assertNotNull(expense.getDate(), "La fecha no debe ser nula");
        assertNotNull(expense.getCategory(), "La categoría no debe ser nula");
        assertNotNull(expense.getDescription(), "La descripción no debe ser nula");
        assertNotNull(expense.getPaymentMethod(), "El método de pago no debe ser nulo");
        assertNotNull(expense.getCurrency(), "La moneda no debe ser nula");
        assertNotNull(expense.getTags(), "Los tags no deben ser nulos");
    }

    @Test
    @DisplayName("Validar si una categoría existe en la lista disponible")
    void testIsCategoryValid() {
        // GIVEN
        List<Category> categories = List.of(new Category("Food","Descripcion", null, "#4444", "Icon",true ),new Category("Transport","Descripcion", null, "#4444", "Icon",true ));
        ExpenseGenerator.setAvailableCategories(categories);

        // WHEN - THEN
        assertTrue(ExpenseGenerator.isCategoryValid("Food"), "Debe reconocer la categoría 'Food' como válida");
        assertTrue(ExpenseGenerator.isCategoryValid("Transport"), "Debe reconocer la categoría 'Transport' como válida");
        assertFalse(ExpenseGenerator.isCategoryValid("Shopping"), "No debe reconocer 'Shopping' si no está en la lista");
    }
}
