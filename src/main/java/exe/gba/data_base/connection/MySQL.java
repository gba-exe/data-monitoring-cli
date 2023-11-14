package exe.gba.data_base.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySQL extends Database {

    public MySQL() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/teste_dinamismo");
        dataSource.setUsername("cleiyton");
        dataSource.setPassword("1234");

        this.setConnection(new JdbcTemplate(dataSource));
    }
}
