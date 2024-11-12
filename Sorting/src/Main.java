import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arquivos = {
                "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
                "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
                "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
        };
        for (String arquivo : arquivos) {
            try {
                int[] dados = CSVReader.readCSV(arquivo);

                int[] dadosBubble = Arrays.copyOf(dados, dados.length);
                long tempoBubbleSort = medirTempoExecucao(() -> SortingAlgorithms.bubbleSort(dadosBubble));

                int[] dadosInsertion = Arrays.copyOf(dados, dados.length);
                long tempoInsertionSort = medirTempoExecucao(() -> SortingAlgorithms.insertionSort(dadosInsertion));

                int[] dadosQuick = Arrays.copyOf(dados, dados.length);
                long tempoQuickSort = medirTempoExecucao(() -> SortingAlgorithms.quickSort(dadosQuick, 0, dadosQuick.length - 1));

                System.out.printf("Arquivo: %s%n", arquivo);
                System.out.printf("Tempo Bubble Sort: %d ms%n", tempoBubbleSort);
                System.out.printf("Tempo Insertion Sort: %d ms%n", tempoInsertionSort);
                System.out.printf("Tempo Quick Sort: %d ms%n", tempoQuickSort);
                System.out.println();

            } catch (IOException e) {
                System.err.printf("Erro ao ler o arquivo %s: %s%n", arquivo, e.getMessage());
            }
        }
    }

    public static long medirTempoExecucao(Runnable metodoOrdenacao) {
        long startTime = System.nanoTime();
        metodoOrdenacao.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
