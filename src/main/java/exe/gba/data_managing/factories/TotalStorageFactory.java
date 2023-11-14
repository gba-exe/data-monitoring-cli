package exe.gba.data_managing.factories;

import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.categories.TotalStorage;

public class TotalStorageFactory extends CategoryFactory{

    @Override
    public Category createCategory() {
        return new TotalStorage();
    }

    @Override
    public Category createCategory(Integer categoryId, String name, String description, String dataUnit) {
        return new TotalStorage(categoryId, name, description, dataUnit);
    }
}
