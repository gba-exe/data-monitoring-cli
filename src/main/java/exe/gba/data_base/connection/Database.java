package exe.gba.data_base.connection;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class Database {

    private JdbcTemplate connection;

    public JdbcTemplate getConnection() {
        return connection;
    }

    public void setConnection(JdbcTemplate conexao) {
        this.connection = conexao;
    }
}
