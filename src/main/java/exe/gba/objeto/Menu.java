package exe.gba.objeto;

import exe.gba.dao.OpcoesDao;

import java.util.Scanner;

public class Menu {
    private final Scanner leitorNumero;
    private final Scanner leitorString;
    private final OpcoesDao opcoesDao;
    private final Maquina maquina;


    public Menu(Scanner leitorNumero, Scanner leitorString, OpcoesDao opcoesDao, Maquina maquina) {
        this.leitorNumero = leitorNumero;
        this.leitorString = leitorString;
        this.opcoesDao = opcoesDao;
        this.maquina = maquina;
    }

    public void fazerLogin (Opcoes opcoes) {
        System.out.println("Digite o nome de usuário: ");
        String usuario = leitorString.nextLine();

        System.out.println("Digite a senha: ");
        String senha = leitorString.nextLine();

        if (usuario.equalsIgnoreCase(opcoes.getUsuario()) && senha.equals(opcoes.getSenha())) {
            opcoes.setLogado(true);
            System.out.println("Login realizado... ");
            return;
        }

        System.out.println("Usuário e/ou senha inválidos! ");
    }

    public void fazerCadastro (Opcoes opcoes) {
        if (!opcoes.getUsuario().isEmpty() || !opcoes.getSenha().isEmpty()){
            System.out.println("Alerta! O usuário antigo será apagado! ");
        }

        System.out.println("Digite o nome de usuario: ");
        String usuarioInserido = leitorString.nextLine();

        System.out.println("Digite a senha: ");
        String senhaInserida = leitorString.nextLine();

        opcoes.setUsuario(usuarioInserido);
        opcoes.setSenha(senhaInserida);

        opcoesDao.alterarOpcoes(opcoes);
    }

    public void exibirMenuInicial() {
        this.limparTerminal();
        System.out.println(
            """
            +--------------------------------------+
            | Nenhum usuário logado!               |
            +--------------------------------------+
            | 1) Fazer login                       |
            | 2) Fazer cadastro                    |
            |                                      |
            | 0) Sair                              |
            +--------------------------------------+
                """);
    }
    public void exibirMenuOpcoes(Opcoes opcoes) {
        this.limparTerminal();
        System.out.println(
            """
            +--------------------------------------+
            | Olá, %s!                  
            +--------------------------------------+
            | 1) Verificar Dados                   |
            | 2) Listar Processos                  |
            | 3) Mudar configurações de exibição   |
            |                                      |
            | 0) Sair                              |
            +--------------------------------------+
                """.formatted(opcoes.getUsuario()));
    }

    public void verificarDados () {
        Opcoes opcoes = opcoesDao.carregarOpcoes();

        if (opcoes.getMostrarUsoRam() != null) {
            for (int i = 0; i < 20; i++) {
                this.limparTerminal();
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

        System.out.println("Aperte enter sair: ");
        String saída = leitorString.nextLine();
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
        return leitorNumero.nextInt();
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

    private void limparTerminal () {
        System.out.print("\033\143");
    }
}
