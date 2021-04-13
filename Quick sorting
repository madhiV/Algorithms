#include<stdio.h>
void printarray(int arr[],int n){
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }
    printf("\n");
}
int partition(int arr[],int l,int r){
    int i=l,j=r,pivot=arr[l],temp;
    while(i<j){
        do{
            i++;
        }while(arr[i]<=pivot);
        do{
            j--;
        }while(arr[j]>pivot);
        if(i<j){
            temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
    }
    arr[l]=arr[j];
    arr[j]=pivot;
    return j;
}
void quicksort(int arr[],int l,int r){
    if(l<r){
        int j=partition(arr,l,r);
        quicksort(arr,l,j);
        quicksort(arr,j+1,r)   ;
    }
}
void main()
{
    int n;
    printf("Enter the number of elements : ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the elements : ");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    printf("Array before sort : ");
    printarray(arr,n);
    quicksort(arr,0,n);
    printf("Array after sort : ");
    printarray(arr,n);
}
