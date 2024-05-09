package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DFS {

    public static void dfs(HashMap<String, Boolean> vis, String node, HashMap<String,ArrayList<String>> adj) {
        vis.put(node, true);
        System.out.println(node);
        for (String nextNode: adj.get(node)) {
            System.out.println("adj nodes for"+node+" : "+adj.get(node));
            if (!vis.containsKey(nextNode)) {
                dfs(vis, nextNode, adj);
            } else {
                System.out.println("Leaving node "+ nextNode+" in node: "+node+" since its already traversed");
            }
        }
    }

    public static void main(String ...a){
        HashMap<String, ArrayList<String>> graph = graph();
        dfs(new HashMap<>(), "A", graph);
    }

    public static void nonRecursiveDfs (HashMap<String, Boolean> vis, String node, HashMap<String,ArrayList<String>> adj) {
        Stack<String> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            String nextNode = stack.pop();
            System.out.println(nextNode);
            vis.put(nextNode, true);
            for (String adjNode: adj.get(nextNode)) {
                if (!vis.containsKey(adjNode)) {
                    stack.push(adjNode);
                }
            }
        }
    }

    /**
     * A
     * |
     * B -- H
     * |
     * C -- E -- G
     * |    |
     * D    F
     *
     */

    private static HashMap<String, ArrayList<String>> graph() {
        HashMap<String, ArrayList<String>> adjGraph = new HashMap<>();

        ArrayList<String> adjA = new ArrayList<>();
        adjA.add("B");
        adjGraph.put("A", adjA);

        ArrayList<String> adjB = new ArrayList<>();
        adjB.add("A");
        adjB.add("C");
        adjB.add("H");
        adjGraph.put("B", adjB);

        ArrayList<String> adjC = new ArrayList<>();
        adjC.add("B");
        adjC.add("D");
        adjC.add("E");
        adjGraph.put("C", adjC);

        ArrayList<String> adjD = new ArrayList<>();
        adjD.add("C");
        adjGraph.put("D", adjD);

        ArrayList<String> adjE = new ArrayList<>();
        adjE.add("F");
        adjE.add("G");
        adjE.add("H");

        adjGraph.put("E", adjE);

        ArrayList<String> adjF = new ArrayList<>();
        adjF.add("E");
        adjGraph.put("F", adjF);

        ArrayList<String> adjG = new ArrayList<>();
        adjG.add("E");
        adjGraph.put("G", adjG);

        ArrayList<String> adjH = new ArrayList<>();
        adjH.add("E");
        adjH.add("B");
        adjGraph.put("H", adjH);

        return adjGraph;
    }
}
