package undirected.graph;

import java.util.*;

public class WeightedGraph {

    private class Node {

        private String value;
        private List<Edge> edges = new ArrayList<>();

        private Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        public void addEdge(Node targetNode, int weight) {
            edges.add(new Edge(weight, this, targetNode));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {

        private int weight;
        private Node sourceNode;
        private Node targetNode;

        private Edge(int weight, Node sourceNode, Node targetNode) {
            this.weight = weight;
            this.sourceNode = sourceNode;
            this.targetNode = targetNode;
        }

        @Override
        public String toString() {
            return sourceNode + "->" + targetNode;
        }
    }

    private Map<String, Node> storedNodes = new HashMap<>();

    public void addNode(String label) {
        storedNodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String sourceNodeLabel, String targetNodeLabel, int weight) {
        var sourceNode = storedNodes.get(sourceNodeLabel);
        if (sourceNode == null) {
            throw new IllegalArgumentException();
        }

        var targetNode = storedNodes.get(targetNodeLabel);
        if (targetNode == null) {
            throw new IllegalArgumentException();
        }

        sourceNode.addEdge(targetNode, weight);
        targetNode.addEdge(sourceNode, weight);
    }

    public void print() {
        for(Node node: storedNodes.values()) {
            List<Edge> edges = node.getEdges();
            if(!edges.isEmpty()) {
                System.out.println(node + " is connected to " + edges);
            }
        }
    }

    private class NodeEntry {

        private Node node;
        private int priority;

        public NodeEntry(int priority, Node node) {
            this.priority = priority;
            this.node = node;
        }
    }

    public void getShortestPath(String sourceNodeLabel, String targetNodeLabel) {
        var sourceNode = storedNodes.get(sourceNodeLabel);
        var targetNode = storedNodes.get(targetNodeLabel);

        Map<Node, Node> previous = new HashMap<>();
        Map<Node, Integer> distances = new HashMap<>();
        for (Node node : storedNodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        Set<Node> visitedNodes = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(nodeEntry -> nodeEntry.priority));
        queue.add(new NodeEntry(0, sourceNode));

        while (!queue.isEmpty()) {
            var currentRootNode = queue.remove().node;
            visitedNodes.add(currentRootNode);

            for (Edge currentEdge : currentRootNode.getEdges()) {
                if (visitedNodes.contains(currentEdge.targetNode)) {
                    continue;
                }

                var newDistance = distances.get(currentRootNode) + currentEdge.weight;
                if (newDistance < distances.get(currentEdge.targetNode)) {
                    distances.replace(currentEdge.targetNode, newDistance);
                    previous.put(currentEdge.targetNode, currentRootNode);
                    queue.add(new NodeEntry(newDistance, currentEdge.targetNode));
                }
            }
        }

        buildPath(targetNode, distances, previous);
    }

    private void buildPath(Node targetNode, Map<Node, Integer> distances, Map<Node, Node> previous) {
        if (distances.get(targetNode) == Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        Stack<Node> pathStack = new Stack<>();
        var currentNode = targetNode;
        do {
            pathStack.push(currentNode);
            currentNode = previous.get(currentNode);
        } while (currentNode != null);

        while (!pathStack.isEmpty()) {
            System.out.println(pathStack.pop());
        }
    }

    public boolean hasCycle() {
        Set<Node> visitedNodes = new HashSet<>();
        for (Node currentNode : storedNodes.values()) {
            if (!visitedNodes.contains(currentNode) && hasCycle(currentNode, currentNode, visitedNodes)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node currentRootNode, Node previousRootNode, Set<Node> visitedNodes) {
        if (visitedNodes.contains(currentRootNode)) {
            return true;
        }
        visitedNodes.add(currentRootNode);

        for (Edge currentEdge : currentRootNode.getEdges()) {
            if (currentEdge.targetNode != previousRootNode) {
                if (hasCycle(currentEdge.targetNode, currentRootNode, visitedNodes)) {
                    return true;
                };
            }
        }

        return false;
    }

    public WeightedGraph getMinimumSpanningTree() {
        var tree = new WeightedGraph();

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        var startNode = storedNodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.value);

        while (tree.storedNodes.size() < storedNodes.size()) {
            var minimumEdge = edges.remove();
            tree.addNode(minimumEdge.targetNode.value);
            tree.addEdge(minimumEdge.sourceNode.value, minimumEdge.targetNode.value, minimumEdge.weight);

            for (Node currentNode : tree.storedNodes.values()) {
                for (Edge currentEdge : currentNode.getEdges()) {
                    if (!tree.storedNodes.containsValue(currentEdge.targetNode)) {
                        edges.add(currentEdge);
                    }
                }
            }
        }

        return tree;
    }
}
