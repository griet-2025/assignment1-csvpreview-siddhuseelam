package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty.");
                return;
            }
            String[] columns = headerLine.split(",");
            System.out.print("=== Data Preview ===\n\n");
            System.out.print(ANSI_GREEN + "Columns: " + ANSI_RESET);
            for (int i = 0; i < columns.length; i++) {
                System.out.print(ANSI_GREEN + columns[i] + ANSI_RESET);
                if (i < columns.length - 1) System.out.print("    ");
            }
            System.out.println();
            System.out.println(ANSI_GREEN + "Number of columns: " + columns.length + ANSI_RESET);
            String line;
            int recordCount = 0;
            int previewCount = 0;
            System.out.println(ANSI_GREEN + "First 5 records:" + ANSI_RESET);
            while ((line = br.readLine()) != null) {
                if (previewCount < 5) {
                    String[] values = line.split(",");
                    for (int i = 0; i < values.length; i++) {
                        System.out.print(ANSI_RED + values[i] + ANSI_RESET);
                        if (i < values.length - 1) System.out.print("    ");
                    }
                    System.out.println();
                    previewCount++;
                }
                recordCount++;
            }
            System.out.println(ANSI_GREEN + "Total records (excluding header): " + recordCount + ANSI_RESET);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}