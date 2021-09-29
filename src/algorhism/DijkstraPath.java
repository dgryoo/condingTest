package algorhism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {

    public static void main(String[] args) {

        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        System.out.println(dijkstraFunc(graph, "A"));

    }

    public static HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {

        Edge edgeNode;
        Edge adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance;
        String currentNode;
        int weight;
        String adjacent;
        int distance;

        // 각 vertex Hashmap 생성
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }

        // 시작 지점 입력
        distances.put(start, 0);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue();
        priorityQueue.add(new Edge(distances.get(start), start));

        // 알고리즘
        while (priorityQueue.size() != 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            nodeList = graph.get(currentNode);
            for (int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }


            }


        }

        // return
        return distances;


    }

    static class Edge implements Comparable<Edge> {

        public int distance;
        public String vertex;

        public Edge(int distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        @Override
        public String toString() {
            return "vertex : " + vertex + ", distance : " + distance;
        }

        @Override
        public int compareTo(Edge e) {
            return distance - e.distance;
        }
    }

}
