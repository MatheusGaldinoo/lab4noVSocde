package mrbet;

public class Aposta {
    // Atributos
    private Time t;
    private Campeonato c;
    private int colocacao;
    private double valorAposta;
    
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
        return t + "\n" + c.getNome() + colocacao + "/" + c.getVagas() + "\n R$ " + valorAposta;
    }

}
