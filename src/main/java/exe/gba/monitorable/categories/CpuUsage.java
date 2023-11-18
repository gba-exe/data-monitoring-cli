package exe.gba.monitorable.categories;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;

public class CpuUsage extends Category {
    private Processador cpu = new Looca().getProcessador();

    public CpuUsage() {
    }

    public CpuUsage(Integer categoryId, String name, String description, String dataUnit) {
        super(categoryId, name, description, dataUnit);
    }

    @Override
    public double getValue() {
        return cpu.getUso();
    }
}
