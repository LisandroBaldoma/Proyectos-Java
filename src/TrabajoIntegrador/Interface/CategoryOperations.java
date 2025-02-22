package TrabajoIntegrador.Interface;

import TrabajoIntegrador.entity.Category;
import java.util.List;
import java.util.Map;

public interface CategoryOperations {
    void addCategory(Category category);
    void removeCategory(String categoryName);
    List<Category> loadCategories();
    Category findCategoryByName(String categoryName);
    List<Category> getAllCategories();
    Map<Category, List<Category>> buildCategoryTree();
}
