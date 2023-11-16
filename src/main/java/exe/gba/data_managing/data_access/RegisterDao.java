package exe.gba.data_managing.data_access;

import exe.gba.data_managing.Register;
import exe.gba.data_managing.categories.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RegisterDao {

    private JdbcTemplate con;

    public RegisterDao(JdbcTemplate con) {
        this.con = con;
    }

    public void insertValues(Category category) {

        con.update("""
        INSERT INTO tb_register(register_value, fk_category) VALUES (
        ?,
        ?
        );
        """, category.getValue(), category.getCategoryId());
    }

    public List<Register> listRegisters(){

        return con.query("SELECT * FROM tb_register;", new BeanPropertyRowMapper<>(Register.class));
    }
}
