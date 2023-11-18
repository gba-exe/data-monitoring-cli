package exe.gba.data_base.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySQL extends Database {

    public MySQL() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_dmcli");
        dataSource.setUsername("dmcli");
        dataSource.setPassword("urubu100");

        this.setConnection(new JdbcTemplate(dataSource));
    }
}
