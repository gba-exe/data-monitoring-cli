package exe.gba.data_managing.enums;

import javax.print.DocFlavor;

public enum CategoryEnum {

    CPU_USAGE("Cpu Usage"),
    RAM_USAGE("Ram Usage"),
    AVAILABLE_STORAGE("Available Storage"),
    TOTAL_STORAGE("Total Storage");

    private String name;

    CategoryEnum(String name) {
        this.name = name;
    }

    public static CategoryEnum of(String name) {
        if (CPU_USAGE.name().equals(name)){
            return CPU_USAGE;
        } else if (RAM_USAGE.name.equals(name)){
            return RAM_USAGE;
        } else if (AVAILABLE_STORAGE.name.equals(name)) {
            return AVAILABLE_STORAGE;
        } else if (TOTAL_STORAGE.name.equals(name)) {
            return TOTAL_STORAGE;
        } else {
            return null;
        }
    }

    public String getName() {
        return name;
    }
}
