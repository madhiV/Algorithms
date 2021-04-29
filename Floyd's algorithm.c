//Floyd's algorithm
#include <stdio.h>
void printgraph(int n,int graph[n][n]){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%d ",graph[i][j]);
        }
        printf("\n");
    }
}
void main()
{
    int n;
    printf("Enter ther number of nodes : ");
    scanf("%d",&n);
    int graph[n][n];
    printf("Enter the adjacency matrix representation of the graph : \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d",&graph[i][j]);
        }
    }
    printf("The adjacency matrix of the graph is : \n");
    printgraph(n,graph);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i==j){
                continue;
            }
            else if(graph[i][j]==0){
                graph[i][j]=99999;
            }
        }
    }
    for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    graph[i][j]=0;
                    continue;
                }
                else if(i==k || j==k){
                    continue;
                }
                if(graph[i][j]>graph[i][k]+graph[k][j]){
                    graph[i][j]=graph[i][k]+graph[k][j];
                }
            }
        }
    }
    //printing (APSP-All Pairs Shortest Path)graph
    printf("The All Pairs Shortest Path for the given matrix is : \n");
    printgraph(n,graph);
}

