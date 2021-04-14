#include<stdio.h>
void main()
{
    int n,e,j;
    printf("Enter the number of elements : ");
    scanf("%d",&n);
    printf("Enter the elements : ");
    int arr[n];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    for(int i=1;i<n;i++){
        e=arr[i];
        j=i-1;
        while(j>=0 && e<arr[j]){
            arr[j+1]=arr[j];
            arr[j]=e;
            j--;
        }
    }
    printf("The elements after sorting : ");
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }
}
