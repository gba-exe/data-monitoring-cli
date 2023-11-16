package exe.gba.menu;

import exe.gba.data_base.Environment;
import exe.gba.data_base.connection.H2;
import exe.gba.data_base.connection.MySQL;
import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.data_managing.factories.*;

import java.util.List;

public class Menu {

    public static void mainMenu(){
        int option;

        do {
            Display.clearConsole();

            Display.mainMenu();
            option = Input.readInt();

            Display.showData(option);
        } while (option != 0);

        Display.exit();
        System.exit(2);
    }

    public static void setEnvironment(){
        Display.clearConsole();

        int option;
        do {
            System.out.println("Choose environment: ");
            System.out.println("(1: Local / 2: Remote Database) ");
            option = Input.readInt();

            if (option == 1) {

                Environment.setDatabase(new H2());
                return;
            } else if (option == 2) {

                Environment.setDatabase(new MySQL());
                return;
            } else {

                Display.clearConsole();
                Display.wrongOption();
            }
        } while (true);
    }
}
