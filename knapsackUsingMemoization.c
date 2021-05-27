#include <stdio.h>
#include <stdlib.h>
int max(int a,int b){
    int c=(a>b)?a:b;
    return c;
}
void print(int n,int c,int mem[n][c]){
    printf("\nMemoization table : \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<c;j++){
            printf("%d ",mem[i][j]);
        }
        printf("\n");
    }
}
int knapsack(int n,int c,int w[n],int v[n],int space,int i,int profit,int mem[][c]){
    int res;
    if(i==-1 || space-w[i]<0){
        return profit;
    }
    else{
        if(mem[i][space-1]==-1){
            res=max(knapsack(n,c,w,v,space,i-1,profit,mem),knapsack(n,c,w,v,space-w[i],i-1,profit,mem)+v[i]);
            mem[i][space-1]=res;
            return res;
        }
        return mem[i][space-1];
    }
}
int main()
{
    int n,c;
    printf("Enter the number of items : ");
    scanf("%d",&n);
    printf("Enter the capacity of the bag : ");
    scanf("%d",&c);
    int w[n],v[n],mem[n][c];
    for(int i=0;i<n;i++){
        printf("Enter the weight and value of the item %d : ",i+1);
        scanf("%d %d",&w[i],&v[i]);
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<c;j++){
            mem[i][j]=-1;
        }
    }
    printf("Maximum knapsack capacity is : %d",knapsack(n,c,w,v,c,n-1,0,mem));
    print(n,c,mem);
    return 0;
}
