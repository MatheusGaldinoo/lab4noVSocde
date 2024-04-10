package mrbet;

import java.util.ArrayList;
import java.util.HashMap;

public class MrBetSistema {
    // Atributos
    private HashMap<String, Time> mapaTimes;
    private HashMap<String, Campeonato> mapaCampeonatos;
    private ArrayList<Aposta> apostas;

    // Construtor
    public MrBetSistema() {
        this.mapaTimes = new HashMap<>();
        this.mapaCampeonatos = new HashMap<>();
        this.apostas = new ArrayList<Aposta>();
    }

    // Métodos

    private boolean temTime(String codigoId) {
        if (mapaTimes.containsKey(codigoId)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean temCampeonato(String nome) {
        if (mapaCampeonatos.containsKey(nome)) {
            return true;
        } else {
            return false;
        }
    }

    private Campeonato pegaCampeonato(String nome) {
        Campeonato c = mapaCampeonatos.get(nome);
        return c;
    }

    private Time pegaTime(String codigoId) {
        Time t = mapaTimes.get(codigoId);
        return t;
    }

    public void cadastraTime(String codigoId, String nome, String mascote) {
        if (temTime(codigoId)) {
            System.out.println("TIME JÁ EXISTE!\n");
        } else {
            Time t = new Time(codigoId, nome, mascote);
            mapaTimes.put(codigoId, t);
            System.out.println("INCLUSÃO REALIZADA!\n");
        }
    }

    public void mostraTime(MrBetSistema mrbet, String codigoId) {
        if (temTime(codigoId)) {
            Time t = mapaTimes.get(codigoId);
            System.out.println(t + "\n");
        } else {
            System.out.println("TIME NÃO EXISTE!\n");
        }
    }

    public void cadastraCampeonato(String nome, int vagas) {
        if (temCampeonato(nome)) {
            System.out.println("CAMPEONATO JÁ EXISTE!\n");
        } else {
            Campeonato c = new Campeonato(nome, vagas);
            this.mapaCampeonatos.put(nome, c);
            System.out.println("CAMPEONATO ADICIONADO!\n");
        }
    }

    public void incluirTimeEmCamp(String codigoId, String nome) {
        if (temTime(codigoId)) {
            if (temCampeonato(nome)) {
                Campeonato c = pegaCampeonato(nome);
                if (c.getParticipantes() < c.getVagas()) {
                    Time t = pegaTime(codigoId);
                    c.adicionaParticipante(t);
                } else {
                    throw new IllegalArgumentException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
                }
            } else {
                throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
            }
        } else {
            throw new IllegalArgumentException("TIME NÃO EXISTE!");
        }
    }

    public void verifica(String codigoId, String nome) {
        if (temTime(codigoId)) {
            if (temCampeonato(nome)) {
                Campeonato c = pegaCampeonato(nome);
                if (c.temParticipante(codigoId)) {
                    System.out.println("O TIME ESTÁ NO CAMPEONATO!\n");
                } else {
                    System.out.println("O TIME NÃO ESTÁ NO CAMPEONATO!\n");
                }
            } else {
                throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
            }
        } else {
            throw new IllegalArgumentException("TIME NÃO EXISTE!");
        }
    }

    public void exibeCampeonatos(String codigoId) {
        Time t = pegaTime(codigoId);
        System.out.println("Campeonatos do " + t.getNome() + ":");
        for (Campeonato c : t.pegaCampeonatos().values()) {
            System.out.println(c);
        }

    }

    // olhar mapaApostas.put(1, a);
    public void aposta(String codigoId, String nome, int colocacao, double valorAposta) {
        if (temTime(codigoId)) {
            if (temCampeonato(nome)) {
                Campeonato c = pegaCampeonato(nome);
                Time t = pegaTime(codigoId);

                if (colocacao > c.getVagas()) {
                    Aposta a = new Aposta(t, c, colocacao, valorAposta);
                    apostas.add(a);
                    System.out.println("APOSTA REGISTRADA!\n");
                } else {
                    System.out.println("APOSTA NÃO REGISTRADA!\n");
                }

            } else {
                throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
            }
        } else {
            throw new IllegalArgumentException("TIME NÃO EXISTE!");
        }

    }

    public void mostraApostas() {
        int cont = 1;
        for (Aposta a : apostas) {
            System.out.println(cont + ". " + a);
            cont++;
        }
    }

}