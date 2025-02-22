package TrabajoIntegrador.Dao.Imple;


import TrabajoIntegrador.Dao.ExpenseDao;
import TrabajoIntegrador.entity.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

    public class ExpenseDaoListImpl implements ExpenseDao {

        private final List<Expense> expenses = new ArrayList<>();
        private final AtomicInteger idGenerator = new AtomicInteger(1); // Para generar IDs únicos

        @Override
        public int save(Expense expense) {
            //expense.setId(idGenerator.getAndIncrement());
            expenses.add(expense);
            return expense.getId();
        }

        @Override
        public List<Expense> findAll() {
            return new ArrayList<>(expenses); // Devolvemos una copia para evitar modificaciones externas
        }

        @Override
        public Optional<Expense> findById(int id) {
            return expenses.stream().filter(e -> e.getId() == id).findFirst();
        }

        @Override
        public boolean update(Expense expense) {
            return findById(expense.getId()).map(existing -> {
                expenses.remove(existing);
                expenses.add(expense);
                return true;
            }).orElse(false);
        }

        @Override
        public boolean delete(int id) {
            return expenses.removeIf(expense -> expense.getId() == id);
        }
}
