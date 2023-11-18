package exe.gba.monitorable.categories;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;

public class TotalStorage extends Category{

    private DiscoGrupo diskGroup = new Looca().getGrupoDeDiscos();

    public TotalStorage() {
    }

    public TotalStorage(Integer categoryId, String name, String description, String dataUnit) {
        super(categoryId, name, description, dataUnit);
    }

    @Override
    public double getValue() {
        return diskGroup.getTamanhoTotal();
    }
}
