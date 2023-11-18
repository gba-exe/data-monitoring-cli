package exe.gba.monitorable.categories;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import exe.gba.utils.Converter;

import java.util.List;

public class AvailableStorage extends Category{
    private DiscoGrupo diskGroup = new Looca().getGrupoDeDiscos();
    private List<Volume> volumes = diskGroup.getVolumes();

    public AvailableStorage() {
    }

    public AvailableStorage(Integer categoryId, String name, String description, String dataUnit) {
        super(categoryId, name, description, dataUnit);
    }

    @Override
    public double getValue() {
        long sizeAvailable = 0;

        for (Volume volume :
                volumes) {
            sizeAvailable += volume.getDisponivel();
        }

        return Converter.convertGB(sizeAvailable);
    }
}
