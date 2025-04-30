import java.util.*;

class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class Bellmanford {
    static final int INF = Integer.MAX_VALUE;

    static void runBellFord(int n, List<Edge> edges, int source) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != INF && dist[edge.u] + edge.w < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.w;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            if (dist[edge.u] != INF && dist[edge.u] + edge.w < dist[edge.v]) {
                System.out.println("Negative weight cycle found");
                return;
            }
        }

        System.out.println("Node Dist:");
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                System.out.println(i + " : INF");
            } else {
                System.out.println(i + " : " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of vertices: ");
            int n = sc.nextInt();
            System.out.print("Enter number of edges: ");
            int m = sc.nextInt();

            List<Edge> edges = new ArrayList<>();
            System.out.println("Enter edges (u v w):");
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                edges.add(new Edge(u, v, w));
            }

            System.out.print("Enter source node: ");
            int source = sc.nextInt();

            runBellFord(n, edges, source);
        }
    }
}