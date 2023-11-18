package exe.gba.data_managing.data_access;

import exe.gba.data_managing.row_mapper.CategoryRowMapper;
import exe.gba.monitorable.categories.Category;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

public class CategoryDao {

    private static JdbcTemplate con;
    private static List<Category> categories;

    public CategoryDao(JdbcTemplate con) {
        this.con = con;
    }

    public static void insertCategory(Category category) {

        con.update("""
        insert into tb_category(name, description, data_unit) values (?, ?,?)""",
                category.getName(), category.getDescription(), category.getDataUnit());
    }

    public static void loadCategories(){

        if (Objects.isNull(categories) || categories.isEmpty()){

            categories = con.query("SELECT * FROM tb_category;", new CategoryRowMapper());

            for (int i = 0; i < categories.size(); i++) {
                Category currentCategory = categories.get(i);
                if (Objects.isNull(currentCategory)){
                    categories.remove(i);
                }
            }
        }
    }
    public static void loadCategories(List<Category> categories){

        CategoryDao.categories = categories;
    }

    public static List<Category> getCategories(){
        CategoryDao.loadCategories();

        return categories;
    }

    public static List<Category> getCategoryById(Integer id){

        return con.query("SELECT * FROM tb_category WHERE category_id = ?;", new CategoryRowMapper(), id);
    }

    public static Category getCategoryById(List<Category> categories, Integer id){

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
