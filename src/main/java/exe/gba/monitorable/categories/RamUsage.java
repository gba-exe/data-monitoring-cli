package exe.gba.monitorable.categories;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;

public class RamUsage extends Category{
    private Memoria ram = new Looca().getMemoria();

    public RamUsage() {
    }

    public RamUsage(Integer categoryId, String name, String description, String dataUnit) {
        super(categoryId, name, description, dataUnit);
    }

    @Override
    public double getValue() {
        return ram.getEmUso();
    }
}
