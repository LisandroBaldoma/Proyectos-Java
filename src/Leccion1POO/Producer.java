package Leccion1POO;
public class Producer extends Person{
    private Integer yearsOfExperience;

    public Producer() {
    }

    //CONSTRUCTOR COMPLETO
    public Producer(String name, Integer age, Integer yearsOfExperience) {
        super(name, age);
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void displayInfo() {
        System.out.println("Productor: " + getName()
                + ", Edad:" + getAge()
                + ", Años de experiencia: " + getYearsOfExperience());
    }

    @Override
    public void displayInfo(String name) {
        System.out.println("Productor: " + name);
    }

    @Override
    public void displayInfo(String name, Integer age) {
        System.out.println("Productor: " + name
                + ", Edad:" + age);
    }
}
