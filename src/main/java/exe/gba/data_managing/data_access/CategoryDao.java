package exe.gba.data_managing.data_access;

import exe.gba.data_base.row_mapper.CategoryRowMapper;
import exe.gba.data_managing.categories.Category;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDao {

    private static JdbcTemplate con;

    public CategoryDao() {
    }

    public CategoryDao(JdbcTemplate con) {
        this.con = con;
    }

    public void insertCategory(Category category) {

        con.update("""
        insert into tb_category(name, description, data_unit) values (?, ?,?)""",
                category.getName(), category.getDescription(), category.getDataUnit());
    }

    public List<Category> listCategories(){

        return con.query("SELECT * FROM tb_category;", new CategoryRowMapper());
    }

    public List<Category> getCategoryById(Integer id){

        return con.query("SELECT * FROM tb_category WHERE category_id = ?;", new CategoryRowMapper(), id);
    }

    public Category getCategoryById(List<Category> categories, Integer id){

        for (Category currentCategory :
                categories) {
            if (currentCategory.getCategoryId().equals(id)){
                return currentCategory;
            }
        }

        return null;
    }

    public static JdbcTemplate getCon() {
        return con;
    }

    public static void setCon(JdbcTemplate con) {
        CategoryDao.con = con;
    }
}
