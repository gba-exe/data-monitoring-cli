package exe.gba.data_managing.categories;

public abstract class Category {

    private Integer categoryId;
    private String name;
    private String description;
    private String dataUnit;
    private Double value;

    public Category() {
    }

    public Category(Integer categoryId, String name, String description, String dataUnit) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.dataUnit = dataUnit;
    }

    public abstract double getValue();

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nCategory{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dataUnit='" + dataUnit + '\'' +
                '}';
    }
}
