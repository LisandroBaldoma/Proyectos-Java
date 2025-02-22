package Jdbcdao.src.dao;

import Jdbcdao.src.entity.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneDao {
    int save(String modelName, int stock);
    List<Phone> findAll();
    //TODO: impementar los siguientes métodos
    Optional<Phone> findById(long id);
    boolean updateStockById(long id, int newStock);
}
