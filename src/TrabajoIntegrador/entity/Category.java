package TrabajoIntegrador.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;              // Nombre de la categoría
    private String description;       // Descripción de la categoría
    private Category parentCategory;  // Categoría principal (para jerarquías)
    private String color;             // Color representativo (e.g., en formato HEX #RRGGBB)
    private String icon;              // Ícono representativo (e.g., URL o nombre del recurso)
    private boolean isActive;         // Indica si la categoría está activa


    public Category(String name, String description, Category parentCategory, String color, String icon, boolean isActive) {

        this.name = name.toLowerCase();
        this.description = description;
        this.parentCategory = parentCategory;
        this.color = color;
        this.icon = icon;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parentCategory=" + parentCategory +
                ", color='" + color + '\'' +
                ", icon='" + icon + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}




