package Jdbcdao.src.dao.impl;


import Jdbcdao.src.dao.PhoneDao;
import Jdbcdao.src.entity.Phone;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class PhoneDaoSQLServerImpl implements PhoneDao {

    @Override
    public int save(String modelName, int stock) {
        return 0;
    }

    @Override
    public List<Phone> findAll() {
        return List.of();
    }

    @Override
    public Optional<Phone> findById(long id) {
        return Optional.empty();
    }

    @Override
    public boolean updateStockById(long id, int newStock) {
        return false;
    }
}
