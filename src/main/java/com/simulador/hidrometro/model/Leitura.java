package main.java.com.simulador.hidrometro.model;

public class Leitura {
    private double vazao;
    private String horario;
    
    public Leitura(double vazao, String horario) {
        this.vazao = vazao;
        this.horario = horario;
    }

    public double getVazao() {
        return vazao;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return horario + " - Vazão: " + String.format("%.3f", vazao) + " m³/H";
    }
}