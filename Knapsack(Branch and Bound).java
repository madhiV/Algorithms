import java.util.*;
public class Knapsack {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,W;
        System.out.println("Enter the number of items : ");
        n=scanner.nextInt();
        int[] w=new int[n+1];
        int[] v=new int[n+1];
        System.out.println("Enter the items's weight and value(in sorted order of their value/weight) ) : ");
        w[0]=v[0]=0;
        for(int i=1;i<n+1;i++){
            w[i]=scanner.nextInt();
            v[i]=scanner.nextInt();
        }
        System.out.println("Enter the capacity of the bag : ");
        W=scanner.nextInt();
        KP(v,w,W,0,0,0);
    }
    static void KP(int[] v,int[] w,int W,int profit,int x,int c){
        if(x==w.length){
            System.out.println(findMaxUB(v,w,W,profit,x,c));
            return;
        }
        int with=-1,without;
        if(c+w[x]<=W){
            with=findMaxUB(v,w,W,profit+v[x],x,c+w[x]);
        }
        without=findMaxUB(v,w,W,profit,x,c);
        if(with>without){
            KP(v,w,W,profit+v[x],x+1,c+w[x]);
        }
        else{
            KP(v,w,W,profit,x+1,c);
        }
    }
    static int findMaxUB(int[] v,int[] w,int W,int profit,int x,int c){
        if(x==w.length || x==w.length-1){
            return profit;
        }
        else{
            return profit+(W-c)*(v[x+1]/w[x+1]);
        }
    }
}
