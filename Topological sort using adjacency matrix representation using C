#include<stdio.h>
#include<stdlib.h>
void main()
{
    int n,e,z,e1,e2,v,w=0;
    printf("Enter the number of nodes in the graph : ");
    scanf("%d",&n);
    int graph[n][n],indegree[n],visited[n],ans[n];
    printf("Enter the adjacency matrix of the graph : \n");
    for(int i=0;i<n;i++){
        indegree[i]=0;
    }
    for(int i=0;i<n;i++){
        visited[i]=0;
        for(int j=0;j<n;j++){
            scanf("%d",&graph[i][j]);
            if(graph[i][j]==1){
                indegree[j]+=1;
            }
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(indegree[j]==0 && visited[j]==0){
                v=j;
                break;
            }
            if(j==n-1){
                printf("The graph has cycles...Error...\n");
                exit(0);
            }
        }
        visited[v]=1;
        ans[w]=v+1;
        w++;
        for(int j=0;j<n;j++){
            if(graph[v][j]>0){
                graph[v][j]=0;
                indegree[j]--;
            }
        }
    }
    printf("The answer is : ");
    for(int i=0;i<n;i++){
        printf("%d ",ans[i]);
    }
}
