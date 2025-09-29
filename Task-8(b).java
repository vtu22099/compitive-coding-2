//connect two groups of points
import java.util.*;

class Main {
    static class Point {
        int X, Y;
        Point(int x, int y) {
            this.X = x;
            this.Y = y;
        }
    }

    static int dist(Point a, Point b) {
        return Math.abs(a.X - b.X) + Math.abs(a.Y - b.Y);
    }

    public static int minTotalCost(List<Point> Points) {
        int n = Points.size();
        if (n <= 1) return 0;
        int[] minCost = new int[n];
        boolean[] inMST = new boolean[n];
        Arrays.fill(minCost, Integer.MAX_VALUE / 4);
        minCost[0] = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            int best = Integer.MAX_VALUE;
            for (int v = 0; v < n; v++) {
                if (!inMST[v] && minCost[v] < best) {
                    best = minCost[v];
                    u = v;
                }
            }
            inMST[u] = true;
            total += best;
            for (int v = 0; v < n; v++) {
                int w = dist(Points.get(u), Points.get(v));
                if (!inMST[v] && w < minCost[v]) minCost[v] = w;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        List<Point> groupA = Arrays.asList(new Point(0, 0), new Point(2, 2));
        List<Point> groupB = Arrays.asList(new Point(3, 10), new Point(5, 2), new Point(7, 10));
        List<Point> all = new ArrayList<>();
        all.addAll(groupA);
        all.addAll(groupB);
        int answer = minTotalCost(all);
        System.out.println("Minimum cost to connect points = " + answer);
    }
}
