package mrbet;

import java.util.*;

public class Time {
    // Atributos
    private String codigoId; // Código identificador no padrão: 3digitos_estado
    private String nome; // Nome do time
    private String mascote; // Mascote do time
    private ArrayList<Campeonato> jogosInscritos; // Campeonatos que o time participa

    // Construtor
    public Time(String codigoId, String nome, String mascote) {
        this.codigoId = codigoId;
        this.nome = nome;
        this.mascote = mascote;
        this.jogosInscritos = new ArrayList<>();
    }

    // Métodos
    public String getCodigoId() {
        return this.codigoId;
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Campeonato> getJogosInscritos() {
        return this.jogosInscritos;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoId == null) ? 0 : codigoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Time other = (Time) obj;
        if (codigoId == null) {
            if (other.codigoId != null)
                return false;
        } else if (!codigoId.equals(other.codigoId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[" + codigoId + "] " + nome + " / " + mascote;
    }

    public void adicionaJogo(Campeonato c) {
        jogosInscritos.add(c);
    }
}
