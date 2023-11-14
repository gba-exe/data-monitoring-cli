package exe.gba.data_base;

import exe.gba.data_base.connection.Database;
import exe.gba.data_base.connection.H2;
import exe.gba.data_base.connection.MySQL;
import exe.gba.data_base.row_mapper.CategoryRowMapper;
import exe.gba.data_managing.categories.AvailableStorage;
import exe.gba.data_managing.categories.CpuUsage;
import exe.gba.data_managing.categories.RamUsage;
import exe.gba.data_managing.categories.TotalStorage;
import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.menu.Display;
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

        if (database instanceof H2){
            JdbcTemplate con = database.getConnection();
            System.out.println(database);
            CategoryDao categoryDao = new CategoryDao(con);

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

            categoryDao.insertCategory(new AvailableStorage(null, "Available Storage","Available Storage of all volumes", "GB"));
            categoryDao.insertCategory(new TotalStorage(null, "Total Storage","Sumo of Storage of all volumes","GB"));
            categoryDao.insertCategory(new CpuUsage(null, "CPU Usage","Usage of processor resources","%"));
            categoryDao.insertCategory(new RamUsage(null, "RAM Usage","Usage of RAM resources","%"));
        }
    }

    public static Database getDatabase() {
        if (database == null){
            Menu.setEnvironment();
        }
        return database;
    }

    public static void setDatabase(Database database) {
        Environment.database = database;
    }
}
