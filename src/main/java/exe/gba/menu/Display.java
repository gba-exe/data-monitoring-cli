package exe.gba.menu;

import exe.gba.data_base.Environment;
import exe.gba.data_base.connection.H2;
import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.categories.Unknown;
import exe.gba.data_managing.data_access.CategoryDao;

import java.util.List;

public class Display {
    private static final CategoryDao categoryDao = new CategoryDao(new H2().getConnection());
    private static List<Category> categories;

    public static void displayMainMenu(){
        categoryDao.setCon(Environment.getDatabase().getConnection());
        categories = categoryDao.listCategories();

        System.out.println("+---------------------------------+");
        for (Category currentCategory:
             categories) {
            if (!(currentCategory instanceof Unknown)){

                System.out.printf("| %d) %s%n", currentCategory.getCategoryId(), currentCategory.getName());
            }
        }
        System.out.println("""
                |                                 
                | 0) Exit                         
                +---------------------------------+
                """);
    }

    public static Boolean showData(Integer id){
        Category currentCategory = categoryDao.getCategoryById(categories, id);

        if (currentCategory instanceof Unknown || currentCategory == null){
            return false;
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

        return true;
    }

    public static void exit(){
        System.out.println("Bye :p");
    }

    public static void wrongOption(){
        System.out.println("Wrong option! ");
    }

    public final static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }
}
