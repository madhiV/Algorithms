import java.util.*;
public class SubsetSum {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of items : ");
        int n=scanner.nextInt();
        int[] value=new int[n];
        int[] included=new int[n];
        System.out.println("Enter the values : ");
        for(int i=0;i<n;i++){
            value[i]=scanner.nextInt();
        }
        System.out.println("Enter the subset sum required : ");
        int ans=scanner.nextInt();
        SS(value,included,ans,0,0);
    }
    static void SS(int[] value,int[] included,int ans,int sum,int i){
        if(ans==sum){
            printArray(included);
            return;
        }
        if(i==value.length){
            return;
        }
        else{
            included[i]=1;
            SS(value,included,ans,value[i]+sum,i+1);
            included[i]=0;
            SS(value,included,ans,sum,i+1);
            included[i]=0;
        }
    }
    static void printArray(int arr[]){
        System.out.println("Solution : ");
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
