package exe.gba.dao;

import exe.gba.objeto.Opcoes;

import java.io.*;
import java.util.Properties;

public class OpcoesDao {
    private Properties propriedades = new Properties();

    public void criarOpcoes() {
        new File("src/main/resources").mkdirs();

        try(OutputStream output = new FileOutputStream("src/main/resources/config.properties")) {

            propriedades.setProperty("display.usoCpu", "1");
            propriedades.setProperty("display.usoRam", "1");
            propriedades.setProperty("display.perdaPacotes", "1");
            propriedades.setProperty("display.taxaTransferencia", "1");
            propriedades.setProperty("display.armazenamentoTotal", "1");
            propriedades.setProperty("display.armazenamentoUsado", "1");

            propriedades.setProperty("maquina.codigo", "");


            propriedades.store(output, "Primeiras opcões");
        }   catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void alterarOpcoes(Opcoes opcoes) {
        try(OutputStream output = new FileOutputStream("src/main/resources/config.properties")) {

            propriedades.setProperty("display.usoCpu", opcoes.getMostrarUsoCpu());
            propriedades.setProperty("display.usoRam", opcoes.getMostrarUsoRam());
            propriedades.setProperty("display.perdaPacotes", opcoes.getMostrarPacotesEnviados());
            propriedades.setProperty("display.taxaTransferencia", opcoes.getMostrarTaxaTransferencia());
            propriedades.setProperty("display.armazenamentoTotal", opcoes.getMostrarArmazenamentoTotal());
            propriedades.setProperty("display.armazenamentoUsado", opcoes.getMostrarArmazenamentoUsado());

            propriedades.setProperty("maquina.codigo", opcoes.getCodigo());


            propriedades.store(output, "Novas opcões");
        }   catch (IOException io) {
            io.printStackTrace();
        }
    }
    
    public Opcoes carregarOpcoes () {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            propriedades.load(input);

            String mostrarUsoCpu = propriedades.getProperty("display.usoCpu");
            String mostrarUsoRam = propriedades.getProperty("display.usoRam");
            String mostrarPacotesEnviados = propriedades.getProperty("display.perdaPacotes");
            String mostrarTaxaTransferencia = propriedades.getProperty("display.taxaTransferencia");
            String mostrarArmazenamentoTotal = propriedades.getProperty("display.armazenamentoTotal");
            String mostrarArmazenamentoUsado = propriedades.getProperty("display.armazenamentoUsado");

            String codigo = propriedades.getProperty("maquina.codigo");

            Opcoes opcoes = new Opcoes(mostrarUsoCpu, mostrarUsoRam, mostrarPacotesEnviados, mostrarTaxaTransferencia, mostrarArmazenamentoTotal, mostrarArmazenamentoUsado, codigo);
            return opcoes;

        } catch (IOException ex) {
            return null;
        }
    }
}
