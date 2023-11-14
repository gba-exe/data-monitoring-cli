package exe.gba.dao;

import exe.gba.objeto.Funcionario;
import exe.gba.objeto.Maquina;
import exe.gba.objeto.Opcoes;
import exe.gba.objeto.Servidor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MaquinaDao {
    private JdbcTemplate con;

    public MaquinaDao(JdbcTemplate con) {
        this.con = con;
    }

    public void inserirDados (Servidor servidor, Maquina maquina) {
        con.update("""
        INSERT INTO tb_registro VALUES(
            null,
            %d,
            now(),
            %.0f,
            %.2f,
            %.2f,
            %.2f
        );
        """.formatted(servidor.getIdServidor(),
                maquina.getPacotesEnviados(),
                maquina.getPorcentagemUsoCpu(),
                maquina.getPorcentagemUsoRam(),
                maquina.getTaxaDeTransferencia())
        );
    }
}
