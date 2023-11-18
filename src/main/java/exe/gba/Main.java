package exe.gba;

import exe.gba.data_base.Environment;
import exe.gba.menu.Menu;

public class Main {
    public static void main(String[] args) {

        Environment.configureEnvironment();
        Menu.mainMenu();
    }
}