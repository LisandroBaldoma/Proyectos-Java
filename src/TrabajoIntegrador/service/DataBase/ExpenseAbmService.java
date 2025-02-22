package TrabajoIntegrador.service.DataBase;

import TrabajoIntegrador.Dao.ExpenseDao;
import TrabajoIntegrador.Dao.Imple.ExpenseDaoH2Impl;
import TrabajoIntegrador.Dao.Imple.ExpenseDaoListImpl;
import TrabajoIntegrador.entity.Expense;

import java.util.List;
import java.util.Optional;

public class ExpenseAbmService {

    ExpenseDao expenseDao;

    public ExpenseAbmService(ExpenseDao expenseDao) {
        //expenseDao = new ExpenseDaoH2Impl();
        this.expenseDao = expenseDao;

    }

    public int saveExpense(Expense expense) {
        return expenseDao.save(expense);
    }

    public List<Expense> findAllExpenses() {
        return expenseDao.findAll();
    }

    public Optional<Expense> getExpenseById(int id) {
        return expenseDao.findById(id);
    }

    public boolean updateExpense(Expense expense) {
        return expenseDao.update(expense);
    }

    public boolean deleteExpense(int id) {
        return expenseDao.delete(id);
    }
}
