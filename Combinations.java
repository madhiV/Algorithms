package Combination;
import java.util.*;
public class C {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int N=scanner.nextInt();
        int[] arr=new int[N];
        System.out.println("Enter the elements : ");
        for(int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("Enter the number of elements to select : ");
        int r=scanner.nextInt();
        comb(arr,"",0,r,0);
    }
    static void comb(int[] arr,String ans,int s,int r,int count){
        if(count==r){
            System.out.println(ans);
            return;
        }
        for(int i=s;i<arr.length;i++){
            comb(arr,ans+arr[i],i+1,r,count+1);
        }
    }
}
