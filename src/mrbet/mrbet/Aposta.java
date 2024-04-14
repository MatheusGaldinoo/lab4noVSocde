package mrbet;

public class Aposta {
    // Atributos
    private Time t; // Time que está sendo apostado
    private Campeonato c; // Campeonto que está sendo apotado
    private int colocacao; // Colocação esperada que o time fique no campeonato
    private double valorAposta; // Quantia investida na aposta
    
    // Construtor
    public Aposta(Time t, Campeonato c, int colocacao, double valorAposta) {
        this.t = t;
        this.c = c;
        this.colocacao = colocacao;
        this.valorAposta = valorAposta;
    }
    
    // Métodos

    @Override
    public String toString() {
        return t + "\n" + c.getNome() + "\n" + colocacao + "/" + c.getVagas() + "\nR$ " + valorAposta;
    }
}
