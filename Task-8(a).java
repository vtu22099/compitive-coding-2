//Find the shortest path
import java.util.*;
class Main{
    static class Edge{
        int to,cost;
        Edge(int t,int c){
            to=t;
            cost=c;
        }
    }
    public static int djikstra(int n,List<List<Edge>> graph,int src,int dest)
    {
        final int INF=Integer.MAX_VALUE/4;
        int [] dist=new int[n];
        Arrays.fill(dist,INF);
        dist[src]=0;
        PriorityQueue<int []> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,src});
        while(!pq.isEmpty()){
            int cur[]=pq.poll();
            int d=cur[0],u=cur[1];
            if(d > dist[u]) continue;
            if(u == dest) return d;
            for(Edge e:graph.get(u))
            {
                int nd=d+e.cost;
                if(nd < dist[e.to])
                {
                    dist[e.to]=nd;
                    pq.add(new int []{nd,e.to});
                }
            }
        }
        return dist[dest]>=INF ? -1 : dist[dest];
    }
    public static void main(String [] args)
    {
        int n=5;
        List<List<Edge>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(1,100));
        graph.get(0).add(new Edge(2,300));
        graph.get(1).add(new Edge(2,100));
        graph.get(1).add(new Edge(3,600));
        graph.get(2).add(new Edge(3,200));
        graph.get(3).add(new Edge(4,150));
        int src=0,dest=4;
        int cheapest=djikstra(n,graph,src,dest);
        System.out.println("Cheapest coset from "+ src + " to "+dest + " = "+cheapest);
    }
}
