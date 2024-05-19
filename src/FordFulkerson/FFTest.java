package FordFulkerson;
import java.util.ArrayList;
import java.util.List;


public class FFTest {
    public static List<Edge> edgesFree = new ArrayList<>();
    static List<Edge> edgesMedium = new ArrayList<>();
    static List<Edge> edgesFullCapacity = new ArrayList<>();
    static StringBuilder stringEdgesFree = new StringBuilder();
    static StringBuilder stringEdgesMedium = new StringBuilder();

    static StringBuilder stringEdgesHigh = new StringBuilder();
    final static int n = ImportData.getN();

//    public static void main(String[] args) {
//        int Start = 0;
//        int End = 7;
//        run_test (Start,End);
//        System.out.println(freeEdges(Start,End));
//        System.out.println(mediumEdges(Start,End));
//        System.out.println(highEdges(Start,End));
//    }
    public static String freeEdges(int Start, int End) {
//        run_test();
        System.out.println("Free edges:");
        for (Edge e : edgesFree) {
            stringEdgesFree.append(e.toStringOnlyVertex(Start, End));
        }
        return stringEdgesFree.toString();
    }

    public static String mediumEdges(int Start, int End) {
        run_test(Start,End);
        System.out.println("Medium edges:");
        for (Edge e : edgesMedium) {
            stringEdgesMedium.append(e.toStringOnlyVertex(Start, End));
        }
        return stringEdgesMedium.toString();
    }

    public static String highEdges(int Start, int End) {
        run_test(Start,End);
        System.out.println("High edges:");
        for (Edge e : edgesFullCapacity) {
            stringEdgesHigh.append(e.toStringOnlyVertex(Start, End));
        }
        return stringEdgesHigh.toString();
    }
    public static void run_test ( int Start, int End ) {
        FordFulkersonDfsSolverAdjacencyList graph = ImportData.getFordFulkersonDfsSolverAdjacencyList(n, Start, End);
        System.out.println("Max flow:" + graph.getMaxFlow());

        List<Edge>[] g = graph.getGraph();

        for (List<Edge> edges : g) {
            for (Edge e : edges) {
                if (!e.isResidual()) {
                    if (e.flow >= 0 && e.flow < (e.capacity / 4)) {   /* list edge that have flow small */
                        edgesFree.add(e);
                    } else if (e.flow >= (e.capacity / 4) && e.flow < (e.capacity - e.capacity / 4)) {
                        edgesMedium.add(e);
                    } else {
                        edgesFullCapacity.add(e);
                    }
                }
            }
        }
    }
}
