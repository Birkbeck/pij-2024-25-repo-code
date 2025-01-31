package pij.day15solution.graph;

import java.util.List;

public class GraphDriver {

    private static void driveInteger() {
        Graph<Integer> g = new Graph<>();
        final int FIRST_VALUE = 20;
        final int NUMBER_OF_NODES = 5;
        for (int i = FIRST_VALUE; i < FIRST_VALUE+NUMBER_OF_NODES; i++) {
            g.addNode(i); // node at index has data index+FIRST_VALUE
        }
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(4, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 2);
        for (int i = 0; i < NUMBER_OF_NODES; i++) {
            int size = g.sizeFrom(i);
            System.out.println("Nodes reachable from node " + i + ": " + size);
        }
        for (int i = 0; i < NUMBER_OF_NODES; i++) {
            List<Integer> values = g.getDataFrom(i);
            System.out.println("Data reachable from node " + i + ": " + values);
        }
    }
    public static void main(String[] args) {
        driveInteger();
    }
}
