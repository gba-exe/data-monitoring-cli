package exe.gba.menu;

import exe.gba.data_base.Environment;
import exe.gba.data_base.connection.H2;
import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.categories.Unknown;
import exe.gba.data_managing.data_access.CategoryDao;

import java.util.List;
import java.util.Objects;

public class Display {

    public static void mainMenu(){
        System.out.printf("+%s+%n", "-".repeat(40));

        List<Category> categories = CategoryDao.getCategories();

        int i = 0;
        for (Category currentCategory : categories) {

            i++;
            System.out.printf("| %d) %s%n", i, currentCategory.getName());
            currentCategory.setCategoryId(i);
        }

        CategoryDao.loadCategories(categories);

        System.out.printf("|%n| 0) Leave%n");
        System.out.printf("+%s+%n", "-".repeat(40));
    }

    public static void showData(int id){

        Category currentCategory;

        try {

            currentCategory = CategoryDao.getCategories().get(id - 1);
        } catch (IndexOutOfBoundsException e){

            Display.wrongOption();
            return;
        }

        for (int i = 0; i < 10; i++) {
            clearConsole();

            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("| %s: ".formatted(currentCategory.getName()) + currentCategory.getValue() + currentCategory.getDataUnit());
            System.out.println("+------------------------------------------------------------------------+");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void exit(){
        System.out.println("Bye :p");
    }

    public static void wrongOption(){
        System.out.println("Wrong option! ");
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }
}
