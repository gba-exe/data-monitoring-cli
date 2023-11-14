package exe.gba.menu;

import exe.gba.data_base.Environment;
import exe.gba.data_base.connection.H2;
import exe.gba.data_base.connection.MySQL;
import exe.gba.data_managing.factories.*;

public class Menu {

    public static void mainMenu(){
        int option;

        CategoryFactory categoryFactory = null;


        while (true){
            Display.clearConsole();

            Display.displayMainMenu();
            option = Input.readInt();

            Boolean isValid = Display.showData(option);

            if (option == 0){
                Display.exit();

                System.exit(0);
            }

            if (isValid == false){
                Display.wrongOption();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    public static void setEnvironment(){
        Display.clearConsole();

        while (true){

            System.out.println("Choose environment: ");
            System.out.println("(1: Local / 2: Remote Database) ");
            int option = Input.readInt();

            if (option == 1){
                Environment.setDatabase(new H2());
                return;
            } else if (option == 2){
                Environment.setDatabase(new MySQL());
                return;
            } else {
                Display.clearConsole();
                Display.wrongOption();
            }
        }
    }

    private static void showData(Integer id){
        Display.clearConsole();
        Display.showData(id);
    }
}
