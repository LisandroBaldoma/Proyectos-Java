package TrabajoIntegrador.service;

import TrabajoIntegrador.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryGenerator {
    public static List<Category> loadCategories() {
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


}
