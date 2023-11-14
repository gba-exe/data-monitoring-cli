package exe.gba;

import exe.gba.data_base.Environment;
import exe.gba.data_managing.categories.AvailableStorage;
import exe.gba.data_managing.categories.CpuUsage;
import exe.gba.data_managing.categories.RamUsage;
import exe.gba.data_managing.categories.TotalStorage;
import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.data_managing.data_access.RegisterDao;
import exe.gba.menu.Menu;

public class Main {
    public static void main(String[] args) {

        Environment.configureEnvironment();
        Menu.mainMenu();
    }
}