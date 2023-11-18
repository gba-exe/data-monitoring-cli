package exe.gba.data_managing.row_mapper;

import exe.gba.monitorable.categories.*;
import exe.gba.data_managing.enums.CategoryEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {

        String name = resultSet.getString("name");
        Category category = null;


        if (name.equalsIgnoreCase(CategoryEnum.CPU_USAGE.getName())){
            category = new CpuUsage(
                resultSet.getInt("category_id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("data_unit"));
        } else if (name.equalsIgnoreCase(CategoryEnum.RAM_USAGE.getName())){
            category = new RamUsage(
                resultSet.getInt("category_id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("data_unit"));
        } else if (name.equalsIgnoreCase(CategoryEnum.TOTAL_STORAGE.getName())){
            category = new TotalStorage(
                resultSet.getInt("category_id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("data_unit"));
        } else if (name.equalsIgnoreCase(CategoryEnum.AVAILABLE_STORAGE.getName())){
            category = new AvailableStorage(
                resultSet.getInt("category_id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("data_unit"));
        } else {
            return null;
        }

        return category;
    }
}
