package exe.gba.data_managing.categories;

public class Unknown extends Category{

    public Unknown() {
    }

    public Unknown(Integer categoryId, String name, String description, String dataUnit) {
        super(categoryId, name, description, dataUnit);
    }

    @Override
    public double getValue() {
        return 0;
    }
}
