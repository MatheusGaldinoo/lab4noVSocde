package mrbet;

import java.util.HashMap;

public class Campeonato {
    // Atributos
    private String nome; // Nome do campeonato
    private int vagas; // vagas totais
    private int participantes; // Quantidade de inscritos
    private HashMap<String, Time> mapaTimesInscritos;

    // Construtor
    public Campeonato(String nome, int vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.participantes = 0;
        this.mapaTimesInscritos = new HashMap<>();
    }

    // Métodos

    public int getParticipantes() {
        return participantes;
    }

    public String getNome() {
        return nome;
    }

    public int getVagas() {
        return vagas;
    }

    public void adicionaParticipante(Time t) {
        this.participantes = participantes + 1;
        String codigoId = t.getCodigoId();
        this.mapaTimesInscritos.put(codigoId, t);
    }

    public boolean temParticipante(String codigoId) {
        if (mapaTimesInscritos.containsKey(codigoId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "* " + nome + "- " + participantes + "/" + vagas;
    }

}
