package graphs;

import java.util.*;

public class Graph {

    private class Node {

        private String label;

        private Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodesTable = new HashMap<>();
    private Map<Node, List<Node>> graph = new HashMap<>();

    public void addNode(String label) {
        var newNode = new Node(label);
        nodesTable.putIfAbsent(label, newNode);
        graph.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String sourceNodeLabel, String targetNodeLabel) {
        var sourceNode = findNodeInstance(sourceNodeLabel);
        var targetNode = findNodeInstance(targetNodeLabel);

        graph.get(sourceNode).add(targetNode);
    }

    public void removeEdge(String sourceNodeLabel, String targetNodeLabel) {
        var sourceNode = findNodeInstance(sourceNodeLabel);
        var targetNode = findNodeInstance(targetNodeLabel);

        var targetNodes = graph.get(sourceNode);
        if (!targetNodes.contains(targetNode)) {
            throw new IllegalArgumentException();
        }
        targetNodes.remove(targetNode);
    }

    public void removeNode(String label) {
        var node = findNodeInstance(label);

        graph.remove(node);
        for (List<Node> sourceNodes : graph.values()) {
            sourceNodes.remove(node);
        }
        nodesTable.remove(label);
    }

    public void print() {
        for (Node sourceNode : graph.keySet()) {
            var targetNodes = graph.get(sourceNode);
            if (!targetNodes.isEmpty()) {
                System.out.println(sourceNode + " is connected to " + targetNodes);
            }
        }
    }

    private Node findNodeInstance(String label) {
        var node = nodesTable.get(label);
        if (node == null) {
            throw new IllegalArgumentException();
        }
        return node;
    }

    public void traversalDepthFirstRecursive(String label) {
        traversalDepthFirstRecursive(findNodeInstance(label), new HashSet<>());
    }

    private void traversalDepthFirstRecursive(Node root, Set<Node> visitedNodes) {
        System.out.println(root);
        visitedNodes.add(root);

        var targetNodes = graph.get(root);
        for (Node targetNode : targetNodes) {
            if (!visitedNodes.contains(targetNode)) {
                traversalDepthFirstRecursive(targetNode, visitedNodes);
            }
        }
    }

    public void traversalDepthFirstIterative(String label) {
        Stack<Node> stack = new Stack<>();
        stack.push(findNodeInstance(label));

        Set<Node> visitedNodes = new HashSet<>();
        while (!stack.isEmpty()) {
            var currentNode = stack.pop();
            if (visitedNodes.contains(currentNode)) {
                continue;
            }

            visitedNodes.add(currentNode);
            System.out.println(currentNode);

            var targetNodes = graph.get(currentNode);
            for (Node targetNode: targetNodes) {
                if (!visitedNodes.contains(targetNode)) {
                    stack.push(targetNode);
                }
            }
        }
    }

    public void traversalBreadthFirst(String label) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(findNodeInstance(label));

        Set<Node> visitedNodes = new HashSet<>();
        while (!queue.isEmpty()) {
            var currentNode = queue.remove();
            if (visitedNodes.contains(currentNode)) {
                continue;
            }

            System.out.println(currentNode);
            visitedNodes.add(currentNode);

            var targetNodes = graph.get(currentNode);
            for (Node targetNode : targetNodes) {
                if (!visitedNodes.contains(targetNode)) {
                    queue.add(targetNode);
                }
            }
        }
    }

    public void topologicalSorting(String label) {
        topologicalSorting(findNodeInstance(label), new Stack<>());
    }

    private void topologicalSorting(Node root, Stack<Node> stack) {
        var targetNodes = graph.get(root);
        if (!targetNodes.isEmpty()) {
            for (Node targetNode : targetNodes) {
                topologicalSorting(targetNode, stack);
                if (!stack.contains(targetNode)) {
                    stack.push(targetNode);
                    System.out.println(stack);
                }
            }
        }
        else {
            if (!stack.contains(root)) {
                stack.push(root);
                System.out.println(stack);
            }
        }
    }
}
