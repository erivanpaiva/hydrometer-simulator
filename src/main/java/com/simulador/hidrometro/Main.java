package main.java.com.simulador.hidrometro;

import java.util.Scanner;
import java.util.logging.Logger;

import main.java.com.simulador.hidrometro.model.Hidrometro;
import main.java.com.simulador.hidrometro.model.Leitura;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Hidrometro hidrometro = new Hidrometro();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - Gerar nova leitura");
            System.out.println("2 - Ver leituras");
            System.out.println("3 - Calcular consumo");
            System.out.println("4 - Detectar vazamento");
            System.out.println("0 - Sair");
            
            int opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    hidrometro.gerarLeitura();
                    break;
                case 2:
                    for (Leitura i : hidrometro.getLeituras()) {
                        System.out.println(i);
                    }
                    break;
                case 3:
                    System.out.printf("Consumo total: %.3f m³/H", hidrometro.calcularConsumoTotal());
                    break;
                case 4:
                    hidrometro.detectarVazamento();
                    break;
                case 0:
                    logger.warning("Simulador encerrado.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Escolha uma opção de 0 a 4.");
            }
        }
    }
}