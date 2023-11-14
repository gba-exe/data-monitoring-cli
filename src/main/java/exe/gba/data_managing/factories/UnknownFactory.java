package exe.gba.data_managing.factories;

import exe.gba.data_managing.categories.Category;
import exe.gba.data_managing.categories.Unknown;

public class UnknownFactory extends CategoryFactory{

    @Override
    public Category createCategory() {
        return new Unknown();
    }

    @Override
    public Category createCategory(Integer categoryId, String name, String description, String dataUnit) {
        return new Unknown(categoryId, name, description, dataUnit);
    }
}
