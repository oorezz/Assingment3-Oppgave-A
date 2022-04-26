public class Dijkstra {

    public static void dijkstra(int[][] graph, int source) {
        int count = graph.length;
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        // Distance of self loop is zero
        distance[source] = 0;
        for (int i = 0; i < count; i++) {

            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;

            // Update all the neighbouring vertex distances
            for (int v = 0; v < count; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {

            
            if (source != i) { //If source and the next node is the same, do not print out
                System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
            }
        }

    }


    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 10, 5, 9999, 3, 12},
                {10, 0, 17, 9, 17, 12},
                {5, 17, 0, 35, 3, 12},
                {9999, 9, 35, 0, 9999, 12},
                {3, 17, 3, 0, 9999, 12},
                {12, 12, 12, 12, 12, 12},
        };

        Dijkstra T = new Dijkstra();
        int i = 0;
        System.out.println("0 = A, 1 = B, 2 = C, 3 = D, 4 = E, 5 = F");
        while(i < graph.length){
            System.out.println("============================================");
            T.dijkstra(graph, i);
            i++;
        }
    }

    }
