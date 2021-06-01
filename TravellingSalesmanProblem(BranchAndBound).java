import java.util.*;
public class TSP {
    public static void main(String[] args){
        int n;
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        n=scanner.nextInt();
        int[][] graph=new int[n][n];
        System.out.println("Enter the adjacency matrix representation : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=scanner.nextInt();
            }
        }
        scanner.nextLine();
        System.out.println("Enter the vertex to start from : ");
        StringBuilder ans=new StringBuilder(scanner.nextLine());
        TSP(graph,ans);
    }
    static int find1Min(int[][] graph,int x,int y){//x->starting vertex y->vertex to be excluded
        int min=Integer.MAX_VALUE;
        for(int i=0;i<graph.length;i++){//Iterating columns
            if(i!=y){
                if(graph[x][i]<min){
                    min=graph[x][i];
                }
            }
        }
        return min;
    }
    static int find2Min(int[][] graph,int x){//x->starting vertex
        int min1,min2;
        min1=min2=Integer.MAX_VALUE;
        for(int i=0;i<graph.length;i++){//Iterating columns
            if(graph[x][i]<min1){
                min2=min1;
                min1=graph[x][i];
            }
            else if(graph[x][i]<min2){
                min2=graph[x][i];
            }
        }
        return min1+min2;
    }
    static int findLB(int[][] graph,StringBuilder ans){
        int sum=0,N=ans.length();
        if(ans.length()==graph.length){
            //First index Sum
            sum+=graph[0][Integer.parseInt(String.valueOf(ans.charAt(N-1)+""))];
            for(int i=0;i<N-1;i++){
                sum+=graph[Integer.parseInt(String.valueOf(ans.charAt(i)+""))][Integer.parseInt(String.valueOf(ans.charAt(i+1)+""))];
            }
            System.out.println("Soluition : "+sum);
            return sum;
        }
        //First vertex of ans
        sum+=graph[0][Integer.parseInt(String.valueOf(ans.charAt(1)+""))];
        sum+=find1Min(graph,0,1);
        //Center vertices of ans
        //Center a)vertices included ans except last
        for(int j=1;j<N-1;j++){
            sum+=graph[Integer.parseInt(String.valueOf(ans.charAt(j)+""))][Integer.parseInt(String.valueOf(ans.charAt(j-1)+""))];
            sum+=graph[Integer.parseInt(String.valueOf(ans.charAt(j)+""))][Integer.parseInt(String.valueOf(ans.charAt(j+1)+""))];
        }
        //Center b)vertices excluded in ans except last
        for(int i=0;i<graph.length;i++){
            if(ans.indexOf(i+"")==-1 && i!=(Integer.parseInt(String.valueOf(ans.charAt(N-1)+"")))){
                sum+=find2Min(graph,i);
            }
        }
        //Last vertex
        sum+=graph[Integer.parseInt(String.valueOf(ans.charAt(N-1)+""))][Integer.parseInt(String.valueOf(ans.charAt(N-2)+""))];
        sum+=find1Min(graph,Integer.parseInt(String.valueOf(ans.charAt(N-1)+"")),Integer.parseInt(String.valueOf(ans.charAt(N-2)+"")));
        return sum/2;
    }
    static void TSP(int[][] graph,StringBuilder ans){
        if(ans.length()/2==graph.length){
            findLB(graph,ans);
            System.out.print("Selected path : ");
            for(int i=0,j=0;i<graph.length;j++,i++){
                System.out.print(ans.charAt(j)+" ");
            }
            System.out.print("0");
            return;
        }
        int min=Integer.MAX_VALUE,t,k=0;
        for(int i=0;i<graph.length;i++){
            if(ans.indexOf(""+i)==-1){
                ans.append(i);
                t=findLB(graph,ans);
                if(t<min){
                    min=t;
                    k=i;
                }
                ans.replace(ans.length()-1,ans.length(),"");
            }
        }
        ans.append(k);
        TSP(graph,ans);
    }
}
