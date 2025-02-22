package TrabajoIntegrador.Dao.Imple;

import TrabajoIntegrador.config.JdbcConfig;

import TrabajoIntegrador.Dao.ExpenseDao;
import TrabajoIntegrador.entity.Expense;
import TrabajoIntegrador.exception.InvalidDbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpenseDaoH2Impl implements ExpenseDao {
    private static final String CREATE_TABLE_SQL = """
        CREATE TABLE IF NOT EXISTS expenses (
            id INT AUTO_INCREMENT PRIMARY KEY,
            amount DOUBLE NOT NULL,
            date DATE NOT NULL,
            category VARCHAR(255) NOT NULL,
            description VARCHAR(255),
            payment_method VARCHAR(50),
            currency VARCHAR(10),
            tags VARCHAR(255)
        )
    """;

    public ExpenseDaoH2Impl() {
        try (Connection connection = JdbcConfig.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            throw new InvalidDbConnection("Error al crear la tabla de gastos", e);
        }
    }

    @Override
    public int save(Expense expense) {

        String insertSql = "INSERT INTO expenses (amount, date, category, description, payment_method, currency, tags) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = JdbcConfig.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDouble(1, expense.getAmount());
            preparedStatement.setDate(2, Date.valueOf(expense.getDate()));
            preparedStatement.setString(3, expense.getCategory());
            preparedStatement.setString(4, expense.getDescription());
            preparedStatement.setString(5, expense.getPaymentMethod());
            preparedStatement.setString(6, expense.getCurrency());
            preparedStatement.setString(7, String.join(",", expense.getTags()));

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No se pudo guardar el gasto.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Devuelve el ID generado
                } else {
                    throw new SQLException("No se obtuvo el ID del gasto.");
                }
            }
        } catch (SQLException e) {
            throw new InvalidDbConnection("Error al guardar el gasto", e);
        }
    }

    @Override
    public List<Expense> findAll() {
        List<Expense> expenses = new ArrayList<>();
        String selectSql = "SELECT * FROM expenses";

        try (Connection connection = JdbcConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                expenses.add(mapResultSetToExpense(resultSet));
            }
        } catch (SQLException e) {
            throw new InvalidDbConnection("Error al obtener los gastos", e);
        }

        return expenses;
    }

    @Override
    public Optional<Expense> findById(int id) {
        String sql = "SELECT * FROM expenses WHERE id = ?";
        try (Connection connection = JdbcConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapResultSetToExpense(resultSet));
            }
        } catch (SQLException e) {
            throw new InvalidDbConnection("Error al buscar el gasto por ID", e);
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Expense expense) {
        String updateSQL = """
            UPDATE expenses SET 
            amount = ?, date = ?, category = ?, description = ?, payment_method = ?, currency = ?, tags = ?
            WHERE id = ?
        """;
        try (Connection connection = JdbcConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setDouble(1, expense.getAmount());
            preparedStatement.setDate(2, Date.valueOf(expense.getDate()));
            preparedStatement.setString(3, expense.getCategory());
            preparedStatement.setString(4, expense.getDescription());
            preparedStatement.setString(5, expense.getPaymentMethod());
            preparedStatement.setString(6, expense.getCurrency());
            preparedStatement.setString(7, String.join(",", expense.getTags()));
            preparedStatement.setInt(8, expense.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new InvalidDbConnection("Error al actualizar el gasto", e);
        }
    }

    @Override
    public boolean delete(int id) {
        String deleteSQL = "DELETE FROM expenses WHERE id = ?";
        try (Connection connection = JdbcConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new InvalidDbConnection("Error al eliminar el gasto", e);
        }
    }

    private Expense mapResultSetToExpense(ResultSet resultSet) throws SQLException {
        return new Expense(
                resultSet.getDouble("amount"),
                resultSet.getDate("date").toLocalDate(),
                resultSet.getString("category"),
                resultSet.getString("description"),
                resultSet.getString("payment_method"),
                resultSet.getString("currency"),
                List.of(resultSet.getString("tags").split(","))
        );
    }
}
