package exe.gba.tasks;

import exe.gba.data_managing.data_access.CategoryDao;
import exe.gba.data_managing.data_access.RegisterDao;
import exe.gba.monitorable.categories.Category;

import java.util.List;
import java.util.TimerTask;

public class SaveData extends TimerTask {

    @Override
    public void run() {
        List<Category> categories = CategoryDao.getCategories();

        for (Category currentCategory : categories) {

            RegisterDao.insertValues(currentCategory);
        }
    }
}
