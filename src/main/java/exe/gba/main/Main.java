package exe.gba.main;

import exe.gba.dao.OpcoesDao;
import exe.gba.objeto.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitorString = new Scanner(System.in);
        Scanner leitorNumero = new Scanner(System.in);

        OpcoesDao opcoesDao = new OpcoesDao();
        Maquina maquina = new Maquina();

        Menu menu = new Menu(leitorNumero, leitorString, opcoesDao, maquina);

        opcoesDao.criarOpcoes();
        Opcoes opcoes = opcoesDao.carregarOpcoes();

        Integer opcaoEscolhida;
        do {
            menu.exibirMenuInicial();

            opcaoEscolhida = menu.solicitarOpcaoInt();

            switch (opcaoEscolhida) {
                case 1 -> menu.fazerLogin(opcoes);
                case 2 -> menu.fazerCadastro(opcoes);
                case 0 -> menu.exibirMensagemSair();
                default -> menu.opcaoInvalida();
            }
        } while (!opcoes.getLogado());

        do {
            menu.exibirMenuOpcoes(opcoes);

            opcaoEscolhida = menu.solicitarOpcaoInt();

            switch (opcaoEscolhida) {
                case 1 -> menu.verificarDados();
                case 2 -> menu.listarProcessos();
                case 3 -> menu.mudarOpcoes();
                case 0 -> menu.exibirMensagemSair();
                default -> menu.opcaoInvalida();
            }
        } while (true);
    }
}