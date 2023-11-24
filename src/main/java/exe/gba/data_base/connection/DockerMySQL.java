package exe.gba.data_base.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DockerMySQL extends Database{

    public DockerMySQL() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://mysql:3306/db_dmcli");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");

        this.setConnection(new JdbcTemplate(dataSource));
    }
}
