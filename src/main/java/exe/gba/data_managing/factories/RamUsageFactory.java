package exe.gba.data_managing.factories;

import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.categories.RamUsage;

public class RamUsageFactory extends CategoryFactory {
    @Override
    public Category createCategory() {
        return new RamUsage();
    }

    @Override
    public Category createCategory(Integer categoryId, String name, String description, String dataUnit) {
        return new RamUsage(categoryId, name, description, dataUnit);
    }
}
