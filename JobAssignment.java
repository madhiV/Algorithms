import java.util.*;
public class JobAssignment {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n;
        System.out.println("Enter the number of jobs : ");
        n=scanner.nextInt();
        System.out.println("Enter the cost matrix : ");
        int[][] cost=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j]=scanner.nextInt();
            }
        }
        StringBuilder ans=new StringBuilder("");
        JA(cost,ans,0);
    }
    static int findCost(StringBuilder ans,int[][] cost){
        int sum=0;
        for(int i=0,j=0;i<ans.length()/2;i++,j+=2){
            sum+=cost[i][Integer.parseInt(String.valueOf(""+ans.charAt(j)))];
        }
        return sum;
    }
    static int findMinCost(int[][] cost,StringBuilder ans,int x,int y){
        int sum=cost[x][y],min;
        for(int i=x+1;i<cost.length;i++){//iterating rows
            min=Integer.MAX_VALUE;
            for(int j=0;j<cost.length;j++){
                if(j!=y && ans.indexOf(""+j)==-1)
                {
                    if(x==cost.length-2){
                        System.out.print(cost[x][j]);
                    }
                    if(cost[i][j]<min){
                        min=cost[i][j];
                    }
                }
            }
            sum+=min;
        }
        return sum;
    }
    static void printAns(int[][] cost,StringBuilder ans){
        for(int i=0,j=0;i<cost.length-2;i++,j+=2){
            System.out.print(cost[i][Integer.parseInt(String.valueOf(""+ans.charAt(j)))]+" ");
        }
    }
    static void JA(int[][] cost,StringBuilder ans,int x){
        if(x==cost.length-2){
            for(int i=0;i<cost.length;i++) {
                int k;
                if(ans.indexOf(i+"")==-1){
                    System.out.println("Selected : ");
                    printAns(cost,ans);
                    System.out.print(cost[x][i]+" ");
                    k=findCost(ans,cost)+findMinCost(cost,ans,x,i);
                    System.out.println();
                    System.out.println("Solution : "+k);
                    System.out.println("--------------------");
                }
            }
            return;
        }
        int k=0,min=Integer.MAX_VALUE,t;
        for(int i=0;i<cost.length;i++){
            if(ans.indexOf(""+i)==-1){
                t=findMinCost(cost,ans,x,i);
                //System.out.println(i);
                if(min>t){
                    k=i;
                    min=t;
                }
            }
        }
        ans.append(k+" ");
        JA(cost,ans,x+1);
    }
}
