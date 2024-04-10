package mrbet;

import java.util.HashMap;

public class Time {
    // Atributos
    private String codigoId; // Código identificador no padrão: 3digitos_estado
    private String nome; // Nome do time
    private String mascote; // Mascote do time
    private HashMap<String, Campeonato> mapaCampeonatosInscritos; // Campeonatos que o time participa

    // Construtor
    public Time(String codigoId, String nome, String mascote) {
        this.codigoId = codigoId;
        this.nome = nome;
        this.mascote = mascote;
        this.mapaCampeonatosInscritos = new HashMap<>();
    }

    // Métodos

    @Override
    public String toString() {
        return "[" + codigoId + "] " + nome + " / " + mascote;
    }

    public String getCodigoId() {
        return codigoId;
    }

    public String getNome() {
        return nome;
    }

    public HashMap<String, Campeonato> pegaCampeonatos() {
        return mapaCampeonatosInscritos;
    }
}
