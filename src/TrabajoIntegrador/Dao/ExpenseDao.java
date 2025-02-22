package TrabajoIntegrador.Dao;

import TrabajoIntegrador.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseDao {
    int save(Expense expense);  // Guarda un gasto y devuelve el ID generado.

    List<Expense> findAll();  // Obtiene todos los gastos.

    Optional<Expense> findById(int id);  // Busca un gasto por su ID.

    boolean update(Expense expense);  // Actualiza un gasto existente.

    boolean delete(int id);  // Elimina un gasto por su ID.
}
