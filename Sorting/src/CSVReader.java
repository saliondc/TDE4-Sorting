import java.io.*;
import java.util.*;

public class CSVReader {
    public static int[] readCSV(String filePath) throws IOException {
        List<Integer> dataList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (String value : values) {
                try {
                    dataList.add(Integer.parseInt(value.trim()));
                } catch (NumberFormatException e) {
                    System.err.printf("Valor inválido ignorado: %s%n", value);
                }
            }
        }
        br.close();
        return dataList.stream().mapToInt(i -> i).toArray();
    }
}