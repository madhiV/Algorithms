import java.util.*;
public class VCP {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,m,s,d,v;
        System.out.println("Enter the number of vertices : ");
        n=scanner.nextInt();
        LinkedList<LinkedList<Integer>> graph=new LinkedList<>();
        for(int i=0;i<n;i++){
            graph.add(new LinkedList<>());
        }
        System.out.println("Enter the number of edges : ");
        m=scanner.nextInt();
        System.out.println("Enter the edges : ");
        for(int i=0;i<m;i++){
            s=scanner.nextInt();
            d=scanner.nextInt();
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        StringBuilder ans=new StringBuilder("Verices to be selected : ");
        for(int i=0;i<n;i++){
            if(Check(graph)){
                break;
            }
            v=maxVertex(graph);
            ans.append((v)+" ");
            Modify(graph,v);
        }
        System.out.println("Approximate solution : ");
        System.out.println(ans);
    }
    static boolean Check(LinkedList<LinkedList<Integer>> graph){
        int t=0;
        for(int i=0;i<graph.size();i++){
            if(graph.get(i).size()>0){
                t+=1;
                if(t>1){
                    return false;
                }
            }
        }
        return true;
    }
    static int maxVertex(LinkedList<LinkedList<Integer>> graph){
        int max=-1,t,v=-1;
        for(int i=0;i<graph.size();i++){
            t=graph.get(i).size();
            if(t>max){
                max=t;
                v=i;
            }
        }
        return v;
    }
    static void Modify(LinkedList<LinkedList<Integer>> graph,int v){
        graph.get(v).clear();
        for(int i=0;i<graph.size();i++){
            for(int j=0;j<graph.get(i).size();j++){
                if(graph.get(i).get(j)==v){
                    graph.get(i).remove(j);
                    break;
                }
            }
        }
    }
    static void printGraph(LinkedList<LinkedList<Integer>> graph){
        System.out.println("Graph : ");
        for(int i=0;i<graph.size();i++){
            for(Integer j:graph.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
