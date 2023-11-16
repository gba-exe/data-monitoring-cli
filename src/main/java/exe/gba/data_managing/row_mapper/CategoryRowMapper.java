package exe.gba.data_managing.row_mapper;

import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.enums.CategoryEnum;
import exe.gba.data_managing.factories.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {

        String name = resultSet.getString("name");
        CategoryFactory categoryFactory = null;


        if (name.equalsIgnoreCase(CategoryEnum.CPU_USAGE.getName())){
            categoryFactory = new CpuUsageFactory();
        } else if (name.equalsIgnoreCase(CategoryEnum.RAM_USAGE.getName())){
            categoryFactory = new RamUsageFactory();
        } else if (name.equalsIgnoreCase(CategoryEnum.TOTAL_STORAGE.getName())){
            categoryFactory = new TotalStorageFactory();
        } else if (name.equalsIgnoreCase(CategoryEnum.AVAILABLE_STORAGE.getName())){
            categoryFactory = new AvailableStorageFactory();
        } else {
            categoryFactory = new UnknownFactory();
        }

        return categoryFactory.createCategory(
                resultSet.getInt("category_id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("data_unit")
        );
    }
}
