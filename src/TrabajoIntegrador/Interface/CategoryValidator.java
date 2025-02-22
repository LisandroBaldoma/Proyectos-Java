package TrabajoIntegrador.Interface;


import TrabajoIntegrador.entity.Category;

@FunctionalInterface
public interface CategoryValidator {
    boolean validate(Category category);
}