import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number of elements in the array : ");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements : ");
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        mergesort(arr);
        System.out.println("The array after the merge sort : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void mergesort(int arr[])
    {
        if(arr.length>1){
            int m=arr.length/2;
            int[] b=new int[m];
            int[] c=new int[arr.length-m];
            for(int i=0;i<m;i++){
                b[i]=arr[i];
            }
            for(int i=0,q=m;i<arr.length-m;i++,q++){
                c[i]=arr[q];
            }
            mergesort(b);
            mergesort(c);
            merge(b,c,arr);
        }
    }
    static void merge(int[] b,int[] c,int[] a){
        int i,j,k,n1,n2;
        i=j=k=0;
        n1=b.length;
        n2=c.length;
        while(i<n1 && j<n2){
            if(b[i]<=c[j]){
                a[k]=b[i];
                i++;
            }
            else{
                a[k]=c[j];
                j++;
            }
            k++;
        }
        for(;i<n1;i++){
            a[k]=b[i];
            k++;
        }
        for(;j<n2;j++){
            a[k]=c[j];
            k++;
        }
    }
}
