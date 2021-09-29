package algorhism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {


    public static void main(String[] args) {
        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        PrimPath primPath = new PrimPath();
        System.out.println(primPath.PrimFunc("A", myedges));
    }

    public ArrayList<Edge> PrimFunc(String startNode, ArrayList<Edge> edges) {

        Edge currentEdge, adjacentEdgesNode;
        PriorityQueue<Edge> priorityQueue;
        ArrayList<Edge> currentEdgeList;
        ArrayList<Edge> candidateEdgeList;
        ArrayList<Edge> adjacentEdgesNodes;
        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();
        Edge poppedEdge;

        // 초기화
        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
            }

            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        priorityQueue = new PriorityQueue<>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        // 알고리즘
        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgesNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<>());
                for (int index = 0; index < adjacentEdgesNodes.size(); index++) {
                    adjacentEdgesNode = adjacentEdgesNodes.get(index);
                    if (!connectedNodes.contains(adjacentEdgesNode.node2)) {
                        priorityQueue.add(adjacentEdgesNode);
                    }
                }
            }
        }
        return mst;

    }

    public static class Edge implements Comparable<Edge> {

        public int weight;
        public String node1;
        public String node2;

        public Edge(int weight, String node1, String node2) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        public String toString() {
            return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
        }

        @Override
        public int compareTo(Edge edge) {
            return weight - edge.weight;
        }
    }
}
