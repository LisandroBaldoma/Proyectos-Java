package Jdbcdao.src.entity;

public class Phone {
    private long id;
    private String modelName;
    private int stock;

    public Phone(String modelName, int stock) {
        this.modelName = modelName;
        this.stock = stock;
    }

    public Phone(long id, String modelName, int stock) {
        this.id = id;
        this.modelName = modelName;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public int getStock() {
        return stock;
    }
}
