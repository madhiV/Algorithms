#include <stdio.h>
int max(int i,int j){
    if(i>j){
        return i;
    }
    else if(j>1){
        return j;
    }
    return j;
}
void print(int r,int c,int table[r][c]){
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            printf("%d ",table[i][j]);
        }
        printf("\n");
    }
}
int knapsack(int n,int v[n],int w[n],int c,int i){//c is the space left,i is index of item
    if(i<0 || c==0){//base case:if all items are iterated or space is 0
        return 0;
    }
    else if(c-w[i]<0){
        return knapsack(n,v,w,c,i-1);//ith item not feasible
    }
    else{
        return max(knapsack(n,v,w,c,i-1),v[i]+knapsack(n,v,w,c-w[i],i-1));//maximum of profit when ith tem selected and not selected
    }
}
int main()
{
    int n,c,m,p=0;
    printf("Enter the number of items : ");
    scanf("%d",&n);
    int v[n],w[n],ans[n];
    for(int i=0;i<n;i++){
        printf("Enter the weight of the item %d : ",i+1);
        scanf("%d",&w[i]);
        printf("Enter the value of the item %d : ",i+1);
        scanf("%d",&v[i]);
    }
    printf("Enter the knapsack capacity : ");
    scanf("%d",&c);
    printf("The maximum profit is : %d",knapsack(n,v,w,c,n-1));
}
