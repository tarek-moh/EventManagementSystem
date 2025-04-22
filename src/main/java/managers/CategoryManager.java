package managers;

import models.myCategory;
import services.Database;

public class CategoryManager {
    public static void showAllCategories() {
        var categories = Database.getCategoryList();
        if (categories.isEmpty()) {
            System.out.println("No categories available.");
        } else {
            System.out.println("Categories:");
            for (myCategory c : categories) {
                System.out.println("- " + c.getName());
            }
        }
    }


}