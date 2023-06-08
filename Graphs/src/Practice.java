import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Practice {
    public static void main(String[] args) {
        double inf = Double.POSITIVE_INFINITY;
        double[][] adjMatrix = new double[][] {
                {inf, 10, 20, inf, 15},
                {10, inf, inf, inf, 25},
                {20, inf, inf, inf, inf},
                {inf, inf, inf, 200, inf},
                {15, 25, inf, inf, inf}
        };

        int[][] adjacencyMatrix = {
                {0, 1, 0, 0},
                {1, 0, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0}
        };

        List<List<Integer>> adjacencyList = adjMatToList(adjacencyMatrix);
        System.out.println(adjacencyList);


        boolean[] visited = new boolean[4];
        System.out.println(findPath(adjacencyList, 3, 0, visited));







    }

    // рекурсивный поиск пути
    public static List<Integer> findPath(List<List<Integer>> graph, int current, int destination, boolean[] visited) {
        List<Integer> path = new ArrayList<>();
        path.add(current);
        if (current == destination) {
            return path;
        }
        if (visited[current]) {
            return null;
        }
        visited[current] = true;
        for (int neighbour: graph.get(current)) {
            List<Integer> tmp = findPath(graph, neighbour, destination, visited);
            if (tmp != null) {
                path.addAll(tmp);
                return path;
            }
        }
        return null;
    }

    // преобразовать матрицу в список смежности
    public static List<List<Integer>> adjMatToList(int[][] adjMatrix) {
        List<List<Integer>> adjList = new ArrayList<>(adjMatrix.length);
        for (int i = 0; i < adjMatrix.length; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != 0) {
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }
}
