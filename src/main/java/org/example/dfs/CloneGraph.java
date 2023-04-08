package org.example.dfs;

import org.example.design.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    private Map<Node, Node> alreadyCloned;

    public Node cloneGraph(Node node) {
        alreadyCloned = new HashMap<>();
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }

        if (alreadyCloned.containsKey(node)) {
            return alreadyCloned.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());

        alreadyCloned.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }

        return clone;
    }
}
