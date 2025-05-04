package com.managers;

import com.models.myCategory;
import com.services.Database;

import java.util.Locale;

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

    public static boolean isValid(String category) {
        var categories = Database.getCategoryList();
        for (var cat : categories) {
            if (category.equals(cat.getName())) {
                return true;
            }
        }
        return false;
    }


}