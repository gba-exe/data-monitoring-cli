package exe.gba.data_base;

import exe.gba.data_base.connection.Database;
import exe.gba.data_base.connection.H2;
import exe.gba.data_managing.categories.AvailableStorage;
import exe.gba.data_managing.categories.CpuUsage;
import exe.gba.data_managing.categories.RamUsage;
import exe.gba.data_managing.categories.TotalStorage;
import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.data_managing.data_access.RegisterDao;
import exe.gba.menu.Menu;
import org.springframework.jdbc.core.JdbcTemplate;

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
        createH2Database(con);
    }

    public static Database getDatabase() {
        configureEnvironment();

        return database;
    }

    public static void setDatabase(Database database) {
        Environment.database = database;
    }

    public static void createH2Database(JdbcTemplate con){
        if (database instanceof H2){

            con.execute("drop table if exists tb_register");
            con.execute("drop table if exists tb_category");


            con.execute("""
                    CREATE TABLE tb_category (
                    category_id int primary key not null auto_increment,
                    name varchar(45) not null,
                    description varchar(100) not null,
                    data_unit varchar(20) not null 
                    );
                    """);

            con.execute("""
                    CREATE TABLE tb_register (
                   register_id int primary key not null auto_increment,
                   register_value double precision not null,
                   fk_category int not null,
                   foreign key (fk_category) references tb_category(category_id)
                   );
                    """);

            CategoryDao.insertCategory(new AvailableStorage(null, "Available Storage","Available Storage of all volumes", "GB"));
            CategoryDao.insertCategory(new TotalStorage(null, "Total Storage","Sumo of Storage of all volumes","GB"));
            CategoryDao.insertCategory(new CpuUsage(null, "CPU Usage","Usage of processor resources","%"));
            CategoryDao.insertCategory(new RamUsage(null, "RAM Usage","Usage of RAM resources","%"));
        }
    }
}
