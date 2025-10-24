package main.java.com.simulador.hidrometro.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Hidrometro {
    private List<Leitura> leituras = new ArrayList<>();
    private Random random = new Random();
    private static final Logger logger = Logger.getLogger(Hidrometro.class.getName());

    public void gerarLeitura() {
        double vazao = Math.round(random.nextDouble() * 1.0 * 1000.0) / 1000.0;
        String horario = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        Leitura leitura = new Leitura(vazao, horario);
        leituras.add(leitura);
        logger.info("Nova leitura registrada.");
    }

    public double calcularConsumoTotal() {
        double total = 0;
        for(Leitura i : leituras) {
            total += i.getVazao();
        }
        return total;
    }

    public boolean detectarVazamento() {
        int minVazamento = 5;
        if (leituras.size() < minVazamento) {
            logger.warning("Dados insuficientes para detectar vazamento.");
            return false;
        }

        List<Leitura> ultimas = leituras.subList(leituras.size() - minVazamento, leituras.size());

        for(Leitura i : ultimas) {
            if(i.getVazao() == 0) {
                logger.info("Nenhum vazamento detectado!");
                return false;
            }
        }
        logger.warning("Possível vazamento detectado!");
        return true;
    }

    public List<Leitura> getLeituras() {
        return leituras;
    }
}