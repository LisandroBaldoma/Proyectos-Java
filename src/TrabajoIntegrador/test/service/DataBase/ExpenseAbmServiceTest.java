package TrabajoIntegrador.test.service.DataBase;

import TrabajoIntegrador.Dao.ExpenseDao;
import TrabajoIntegrador.entity.Expense;
import TrabajoIntegrador.service.DataBase.ExpenseAbmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

@ExtendWith(MockitoExtension.class)
class ExpenseAbmServiceTest {


    @Mock
    private ExpenseDao expenseDao;  // Simulamos la dependencia

    @InjectMocks
    private ExpenseAbmService expenseService;  // Probamos esta clase

    private Expense testExpense;

    ExpenseAbmServiceTest(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        testExpense = new Expense(100.0, LocalDate.now(), "Food", "Lunch", "Cash", "USD", List.of("test"));
    }

    @Test
    @DisplayName("Test para guardar una Expense")
    void testSaveExpense() {
        // GIVEN

        when(expenseDao.save(testExpense)).thenReturn(1);  // Simulamos que devuelve ID 1

        // WHEN
        int result = expenseService.saveExpense(testExpense);

        // THEN
        assertEquals(1, result);
        verify(expenseDao).save(testExpense); // Verifica que el método se llamó
    }

    @Test
    @DisplayName("Test para obtener todas las expenses")
    void testFindAllExpenses() {
        // GIVEN (Datos simulados)
        List<Expense> mockExpenses = List.of(
                new Expense(100.0, LocalDate.now(), "Food", "Lunch", "Cash", "USD", List.of("work")),
                new Expense(50.0, LocalDate.now().minusDays(1), "Transport", "Taxi", "Credit Card", "USD", List.of("travel"))
        );

        when(expenseDao.findAll()).thenReturn(mockExpenses);  // Simula el DAO devolviendo datos

        // WHEN
        List<Expense> result = expenseService.findAllExpenses();

        // THEN
        assertEquals(2, result.size());
        assertEquals("food", result.get(0).getCategory());
        assertEquals("transport", result.get(1).getCategory());

        verify(expenseDao).findAll();  // Verifica que el método fue llamado
    }

    @Test
    @DisplayName("Obtener un gasto por ID cuando existe")
    void testGetExpenseById_Found() {
        //Expense testExpense = new Expense(100.0, LocalDate.now(), "Food", "Lunch", "Cash", "USD", List.of("test"));
        // GIVEN
        when(expenseDao.findById(1)).thenReturn(Optional.of(testExpense));

        // WHEN
        Optional<Expense> result = expenseService.getExpenseById(1);

        // THEN
        assertTrue(result.isPresent());
        assertEquals(testExpense, result.get());

        verify(expenseDao).findById(1);
    }

    @Test
    @DisplayName("Obtener un gasto por ID cuando no existe")
    void testGetExpenseById_NotFound() {
        // GIVEN
        when(expenseDao.findById(99)).thenReturn(Optional.empty());

        // WHEN
        Optional<Expense> result = expenseService.getExpenseById(99);

        // THEN
        assertFalse(result.isPresent());

        verify(expenseDao).findById(99);
    }

    @Test
    @DisplayName("Actualizar un gasto existente con éxito")
    void testUpdateExpense_Success() {
        // GIVEN
        when(expenseDao.update(testExpense)).thenReturn(true);

        // WHEN
        boolean result = expenseService.updateExpense(testExpense);

        // THEN
        assertTrue(result);

        verify(expenseDao).update(testExpense);
    }

    @Test
    @DisplayName("Intentar actualizar un gasto inexistente")
    void testUpdateExpense_Failure() {
        // GIVEN
        when(expenseDao.update(testExpense)).thenReturn(false);

        // WHEN
        boolean result = expenseService.updateExpense(testExpense);

        // THEN
        assertFalse(result);

        verify(expenseDao).update(testExpense);
    }


    @Test
    @DisplayName("Eliminar un gasto exitosamente")
    void testDeleteExpense_Success() {
        // GIVEN
        when(expenseDao.delete(1)).thenReturn(true);

        // WHEN
        boolean result = expenseService.deleteExpense(1);

        // THEN
        assertTrue(result);

        verify(expenseDao).delete(1);
    }

    @Test
    @DisplayName("Intentar eliminar un gasto que no existe")
    void testDeleteExpense_Failure() {
        // GIVEN
        when(expenseDao.delete(99)).thenReturn(false);

        // WHEN
        boolean result = expenseService.deleteExpense(99);

        // THEN
        assertFalse(result);

        verify(expenseDao).delete(99);
    }
}
