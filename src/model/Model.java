package model;
import Dijkstra.AdjacentListGraph;
import Dijkstra.Path;
import FordFulkerson.FFTest;
import java.util.ArrayList;

public class Model {
    private AdjacentListGraph adjacentListGraph;
    private ArrayList < Integer > ketquaFFMed;
    private ArrayList < Integer > ketquaFFHig;
    private ArrayList < Integer > ketquaDT;
    private ArrayList < Integer > ketquaDTMin;

    public Model(){
        this.ketquaDT = new ArrayList<>();
        this.ketquaDTMin = new ArrayList<>();
        this.ketquaFFMed = new ArrayList<>();
        this.ketquaFFHig = new ArrayList<>();
    }

    public String findFFsHig(int Start, int End){
        FFTest.run_test(Start,End);
        return FFTest.highEdges (Start,End);
    }
    public String findFFsMed(int Start, int End){
        FFTest.run_test(Start,End);
        return FFTest.mediumEdges (Start,End);
    }
    public ArrayList <Integer> findDTs(int start, int end){
        Path path = new Path("F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv");
        return path.shortestPath(start, end);
    }
    public ArrayList <Integer> findDTsMin(int start, int end){
        return AdjacentListGraph.findMinCongestionPath(start, end);
    }
    public String findFFmed (int Start, int End){
        ArrayList<Integer> paths2 = new ArrayList<Integer>();
        String MediumEdges = FFTest.mediumEdges (Start,End);
        String s = MediumEdges;
        s = s.replace ("][",",");
        s = s.replace ("]","");
        s = s.replace ("[","");
        s = s.replace (" ","");
        for(String token : s.split(",")){
            paths2.add ( Integer.parseInt ( token ));
        }
        this.ketquaFFMed = paths2;
        return MediumEdges;
    }
    public String findFFhig (int Start, int End){
        ArrayList<Integer> paths1 = new ArrayList<Integer>();
        String HightEdges = FFTest.highEdges (Start,End);
        String s = HightEdges;
        s = s.replace ("][",",");
        s = s.replace ("]","");
        s = s.replace ("[","");
        s = s.replace (" ","");
        for(String token : s.split(",")){
            paths1.add ( Integer.parseInt ( token ));
        }
        this.ketquaFFHig = paths1;
        return HightEdges;
    }
    public String findDTMin(int start,int end) {
        ArrayList<Integer> paths = findDTsMin ( start,end );
        String path = "";
        for(int i = 0; i< paths.size ();i++){
            path+=paths.get ( i )+" ";
        }
        this.ketquaDT = paths;
        return path;
    }
    public String findDT ( int start, int end){
        ArrayList <Integer> paths = findDTs (start,end);
        String path = "";
        for(int i = 0; i< paths.size ();i++){
            path+=paths.get ( i )+" ";
        }
        this.ketquaDT = paths;
        return path;
    }
}

