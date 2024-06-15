package concorrency.course2.concurrentCollections;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CSVToInsertStatements {

    public static void main(String[] args) {
        // Provide the path to your CSV file
        String filePath = "F:\\tmp\\java core\\Core-Java\\Core Java\\src\\student.csv";

        // Read the CSV file
        try {
            // Read the entire CSV file into a string
            String csvData = Files.readString(Paths.get(filePath));

            // Split the CSV data by lines
            String[] lines = csvData.split("\n");

            // Extract column names from the first line
            String[] columns = lines[0].trim().split(",");

            // Prepare insert statements for each row
            StringBuilder sqlBuilder = new StringBuilder();
            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].trim().split(",");
                if (values.length != columns.length) {
                    System.out.println("Skipping row " + i + ". Column count does not match.");
                    continue;
                }
                sqlBuilder.append("INSERT INTO your_table (");
                for (int j = 0; j < columns.length; j++) {
                    sqlBuilder.append(columns[j]);
                    if (j < columns.length - 1) {
                        sqlBuilder.append(", ");
                    }
                }
                sqlBuilder.append(") VALUES (");
                for (int j = 0; j < values.length; j++) {
                    sqlBuilder.append("'").append(values[j]).append("'");
                    if (j < values.length - 1) {
                        sqlBuilder.append(", ");
                    }
                }
                sqlBuilder.append(");\n");
            }

            // Print or save the SQL insert statements
            System.out.println(sqlBuilder.toString());

            // Alternatively, you can save the SQL insert statements to a file
            // String sqlFilePath = "output.sql";
            // Files.writeString(Paths.get(sqlFilePath), sqlBuilder.toString(), StandardOpenOption.CREATE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}