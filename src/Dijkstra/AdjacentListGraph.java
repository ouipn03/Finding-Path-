package Dijkstra;

import java.util.*;

public class AdjacentListGraph {
    static LinkedList<LinkedList<Vertex>> adjacentList;
    static int numOfVertices = 0;
    public AdjacentListGraph() {
        adjacentList = new LinkedList<>();
    }

    public void addVertex(int place) {
        // If the place already exist, return nothing
        for (LinkedList<Vertex> link : adjacentList) {
            if (link.get(0).getPlace()==place) return;
        }
        // Add new place
        LinkedList<Vertex> link = new LinkedList<>();
        link.add(new Vertex(place));
        adjacentList.add(link);
        numOfVertices++;
    }

    // Add edges between u and v
    public void addEdges(int u, double distance, double capacity, int v) {
        for (LinkedList<Vertex> link : adjacentList) {
            if (link.get(0).getPlace()==u) {
                Vertex destination = new Vertex(v, distance, capacity);
                link.add(destination);
            }
            if (link.get(0).getPlace()==v) {
                Vertex destination = new Vertex(u, distance, capacity);
                link.add(destination);
            }
        }
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public int findLinkIndexInAdjacentMatrix(int s) {
        LinkedList<Vertex> link = new LinkedList<>();
        for (LinkedList<Vertex> l : adjacentList) {
            if (l.get(0).getPlace()==s) {
                link = l;
                break;
            }
        }

        return adjacentList.indexOf(link);
    }

    public static LinkedList<Vertex> getLink ( int s ) {
        for (LinkedList<Vertex> l : adjacentList) {
            if (l.get(0).getPlace()==s) {
                return l;
            }
        }

        return null;
    }

    public ArrayList<Integer> findShortestPath(int origin, int destination) {
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[numOfVertices];
        HashMap<Integer, Vertex> map = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        map.put(origin, new Vertex(origin, 0.0));
        queue.add(new Vertex(origin, 0.0));

        while (!queue.isEmpty()) {
            Vertex temp = queue.poll();
            int v = temp.getPlace();
            double distance = temp.getDistance();
            visited[findLinkIndexInAdjacentMatrix(v)] = true;

            LinkedList<Vertex> link = getLink(v);
            for (Vertex next : link) {
                if (!visited[adjacentList.indexOf(getLink(next.getPlace()))]) {
                    if (!map.containsKey(next.getPlace())) {
                        map.put(next.getPlace(), new Vertex(v, distance + next.getDistance()));
                    } else {
                        Vertex sn = map.get(next.getPlace());
                        if (distance + next.getDistance() < sn.getDistance()) {
                            sn.setPlace(v);
                            sn.setDistance(distance + next.getDistance());
                        }
                    }
                    queue.add(new Vertex(next.getPlace(), distance + next.getDistance()));
                }
            }
        }

        path.add(destination);
        while (!path.get(0).equals(origin)) {
            int temp = map.get(path.get(0)).getPlace();
            path.add(0, temp);
        }
        return path;
    }
    public static ArrayList<Integer> findMinCongestionPath ( int origin , int destination ) {
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[numOfVertices];
        HashMap<Integer, Vertex> map = new HashMap<>();
        int[] maxCapacity = new int[numOfVertices];
        Arrays.fill(maxCapacity, Integer.MIN_VALUE);
        maxCapacity[origin] = Integer.MAX_VALUE;
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> -maxCapacity[vertex.getPlace()]));
        pq.add(new Vertex(origin, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Vertex uVertex = pq.poll();
            int u = uVertex.getPlace();

            if (visited[u]) {
                continue;
            }

            visited[u] = true;

            LinkedList<Vertex> link = getLink(u);
            for (Vertex next : link) {
                int v = next.getPlace();
                int weight = (int) next.getCapacity();
                int minCapacity = Math.min(maxCapacity[u], weight);

                if (minCapacity > maxCapacity[v]) {
                    maxCapacity[v] = minCapacity;
                    map.put(v, new Vertex(u,  next.getCapacity()));
                    pq.add(new Vertex(v, minCapacity));
                }
            }
        }

        path.add(destination);
        while (path.get(0) != origin) {
            int temp = map.get(path.get(0)).getPlace();
            path.add(0, temp);
        }

        return path;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Vertex> link : adjacentList) {
            for (Vertex v : link) {
                sb.append(v.getPlace());
                sb.append("   ");
            }
            sb.append("\n");
            for (Vertex v : link) {
                if (v.getDistance() == 0) {
                    sb.append("  ");
                } else {
                    sb.append(v.getDistance());
                    sb.append(" ");
                }
            }
            sb.append("\n");
            for (Vertex v : link) {
                if (v.getCapacity() == 0) {
                    sb.append("  ");
                } else {
                    sb.append(v.getCapacity());
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}