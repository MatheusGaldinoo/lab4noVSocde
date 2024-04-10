package mrbet;

import java.lang.System;
import java.util.*;

public class MainMrBet {
    public static void main(String[] args) {
        MrBetSistema mrbet = new MrBetSistema();
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu(mrbet, sc);
        }
    }

    public static void menu(MrBetSistema mrbet, Scanner sc) {
        System.out.print(
                "(M)Minha inclusão de times\n" +
                        "(R)Recuperar time\n" +
                        "(.)Adicionar campeonato\n" +
                        "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
                        "(E)Exibir campeonatos que o time participa\n" +
                        "(T)Tentar a sorte e status\n" +
                        "(!)Já pode fechar o programa!\n\n" +
                        "Opção> ");

        String escolha = sc.nextLine();

        // Verifica se a entrada é nula ou vazia
        if (escolha == null || escolha == "") {
            throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        }

        // Interpreta a opção escolhida no menu
        switch (escolha.toUpperCase()) {
            case "M":
                incluirTime(mrbet, sc);
                break;
            case "R":
                recuperarTime(mrbet, sc);
                break;
            case ".":
                adicionarCampeonato(mrbet, sc);
                break;
            case "B":
                submenuB(mrbet, sc);
                break;
            case "E":
                ExibirCampeonatos(mrbet, sc);
                break;
            case "T":
                submenuT(mrbet, sc);
                break;
            case "!":
                fechaPrograma();
                break;
            default:
                throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        }

    }

    public static void submenuB(MrBetSistema mrbet, Scanner sc) {
        System.out.print("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
        String escolha = sc.nextLine();

        // Interpreta a opção escolhida no submenu
        switch (escolha.toUpperCase()) {
            case "I":
                BoraIncluirTimeEmCampeonato(mrbet, sc);
                break;
            case "V":
                verifica(mrbet, sc);
                break;
            default:
                throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        }
    }

    public static void submenuT(MrBetSistema mrbet, Scanner sc) {
        System.out.print("(A)Apostar ou (S)Status das Apostas? ");
        String escolha = sc.nextLine();

        // Interpreta a opção escolhida no submenu
        switch (escolha.toUpperCase()) {
            case "A":
                apostar(mrbet, sc);
                break;
            case "S":
                status(mrbet);
                break;
            default:
                throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        }
    }

    public static void incluirTime(MrBetSistema mrbet, Scanner sc) {
        System.out.print("\nCódigo: ");
        String codigoId = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Mascote: ");
        String mascote = sc.nextLine();

        mrbet.cadastraTime(codigoId, nome, mascote);
    }

    public static void recuperarTime(MrBetSistema mrbet, Scanner sc) {
        System.out.print("\nCódigo: ");
        String codigoId = sc.nextLine();

        mrbet.mostraTime(mrbet, codigoId);
    }

    public static void adicionarCampeonato(MrBetSistema mrbet, Scanner sc) {
        System.out.print("\nCampeonato: ");
        String nome = sc.nextLine();

        System.out.print("Participantes: ");
        int vagas = sc.nextInt();

        mrbet.cadastraCampeonato(nome, vagas);
    }

    public static void BoraIncluirTimeEmCampeonato(MrBetSistema mrbet, Scanner sc) {
        System.out.print("\nCódigo: ");
        String codigoId = sc.nextLine();

        System.out.print("\nCampeonato: ");
        String nome = sc.nextLine();

        mrbet.incluirTimeEmCamp(codigoId, nome);
    }

    public static void verifica(MrBetSistema mrbet, Scanner sc) {
        System.out.print("\nCódigo: ");
        String codigoId = sc.nextLine();

        System.out.print("\nCampeonato: ");
        String nome = sc.nextLine();

        mrbet.verifica(codigoId, nome);
    }

    public static void apostar(MrBetSistema mrbet, Scanner sc) {
        System.out.print("Código: ");
        String codigoId = sc.nextLine();

        System.out.print("Campeonato: ");
        String nome = sc.nextLine();

        System.out.print("Colocação: ");
        int colocacao = sc.nextInt();

        System.out.print("Valor da aposta: ");
        double valorAposta = sc.nextDouble();

        mrbet.aposta(codigoId, nome, colocacao, valorAposta);

    }

    public static void status(MrBetSistema mrbet) {
        System.out.print("\nApostas: ");
        mrbet.mostraApostas();
    }

    public static void ExibirCampeonatos(MrBetSistema mrbet, Scanner sc) {
        System.out.print("\nTime: ");
        String codigoId = sc.nextLine();

        mrbet.exibeCampeonatos(codigoId);
    }

    public static void fechaPrograma() {
        System.out.println("\nPor hoje é só pessoal!");
        System.exit(0);
    }
}
