import java.util.*;
public class HamiltonianCircuit {
    static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args){
        int n,m,s,d;
        System.out.println("Enter the number of vertices : ");
        n=scanner.nextInt();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        System.out.println("Enter the number of edges : ");
        m=scanner.nextInt();
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        System.out.println("Enter the edges : ");
        for(int i=0;i<m;i++){
            s=scanner.nextInt();
            d=scanner.nextInt();
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        System.out.println("Enter the vertex to start from : ");
        int e=scanner.nextInt();
        HC(graph,visited,e,"");
    }
    static void HC(ArrayList<ArrayList<Integer>> graph,int[] visited,int e,String ans){
        visited[e]=1;
        System.out.print(e+" ");
        ans+=e+" ";
        if(ans.length()/2==graph.size()){
            for(Integer i:graph.get(e)){
                if(i==Integer.parseInt(String.valueOf(ans.charAt(0)))){
                    //System.out.println(ans);
                }
            }
        }
        for(int i=0;i<graph.get(e).size();i++) {
            int t=graph.get(e).get(i);
            if (visited[t] == 0) {
                HC(graph, visited, t,ans);
            }
        }
        visited[e]=0;
        String t="";
        for(int i=0;i<ans.length()-2;i++){
            t+=ans.charAt(i);
        }
        ans=t;
    }
}
