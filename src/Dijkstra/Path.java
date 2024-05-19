package Dijkstra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Path {
    private ArrayList<Integer> shortestPath;
    public ArrayList<Integer> getShortestPath(){
        return this.shortestPath;
    }

    AdjacentListGraph graph;
    int numOfPlaces;

    public Path(String csvFile) {
        graph = new AdjacentListGraph();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                int[] temp = new int[words.length];
                for(int i = 0 ; i< words.length ; i++) temp[i] = words[i].isEmpty() ? 0 : Integer.parseInt (  words[i] );
                int u = temp[0];
                int v = temp[1];
                double distance = (double) temp[2];
                double capacity = (double) temp[3];
                graph.addVertex(u);
                graph.addVertex(v);
                graph.addEdges(u, distance, capacity, v);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getNumOfPlaces() {
        return graph.getNumOfVertices();
    }

    public ArrayList<Integer> shortestPath(int origin, int destination) {
        shortestPath = graph.findShortestPath(origin, destination);
        return graph.findShortestPath(origin, destination);
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}