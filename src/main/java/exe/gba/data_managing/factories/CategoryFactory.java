package exe.gba.data_managing.factories;

import exe.gba.data_managing.categories.Category;

public abstract class CategoryFactory {
    public abstract Category createCategory();

    public abstract Category createCategory(Integer categoryId, String name, String description, String dataUnit);
}
