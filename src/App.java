import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

public class App {

    static Ingresso[] ingressos;

    static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ingressos = lerIngressos("ingressos.txt");
        int opcao;
        do {
            System.out.println("\n--- Bilheteria ---");
            System.out.println("1. Ordenar ingressos");
            System.out.println("2. Listar todos os ingressos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> ordenarIngressos();
                case 2 -> listarTodosOsIngressos();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static Ingresso[] lerIngressos(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            java.util.List<Ingresso> lista = new java.util.ArrayList<>();

            while ((linha = br.readLine()) != null) {
                if (linha.isBlank()) continue;
                String[] campos = linha.split(";");

                int tipo = Integer.parseInt(campos[0].trim());
                String evento = campos[1].trim();
                double precoBase = Double.parseDouble(campos[2].trim());
                LocalDate data = LocalDate.parse(campos[3].trim(), FORMATO_DATA);

                Ingresso ingresso = (tipo == 1)
                        ? new IngressoInteira(evento, precoBase, data)
                        : new IngressoMeia(evento, precoBase, data);

                lista.add(ingresso);
            }

            return lista.toArray(new Ingresso[0]);

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            return new Ingresso[0];
        }
    }

    //Questão 01
    static void ordenarIngressos() {
        System.out.println("\nAlgoritmo: 1-Seleção");
        System.out.println("\nAlgoritmo: 2-Bolha");
        System.out.println("\nAlgoritmo: 3-Merge");

        int algoritmo = Integer.parseInt(sc.nextLine());

        System.out.println("Critério: A-B-Data do Evento");
        String criterio = sc.nextLine().trim().toUpperCase();

        System.out.println("Critério: A-B-Valor Final");
        String criterio = sc.nextLine().trim().toUpperCase();

        Comparator<Ingresso> comparador = switch (criterio) {
            case "A" -> new ComparadorPorValorFinal());
            default -> null;
        };

        Comparator<Ingresso> comparador = switch (criterio) {
            case "B" -> new ComparadorPorData();
            default -> null;
        };

        Comparator<Ingresso> comparador = switch (criterio) {
            case "C" -> new ComparadorNomeEvento();
            default -> null;
        };

        IOrdenator<Ingresso> ordenador = switch (algoritmo) {
            case 1 -> new SelectionSort<>(comparador);
            case 2 -> new BubbleSort<>(comparador);
            case 3 -> new MergeSort<>(comparador);
            default -> null;
        };

        if (ordenador == null) {
            System.out.println("Algoritmo não implementado.");
            return;
        }
        if (comparador == null) {
            System.out.println("Comparador não implementado.");
            return;
        }
        ingressos = ordenador.ordenar(ingressos);
        listarTodosOsIngressos();
    }

    static void listarTodosOsIngressos() {
        for (Ingresso ingresso : ingressos) {
            System.out.println(ingresso);
        }
    }

    //Questão 03
    static void localizarIngressosPorValor(double valorMin, double valorMax){
        for(int = 0; i <= ingressos.length; i++) { 
            double valor = ingressos[i].valorFinal();
            if(valor >= valorMin && valor <= valorMax) {
                System.out.println(ingressos[i]);
            }
        }
    }
}
