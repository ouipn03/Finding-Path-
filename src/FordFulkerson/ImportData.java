package FordFulkerson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * reading the provided data sets and convert it into a list of vertex object
 */

public class ImportData {

    static String dataSetName = "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\location.csv";
    static String line = "";
    static String splitBy = ",";

    public static int getN() {
        Set<String> totalVertex = new HashSet<>();
        int countTotalVertex = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataSetName))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(splitBy);

                if (temp.length > 0) {
                    // Lấy giá trị từ cột 1 (nếu cột 0-indexed)
                    String valueInColumn1 = temp[0];

                    // Thêm giá trị vào Set để theo dõi các giá trị đã xuất hiện
                    totalVertex.add(valueInColumn1);

                    // Tăng biến đếm
                    countTotalVertex++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countTotalVertex;
    }
    public static FordFulkersonDfsSolverAdjacencyList getFordFulkersonDfsSolverAdjacencyList(int n, int Start, int End) {
        FordFulkersonDfsSolverAdjacencyList solver;
        solver = new FordFulkersonDfsSolverAdjacencyList(n, Start, End);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dataSetName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(splitBy);
                int from = Integer.parseInt(temp[0]);
                int to = Integer.parseInt(temp[1]);
                double distance = Double.parseDouble(temp[2]);
                long capacity = Long.parseLong(temp[3]);
                solver.addEdge(from, to, distance, capacity);
            }
            n = solver.getTotalEdge();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solver;
    }

}