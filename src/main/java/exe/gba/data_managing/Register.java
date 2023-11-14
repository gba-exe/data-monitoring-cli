package exe.gba.data_managing;

public class Register {
    private Integer registerId;
    private Double registerValue;
    private Integer fkCategory;

    public Register() {
    }

    public Register(Integer registerId, Double value, Integer fkCategory) {
        this.registerId = registerId;
        this.registerValue = value;
        this.fkCategory = fkCategory;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Double getRegisterValue() {
        return registerValue;
    }

    public void setRegisterValue(Double registerValue) {
        this.registerValue = registerValue;
    }

    public Integer getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(Integer fkCategory) {
        this.fkCategory = fkCategory;
    }

    @Override
    public String toString() {
        return "\nRegister{" +
                "registerId=" + registerId +
                ", registerValue=" + registerValue +
                ", fkCategory=" + fkCategory +
                "}";
    }
}
