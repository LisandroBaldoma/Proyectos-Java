package Jdbcdao.src.service.phone;

import Jdbcdao.src.dao.PhoneDao;

import Jdbcdao.src.entity.Phone;

import java.util.List;
import java.util.Optional;

public class PhoneService {

    PhoneDao phoneDao;

    public PhoneService () {
        phoneDao = new PhoneDao() {
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
        };
    }

    public int savePhone(String modelName, int stock) {
        return phoneDao.save(modelName, stock);
    }

    public List<Phone> findAllPhones() {
        // Condicionales
        return phoneDao.findAll();
    }

    public Optional<Phone> getPhoneById(long id) {
        // Transformando datos para devoler al cliente
        return phoneDao.findById(id);
    }

    public boolean updateStockById(long id, int newStock) {
        return phoneDao.updateStockById(id, newStock);
    }
}
