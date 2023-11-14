package exe.gba.main;

import com.github.britooo.looca.api.core.Looca;
import exe.gba.conexao.Conexao;
import exe.gba.dao.FuncionarioDao;
import exe.gba.dao.MaquinaDao;
import exe.gba.dao.OpcoesDao;
import exe.gba.dao.ServidorDao;
import exe.gba.objeto.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        Looca looca = new Looca();

        Scanner leitor = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);

        FuncionarioDao funcionarioDao = new FuncionarioDao(con);
        Funcionario funcionario = new Funcionario();

        OpcoesDao opcoesDao = new OpcoesDao();
        Opcoes opcoes = new Opcoes();

        Maquina maquina = new Maquina(looca);
        MaquinaDao maquinaDao = new MaquinaDao(con);

        ServidorDao servidorDao = new ServidorDao(con);
        Servidor servidor;

        Menu menu = new Menu(leitor, leitorString, funcionarioDao, opcoesDao, maquina);

        if (opcoesDao.carregarOpcoes() == null){
            opcoesDao.criarOpcoes();
        }

        opcoes = opcoesDao.carregarOpcoes();

        Boolean isLogado = false;

        while (!isLogado) {
            System.out.println("Faça seu login");

            System.out.println("Digite o seu email: ");
            String email = leitorString.nextLine();

            System.out.println("Digite a sua senha: ");
            String senha = leitorString.nextLine();

            funcionario = new Funcionario(email, senha);

            List<Funcionario> funcionarioCadastrado = funcionarioDao.getFuncionarioPorLogin(funcionario);

            if (!funcionarioCadastrado.isEmpty()) {
                funcionario = funcionarioCadastrado.get(0);
                isLogado = true;

            } else {
                System.out.println("Usuário inválido");
            }
        }

        while (servidorDao.selecionarServidor(opcoes).isEmpty()) {
            opcoes.setCodigo(leitorString);

            opcoesDao.alterarOpcoes(opcoes);
        }

        servidor = servidorDao.selecionarServidor(opcoes).get(0);

        servidorDao.autenticarServidor(servidor, funcionario);

        do {
            menu.exibirMenuInicial();
            Integer opcaoEscolhida = menu.solicitarOpcaoInt();

            switch (opcaoEscolhida) {
                case 1:
                    menu.verificarDados();
                    break;
                case 2:
                    menu.listarProcessos();
                    break;
                case 3:
                    menu.mudarOpcoes();
                    break;
                case 0:
                    menu.exibirMensagemSair();
                    break;
                default:
                    menu.opcaoInvalida();
            }

            maquinaDao.inserirDados(servidor, maquina);
            servidorDao.atualizarArmazenamento(servidor, maquina.getArmazenamentoTotal(), maquina.getArmazenamentoUsado());
        } while (true);
    }
}