package exe.gba;

import exe.gba.data_base.Environment;
import exe.gba.data_managing.categories.*;
import exe.gba.data_managing.data_access.RegisterDao;
import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.data_managing.factories.AvailableStorageFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Environment.configureEnvironment();

        List<Category> categories = new ArrayList<>();
        CpuUsage cpuUsage = new CpuUsage();
        cpuUsage.setCategoryId(1);

        categories.add(cpuUsage);

        CategoryDao.loadCategories();

        System.out.println(CategoryDao.getCategories());

        CategoryDao.getCategories().get(1).setCategoryId(1);

        System.out.println(CategoryDao.getCategories());

    }
}
