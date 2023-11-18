package exe.gba.data_managing.data_access;

import exe.gba.data_managing.Register;
import exe.gba.monitorable.categories.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RegisterDao {

    private static JdbcTemplate con;

    public RegisterDao(JdbcTemplate con) {
        this.con = con;
    }

    public static void insertValues(Category category) {

        con.update("""
        INSERT INTO tb_register(register_value, date_time, fk_category) VALUES (
        ?,
        now(),
        ?
        );
        """, category.getValue(), category.getCategoryId());
    }

    public static List<Register> listRegisters(){

        return con.query("SELECT * FROM tb_register;", new BeanPropertyRowMapper<>(Register.class));
    }

    public static JdbcTemplate getCon() {
        return con;
    }

    public static void setCon(JdbcTemplate con) {
        RegisterDao.con = con;
    }
}
