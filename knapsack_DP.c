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
int main()
{
    int n,c,m;
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
    int table [n+1][c+1];
    for(int i=0;i<n+1;i++){
        for(int j=0;j<c+1;j++){
            if(i==0 || j==0){
                table[i][j]=0;
                continue;
            }
            printf("%d %d\n",j,w[i-1]);
            if(j-w[i-1]<0){
                table[i][j]=table[i-1][j];
            }
            else{
                table[i][j]=max(table[i-1][j],v[i-1]+table[i-1][j-w[i-1]]);
            }
        }
    }
    print(n+1,c+1,table);
    m=table[n][c];
    printf("Maximum profit is %d.\n",m);
    for(int i=n;i>0;i--){
        for(int j=c;j>0;j--){
            if(table[i-1][j]!=m){
                ans[i-1]=1;
                m-=v[i-1];
                break;
            }
            else{
                ans[i-1]=0;
                break;
            }
        }
    }
    printf("Selected items : {");
    for(int i=0;i<n;i++){
        printf("%d,",ans[i]);
    }
    printf("\b}");
    
}


