package exe.gba;

import exe.gba.data_base.Environment;
import exe.gba.menu.Menu;
import exe.gba.tasks.SaveData;
import exe.gba.tasks.TaskManager;

public class Main {
    public static void main(String[] args) {

        Environment.configureEnvironment();

        TaskManager.executeTask(new SaveData(), 0, 10000);

        Menu.mainMenu();
    }
}