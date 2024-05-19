package Dijkstra;

public class DTTest {
    public static void main(String[] args) {
        // Insert csv file into here to create path
        Path path = new Path("F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv");
        System.out.println(path);
        System.out.println(path.shortestPath(7, 0));
    }
}
