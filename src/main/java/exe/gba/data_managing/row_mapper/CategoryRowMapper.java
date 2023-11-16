package exe.gba.data_managing.row_mapper;

import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.factories.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {

        String name = resultSet.getString("name");
        CategoryFactory categoryFactory = null;

        if (name.equalsIgnoreCase("CPU Usage")){
            categoryFactory = new CpuUsageFactory();
        } else if (name.equalsIgnoreCase("RAM Usage")){
            categoryFactory = new RamUsageFactory();
        } else if (name.equalsIgnoreCase("Total Storage")){
            categoryFactory = new TotalStorageFactory();
        } else if (name.equalsIgnoreCase("Available Storage")){
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
