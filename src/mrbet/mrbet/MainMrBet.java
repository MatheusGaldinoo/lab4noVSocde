package mrbet;

import java.lang.System;
import java.util.*;

public class MainMrBet {
    // Loop principal que irá sempre estar ativando o menu
    public static void main(String[] args) {
        MrBetSistema mrbet = new MrBetSistema();
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu(mrbet, sc);
        }
    }

    private static void menu(MrBetSistema mrbet, Scanner sc) {
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
                exibirCampeonatos(mrbet, sc);
                break;
            case "T":
                submenuT(mrbet, sc);
                break;
            case "!":
                fecharPrograma();
                break;
            default:
                throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        }
        System.out.println();
    }

    private static void submenuB(MrBetSistema mrbet, Scanner sc) {
        System.out.print("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
        String escolha = sc.nextLine();

        switch (escolha.toUpperCase()) {
            case "I":
                boraIncluirTimeEmCampeonato(mrbet, sc);
                break;
            case "V":
                verifica(mrbet, sc);
                break;
            default:
                throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        }
    }

    private static void submenuT(MrBetSistema mrbet, Scanner sc) {
        System.out.print("(A)Apostar ou (S)Status das Apostas? ");
        String escolha = sc.nextLine();

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

    private static boolean temTime(MrBetSistema mrbet, String codigoId) {
        if (mrbet.getMapaTimes().containsKey(codigoId)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean temCampeonato(MrBetSistema mrbet, String nome) {
        if (mrbet.getMapaCampeonatos().containsKey(nome)) {
            return true;
        } else {
            return false;
        }
    }

    private static Campeonato pegaCampeonato(MrBetSistema mrbet, String nome) {
        Campeonato c = mrbet.getMapaCampeonatos().get(nome);
        return c;
    }

    private static Time pegaTime(MrBetSistema mrbet, String codigoId) {
        Time t = mrbet.getMapaTimes().get(codigoId);
        return t;
    }

    private static void incluirTime(MrBetSistema mrbet, Scanner sc) {
        System.out.print("Código: ");
        String codigoId = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Mascote: ");
        String mascote = sc.nextLine();

        if (temTime(mrbet, codigoId)) {
            System.out.println("TIME JÁ EXISTE!");
        } else {
            mrbet.cadastraTime(codigoId, nome, mascote);
            System.out.println("INCLUSÃO REALIZADA!");
        }
    }

    private static void recuperarTime(MrBetSistema mrbet, Scanner sc) {
        System.out.print("Código: ");
        String codigoId = sc.nextLine();

        if (temTime(mrbet, codigoId)) {
            Time t = mrbet.getMapaTimes().get(codigoId);
            System.out.println(t);
        } else {
            System.out.println("TIME NÃO EXISTE!");
        }
    }

    private static void adicionarCampeonato(MrBetSistema mrbet, Scanner sc) {
        System.out.print("Campeonato: ");
        String nome = sc.nextLine();

        System.out.print("Participantes: ");
        int vagas = sc.nextInt();
        sc.nextLine();

        if (temCampeonato(mrbet, nome)) {
            System.out.println("CAMPEONATO JÁ EXISTE!");
        } else {
            mrbet.cadastraCampeonato(nome, vagas);
            System.out.println("CAMPEONATO ADICIONADO!");
        }
    }

    private static void boraIncluirTimeEmCampeonato(MrBetSistema mrbet, Scanner sc) {
        System.out.print("Código: ");
        String codigoId = sc.nextLine();

        System.out.print("Campeonato: ");
        String nome = sc.nextLine();

        if (!temTime(mrbet, codigoId)) {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }

        if (!temCampeonato(mrbet, nome)) {
            throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
        }
        
        Campeonato c = pegaCampeonato(mrbet, nome);
        if (c.getParticipantes() >= c.getVagas()) {
            throw new IllegalArgumentException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
        }

        mrbet.incluiTimeEmCamp(codigoId, nome);
        System.out.println("TIME INCLUÍDO NO CAMPEONATO!");
    }

    private static void verifica(MrBetSistema mrbet, Scanner sc) {
        System.out.print("Código: ");
        String codigoId = sc.nextLine();

        System.out.print("Campeonato: ");
        String nome = sc.nextLine();

        if (!temTime(mrbet, codigoId)) {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }

        if (!temCampeonato(mrbet, nome)) {
            throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
        }

        if (mrbet.verifica(codigoId, nome)) {
            System.out.println("O TIME ESTÁ NO CAMPEONATO!");
        } else {
            System.out.println("O TIME NÃO ESTÁ NO CAMPEONATO!");
        }
    }

    private static void apostar(MrBetSistema mrbet, Scanner sc) {
        System.out.print("Código: ");
        String codigoId = sc.nextLine();

        System.out.print("Campeonato: ");
        String nome = sc.nextLine();

        System.out.print("Colocação: ");
        int colocacao = sc.nextInt();
        sc.nextLine();

        System.out.print("Valor da aposta: ");
        double valorAposta = sc.nextDouble();
        sc.nextLine();

        if (!temTime(mrbet, codigoId)) {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }

        if (!temCampeonato(mrbet, nome)) {
            throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
        }

        if (mrbet.aposta(codigoId, nome, colocacao, valorAposta)) {
            System.out.println("APOSTA REGISTRADA!");
        } else {
            System.out.println("APOSTA NÃO REGISTRADA!");
        }  
    }

    private static void status(MrBetSistema mrbet) {
        System.out.println("Apostas:\n");

        int cont = 1;
        for (Aposta a : mrbet.getApostas()) {
            System.out.println(cont + ". " + a + "\n");
            cont++;
        }
    }

    private static void exibirCampeonatos(MrBetSistema mrbet, Scanner sc) {
        System.out.print("Time: ");
        String codigoId = sc.nextLine();

        if (!temTime(mrbet, codigoId)) {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }

        Time t = pegaTime(mrbet, codigoId);
        System.out.println("Campeonatos do " + t.getNome() + ":");
        for (Campeonato c : t.getJogosInscritos()) {
            System.out.println(c);
        }
    }

    private static void fecharPrograma() {
        System.out.print("Por hoje é só pessoal!");
        System.exit(0);
    }
}
