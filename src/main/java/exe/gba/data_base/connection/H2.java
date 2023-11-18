package exe.gba.data_base.connection;

import exe.gba.data_base.Environment;
import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.monitorable.categories.AvailableStorage;
import exe.gba.monitorable.categories.CpuUsage;
import exe.gba.monitorable.categories.RamUsage;
import exe.gba.monitorable.categories.TotalStorage;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class H2 extends Database {

    public H2() {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:h2:file:./dmcli");
            dataSource.setDriverClassName("org.h2.Driver");
            dataSource.setUsername("sa");
            dataSource.setPassword("");

            this.setConnection(new JdbcTemplate(dataSource));
    }

    public static void createDatabase(JdbcTemplate con) {
        if (Environment.getDatabase() instanceof H2) {

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
                    register_value double precision,
                    fk_category int not null,
                    foreign key (fk_category) references tb_category(category_id)
                    );
                      """);

            CategoryDao.insertCategory(new AvailableStorage(null, "Available Storage","Available Storage of all  volumes", "GB"));
            CategoryDao.insertCategory(new TotalStorage(null, "Total Storage","Sumo of Storag e of all volumes","GB"));
            CategoryDao.insertCategory(new CpuUsage(null, "CPU Usage","Usage of pr ocessor resources","%"));
            CategoryDao.insertCategory(new RamUsage(null, "RAM Usage","Usage of RAM resources","%"));
        }
    }
}
