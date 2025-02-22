package Leccion1POO;
abstract class Person {
    private String name;
    private Integer age;

    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //METODOS = ACCIONES / COMUNICACION
    public abstract void displayInfo();
    public abstract void displayInfo(String name);
    public abstract void displayInfo(String name, Integer age);
}
