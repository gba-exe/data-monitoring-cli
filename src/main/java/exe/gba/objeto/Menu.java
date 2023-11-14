package exe.gba.objeto;

import exe.gba.dao.FuncionarioDao;
import exe.gba.dao.MaquinaDao;
import exe.gba.dao.OpcoesDao;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    private final Scanner leitor;
    private final Scanner leitorString;
    private final FuncionarioDao funcionarioDao;
    private final OpcoesDao opcoesDao;
    private final Maquina maquina;


    public Menu(Scanner leitor, Scanner leitorString, FuncionarioDao funcionarioDao, OpcoesDao opcoesDao, Maquina maquina) {
        this.leitor = leitor;
        this.leitorString = leitorString;
        this.funcionarioDao = funcionarioDao;
        this.opcoesDao = opcoesDao;
        this.maquina = maquina;
    }

    public void exibirMenuInicial() {
        System.out.println(
            """
            +--------------------------------------+
            | StockSafe Solutions                  |
            +--------------------------------------+
            | 1) Verificar Dados                   |
            | 2) Listar Processos                  |
            | 3) Mudar configurações de exibição   |
            |                                      |
            | 0) Sair                              |
            +--------------------------------------+
                """);
    }

    public void verificarDados () {
        Opcoes opcoes = opcoesDao.carregarOpcoes();

        if (opcoes.getMostrarUsoRam() != null) {
            for (int i = 0; i < 20; i++) {
                System.out.println("+--------------------------------------------------------------------------+");
                System.out.println("| Dados Atuais");
                System.out.println("+--------------------------------------------------------------------------+");

                if (opcoes.getMostrarUsoCpu().equals("1")) {
                    System.out.printf("| Uso de CPU: %.2f %%%n", maquina.getPorcentagemUsoCpu());
                }
                if (opcoes.getMostrarUsoRam().equals("1")) {
                    System.out.printf("| Uso de RAM: %.2f %%%n", maquina.getPorcentagemUsoRam());
                }

                if (opcoes.getMostrarTaxaTransferencia().equals("1")) {
                    System.out.printf("| Taxa de Transferência: %.2f Mb %n", maquina.getTaxaDeTransferencia());
                }

                if (opcoes.getMostrarPacotesEnviados().equals("1")) {
                    System.out.printf("| Pacotes Enviados: %.0f %n", maquina.getPacotesEnviados());
                }

                if (opcoes.getMostrarArmazenamentoTotal().equals("1")) {
                    System.out.printf("| Armazenamento Total: %.2f GB %n", maquina.getArmazenamentoTotal());
                }
                if (opcoes.getMostrarArmazenamentoUsado().equals("1")) {
                    System.out.printf("| Armazenamento Usado: %.2f GB %n", maquina.getArmazenamentoUsado());
                }

                System.out.println("+--------------------------------------------------------------------------+");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    public void listarProcessos () {
        System.out.println(maquina.getProcessos());
    }
    public void mudarOpcoes () {
        Opcoes opcoes = opcoesDao.carregarOpcoes();
        System.out.println(opcoes);

        System.out.println("Insira um valor (1 = Mostrar / 0 = Ocultar): ");

        opcoes.setOpcoes(leitorString);

        opcoesDao.alterarOpcoes(opcoes);
    }

    public Integer solicitarOpcaoInt() {
        System.out.println("Selecione uma opção:");
        return leitor.nextInt();
    }

    public String solicitarOpcaoString() {
        System.out.println("Selecione uma opção:");
        return leitorString.nextLine();
    }

    public void exibirMensagemSair () {
        System.out.println("Saindo... ");
        System.exit(0);
    }

    public void opcaoInvalida () { System.out.println("Opção inválida"); }
}
