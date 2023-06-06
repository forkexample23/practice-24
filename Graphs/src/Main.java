import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }


    // https://leetcode.com/problems/find-if-path-exists-in-graph/description/
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        // заполнить список смежности
        // edges = [[0,1],[1,2],[2,0]]
        // создать визитед
        // запустить дфс из вершины source
        // если дфс закончился, а destination не встретился, значит такого пути нет

        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new LinkedList<>());
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        System.out.println(adj);


        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.empty()) {
            int current = stack.pop();
            if (visited[current]) {
                continue; // перейти к следующей итерации цикла
            }
            if (current == destination) {
                return true;
            }
            visited[current] = true;
            // List<List<Integer>> adj = new ArrayList<>(n);
            List<Integer> children = adj.get(current);
            for (int child: children) {
                stack.push(child);
            }
        }

        return false;
    }

    public static void fillMatrixFromList(List<List<Integer>> adj, int[][] matrix) {
        for (int i = 0; i < adj.size(); i++) {
            for (int node: adj.get(i)) {
                matrix[i][node] = 1;
            }
        }
    }

    public static void fillListFromMatrix(List<List<Integer>> adj, int[][] matrix) {

    }

}