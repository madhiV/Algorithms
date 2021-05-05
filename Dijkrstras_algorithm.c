//Dijkstra algorithm
#include <stdio.h>
void print(int n,int parent[n],int dist[n]){
    for(int i=0;i<n;i++){
        printf("%d    %d    %d \n",i+1,parent[i],dist[i]);
    }
}
int main()
{
    int n,min,s;
    printf("Enter the number of nodes : ");
    scanf("%d",&n);
    printf("Enter the adjacency matrix : ");
    int graph[n][n],visited[n],parent[n],dist[n];
    for(int i=0;i<n;i++){
        visited[i]=0;
        parent[i]=-1;
        dist[i]=99999;
        for(int j=0;j<n;j++){
            scanf("%d",&graph[i][j]);
        }
    }
    printf("Enter the vertex number to start with : ");
    scanf("%d",&s);
    s--;
    for(int i=0;i<n;i++){
        min=999999;
        if(i==0){
            visited[s]=1;
            dist[s]=0;
            parent[s]=-1;
        }
        else{
            for(int j=0;j<n;j++){
                if(visited[j]==0 && dist[j]<min){
                    min=dist[j];
                    s=j;
                }
            }
            visited[s]=1;
        }
        for(int j=0;j<n;j++){
            if(graph[s][j]>0 && (graph[s][j]+dist[s])<dist[j]){
                dist[j]=graph[s][j]+dist[s];
                parent[j]=s+1;
            }
        }
    }
    printf("Node   parent  distance\n");
    print(n,parent,dist);
}


