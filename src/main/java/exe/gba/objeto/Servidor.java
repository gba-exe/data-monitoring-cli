package exe.gba.objeto;

public class Servidor {
    private Integer idServidor;
    private String codigo;

    public Servidor () {}

    public Integer getIdServidor() {
        return idServidor;
    }


    public void setIdServidor(Integer idServidor) {
        this.idServidor = idServidor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Servidor{" +
                "id_servidor=" + idServidor +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
