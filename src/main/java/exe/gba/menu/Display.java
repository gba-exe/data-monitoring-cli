package exe.gba.menu;

import exe.gba.data_base.Environment;
import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.categories.Unknown;
import exe.gba.data_managing.data_access.CategoryDao;

import java.util.List;

public class Display {
    private static final CategoryDao categoryDao = new CategoryDao(Environment.getDatabase().getConnection());
    private static final List<Category> categories = categoryDao.listCategories();

    public static void displayMainMenu(){
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

            System.out.println("+---------------------------------+");
            System.out.println("| %s: ".formatted(currentCategory.getName()) + currentCategory.getValue() + currentCategory.getDataUnit());
            System.out.println("+---------------------------------+");

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
}
