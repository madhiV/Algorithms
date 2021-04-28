#include <stdio.h>
//Warshall's algorithm
int main()
{
    int n;
    printf("Enter the number of nodes of the graph : ");
    scanf("%d",&n);
    printf("Enter the adjacency matrix representation of the unweighted graph : \n");
    int graph[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d",&graph[i][j]);
        }
    }
    for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==k || j==k){
                    continue;
                }
                graph[i][j]=graph[i][j]||graph[i][k]&&graph[k][j];
            }
        }
    }
    printf("The transitive closure of the graph : \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%d ",graph[i][j]);
        }
        printf("\n");
    }
}

