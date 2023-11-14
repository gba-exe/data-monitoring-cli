package exe.gba.utils;

public class Converter {
    public static double convertGB(long bytes){
        return bytes / Math.pow(1024, 3);
    }
    public static double convertMB(long bytes){
        return bytes / Math.pow(1024, 2);
    }
}
