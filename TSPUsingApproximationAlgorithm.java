package TSP_Approx;
import java.util.*;
class Edge{
    int destination;
    int weight;
    Edge(int dest,int w)
    {
        destination=dest;
        weight=w;
    }
}
public class TSP {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int m,n,s,d,w,st,t,t2,sum=0;
        System.out.println("Enter the number of vertices : ");
        n=scanner.nextInt();
        int[] visited=new int[n];
        LinkedList<LinkedList<Edge>> graph=new LinkedList<>();
        for(int i=0;i<n;i++){
            graph.add(new LinkedList<>());
        }
        System.out.println("Enter the no. of edges : ");
        m=scanner.nextInt();
        System.out.println("Enter the edges along with the weights : ");
        for(int i=0;i<m;i++){
            s=scanner.nextInt();
            d=scanner.nextInt();
            w=scanner.nextInt();
            graph.get(s).add(new Edge(d,w));
            graph.get(d).add(new Edge(s,w));
        }
        System.out.println("Enter the starting vertex : ");
        st=t=t2=scanner.nextInt();
        System.out.println("Approximate solution : ");
        System.out.print("Path : ");
        System.out.print(st+" ");
        for(int i=0;i<n-1;i++){
            visited[st]=1;
            t=findMinEdge(graph,visited,st);
            sum+=findDist(graph,st,t);
            st=t;
            System.out.print(t+" ");
        }
        System.out.print(t2+" ");
        sum+=findDist(graph,st,t2);
        System.out.println("Distance : "+sum);
    }
    static int findMinEdge(LinkedList<LinkedList<Edge>> graph,int[] visited,int s){
        int t,min=Integer.MAX_VALUE,k=0;
        for(int i=0;i<graph.get(s).size();i++){
            if(visited[graph.get(s).get(i).destination]==0){
                t=graph.get(s).get(i).weight;
                if(min>t){
                    min=t;
                    k=graph.get(s).get(i).destination;
                }
            }
        }
        return k;
    }
    static int findDist(LinkedList<LinkedList<Edge>> graph,int s,int d){
        for(int i=0;i<graph.get(s).size();i++){
            if(graph.get(s).get(i).destination==d){
                return graph.get(s).get(i).weight;
            }
        }
        return 0;
    }
    static void printGraph(LinkedList<LinkedList<Edge>> graph){
        int n=graph.size();
        System.out.println("Graph :");
        for(int i=0;i<n;i++){
            System.out.print(i);
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print("--->"+graph.get(i).get(j).destination+" Weight : "+graph.get(i).get(j).weight);
            }
            System.out.println();
        }
    }
}
