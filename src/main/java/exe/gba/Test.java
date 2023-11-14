package exe.gba;

import exe.gba.data_base.Environment;
import exe.gba.data_managing.categories.*;
import exe.gba.data_managing.data_access.RegisterDao;
import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.data_managing.factories.AvailableStorageFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        Environment.configureEnvironment();

        JdbcTemplate con = Environment.getDatabase().getConnection();

        CategoryDao categoryDao = new CategoryDao(con);
        RegisterDao registerDao = new RegisterDao(con);



        List<Category> categories = categoryDao.listCategories();

        System.out.println(categories);

        int i = 1;

        for (Category currentCategory :
                categories) {
            registerDao.insertValues(currentCategory);
            i++;
        }

        System.out.println(registerDao.listRegisters());
    }
}
