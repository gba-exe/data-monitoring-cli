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

            Display.displayMainMenu();
            option = Input.readInt();

            Boolean isValid = Display.showData(option);

            if (option == 0){
                Display.exit();

                System.exit(0);
            }

            if (isValid == false){
                Display.wrongOption();
            }
        }

    }

    public static void setEnvironment(){

        while (true){

            System.out.println("Choose environment: ");
            System.out.println("(1: Development / 2: Production) ");
            int option = Input.readInt();

            if (option == 1){
                Environment.setDatabase(new H2());
                return;
            } else if (option == 2){
                Environment.setDatabase(new MySQL());
                return;
            }

            Display.wrongOption();
        }
    }

    private static void showData(Integer id){

        Display.showData(id);
    }
}
