package exe.gba.data_base;

import exe.gba.data_base.connection.Database;
import exe.gba.data_base.connection.H2;
import exe.gba.monitorable.categories.AvailableStorage;
import exe.gba.monitorable.categories.CpuUsage;
import exe.gba.monitorable.categories.RamUsage;
import exe.gba.monitorable.categories.TotalStorage;
import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.data_managing.data_access.RegisterDao;
import exe.gba.menu.Menu;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Objects;
import java.util.Scanner;

public class Environment {

    private static final Scanner in = new Scanner(System.in);
    private static Database database = null;

    public static void configureEnvironment(){
        if (database == null){

            setDatabase(new H2());
        }

        Menu.setEnvironment();

        JdbcTemplate con = database.getConnection();
        CategoryDao.setCon(con);
        RegisterDao.setCon(con);
        H2.createDatabase(con);
    }

    public static Database getDatabase() {
        if (Objects.isNull(database)){

            configureEnvironment();
        }

        return database;
    }

    public static void setDatabase(Database database) {
        Environment.database = database;
    }
}
