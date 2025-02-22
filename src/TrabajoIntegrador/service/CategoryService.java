package TrabajoIntegrador.service;

import java.util.*;

import TrabajoIntegrador.Interface.CategoryOperations;
import TrabajoIntegrador.entity.Category;

public class CategoryService implements CategoryOperations {
    private static final List<Category> categories = new ArrayList<>();

    @Override
    public void addCategory(Category category) {
        if (category != null && findCategoryByName(category.getName()) == null) {
            categories.add(category);
            System.out.println("Categoría agregada: " + category.getName());
        } else {
            System.out.println("Error: La categoría ya existe o es inválida.");
        }
    }
    @Override
    public List<Category> loadCategories() {
        List<Category> categories = new ArrayList<>();

        // Crear categorías base (sin categoría padre)
        Category food = new Category("FOOD", "Expenses related to food and dining", null, "#FF5733", "🍔", true);
        Category transport = new Category("Transport", "Expenses for travel and commuting", null, "#33C1FF", "🚗", true);
        Category entertainment = new Category("Entertainment", "Leisure and fun activities", null, "#FFC300", "🎮", true);
        Category health = new Category("Health", "Medical and wellness expenses", null, "#28B463", "💊", true);
        Category shopping = new Category("SHOPPING", "General shopping expenses", null, "#AF7AC5", "🛒", true);

        // Crear categorías con categorías padre
        Category diningOut = new Category("Dining Out", "Eating at restaurants", food, "#FF5733", "🍽️", true);
        Category groceries = new Category("Groceries", "Daily groceries and supplies", food, "#FF5733", "🛍️", true);
        Category publicTransport = new Category("Public Transport", "Buses, trains, etc.", transport, "#33C1FF", "🚎", true);
        Category fuel = new Category("FUEL", "Gasoline or diesel for vehicles", transport, "#33C1FF", "⛽", true);
        Category education = new Category("EDUCATION", "School, courses, and books", null, "#3498DB", "📚", true);

        // Agregar todas las categorías a la lista
        categories.add(food);
        categories.add(transport);
        categories.add(entertainment);
        categories.add(health);
        categories.add(shopping);
        categories.add(diningOut);
        categories.add(groceries);
        categories.add(publicTransport);
        categories.add(fuel);
        categories.add(education);

        return categories;
    }

    @Override
    public void removeCategory(String categoryName) {
        Optional<Category> categoryToRemove = categories.stream()
                .filter(c -> c.getName().equalsIgnoreCase(categoryName))
                .findFirst();

        if (categoryToRemove.isPresent()) {
            categories.remove(categoryToRemove.get());
            System.out.println("Categoría eliminada: " + categoryName);
        } else {
            System.out.println("Error: La categoría no existe.");
        }
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        return categories.stream()
                .filter(c -> c.getName().equalsIgnoreCase(categoryName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public  Map<Category, List<Category>> buildCategoryTree() {
        Map<Category, List<Category>> categoryTree = new HashMap<>();

        for (Category category : categories) {
            categoryTree.putIfAbsent(category, new ArrayList<>());
            if (category.getParentCategory() != null) {
                categoryTree.computeIfAbsent(category.getParentCategory(), k -> new ArrayList<>()).add(category);
            }
        }

        return categoryTree;
    }
}