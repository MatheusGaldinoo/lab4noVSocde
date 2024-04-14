package mrbet;

import java.util.*;

public class MrBetSistema {
    // Atributos
    private HashMap<String, Time> mapaTimes; // Mapa de times, onde um codigoId aponta para um Time
    private HashMap<String, Campeonato> mapaCampeonatos; // Mapa de Campeonatos, onde um nome aponta para um Campeonato
    private ArrayList<Aposta> apostas; // Lista de Apostas

    // Construtor
    public MrBetSistema() {
        this.mapaTimes = new HashMap<>();
        this.mapaCampeonatos = new HashMap<>();
        this.apostas = new ArrayList<Aposta>();
    }

    // Métodos

    public ArrayList<Aposta> getApostas() {
        return this.apostas;
    }

    public HashMap<String, Time> getMapaTimes(){
        return this.mapaTimes;
    }

    public HashMap<String, Campeonato> getMapaCampeonatos(){
        return this.mapaCampeonatos;
    }

    private Time pegaTime(String codigoId) {
        Time t = mapaTimes.get(codigoId);
        return t;
    }

    private Campeonato pegaCampeonato(String nome) {
        Campeonato c = mapaCampeonatos.get(nome);
        return c;
    }
    
    public void cadastraTime(String codigoId, String nome, String mascote) {
        Time t = new Time(codigoId, nome, mascote);
        mapaTimes.put(codigoId, t); 
    }

    public void cadastraCampeonato(String nome, int vagas) {
        Campeonato c = new Campeonato(nome, vagas);
        this.mapaCampeonatos.put(nome, c);
    }

    public void incluiTimeEmCamp(String codigoId, String nome) {
        Campeonato c = pegaCampeonato(nome);
        Time t = pegaTime(codigoId);
        c.adicionaParticipante(t);
        t.adicionaJogo(c);

    }
                
    public boolean verifica(String codigoId, String nome) {
        Campeonato c = pegaCampeonato(nome);
        if (c.temParticipante(codigoId)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean aposta(String codigoId, String nome, int colocacao, double valorAposta) {
        Campeonato c = pegaCampeonato(nome);
        Time t = pegaTime(codigoId);
        if (colocacao <= c.getVagas()) {
            Aposta a = new Aposta(t, c, colocacao, valorAposta);
            apostas.add(a);
            return true;
        } else {
            return false;
        }   
    }
}