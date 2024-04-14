package mrbet;

import java.util.*;

public class Campeonato {
    // Atributos
    private String nome; // Nome do campeonato
    private int vagas; // Vagas totais
    private int participantes; // Quantidade de inscritos
    private ArrayList<Time> timesInscritos; // Lista de Times inscritos no campeonato

    // Construtor
    public Campeonato(String nome, int vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.participantes = 0;
        this.timesInscritos = new ArrayList<>();
    }

    // Métodos

    public int getParticipantes() {
        return this.participantes;
    }

    public String getNome() {
        return this.nome;
    }

    public int getVagas() {
        return this.vagas;
    }

    @Override
    public String toString() {
        return "* " + nome + "- " + participantes + "/" + vagas;
    }

    public void adicionaParticipante(Time t) {
        this.participantes = participantes + 1;
        this.timesInscritos.add(t);
    }

    public boolean temParticipante(String codigoId) {
        for (Time t : timesInscritos) {
            if (t.getCodigoId().equals(codigoId)) {
                return true;
            } 
        }
        return false;
    }
}
