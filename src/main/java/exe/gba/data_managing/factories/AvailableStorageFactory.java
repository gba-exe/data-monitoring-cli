package exe.gba.data_managing.factories;

import exe.gba.data_managing.categories.AvailableStorage;
import exe.gba.data_managing.categories.Category;

public class AvailableStorageFactory extends CategoryFactory{

    @Override
    public Category createCategory() {
        return new AvailableStorage();
    }

    @Override
    public Category createCategory(Integer categoryId, String name, String description, String dataUnit) {
        return new AvailableStorage(categoryId, name, description, dataUnit);
    }
}
