package exe.gba.data_managing.factories;

import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.categories.CpuUsage;

public class CpuUsageFactory extends CategoryFactory {
    @Override
    public Category createCategory() {
        return new CpuUsage();
    }

    @Override
    public Category createCategory(Integer categoryId, String name, String description, String dataUnit) {
        return new CpuUsage(categoryId, name, description, dataUnit);
    }
}
