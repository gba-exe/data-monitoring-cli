package exe.gba.data_base.connection;

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
}
