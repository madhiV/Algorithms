#include <stdio.h>
#include<string.h>
void print(int n,char nodes[n][n],char parent[n][n],int weight[n]){
    for(int i=0;i<n;i++){
        printf("%s->%s            %d\n",parent[i],nodes[i],weight[i]);
    }
    printf("\n");
}
int main()
{
    int n,s,min,sum=0;
    printf("Enter the number of nodes : ");
    scanf("%d",&n);
    int graph[n][n],visited[n],weight[n];
    char nodes[n][n],parent[n][n];
    printf("Enter the node names : ");
    for(int i=0;i<n;i++){
        scanf("%s",&nodes[i]);
    }
    printf("Enter the adjacency matrix representation : \n");
    for(int i=0;i<n;i++){
        visited[i]=0;
        strcpy(parent[i],"-");
        weight[i]=9999999;
        for(int j=0;j<n;j++){
            scanf("%d",&graph[i][j]);
        }
    }
    printf("Enter the position of the node to start from : ");
    scanf("%d",&s);
    s--;
    for(int i=0;i<n;i++){
        if(i==0){
            visited[s]=1;
            weight[s]=0;
        }
        else{
            min=99999999;
            for(int j=0;j<n;j++){
                if(visited[j]==0){
                    if(weight[j]<min){
                        min=weight[j];
                        s=j;
                    }
                }
            }
            visited[s]=1;
        }
        sum+=weight[s];
        for(int j=0;j<n;j++){
            if(visited[j]==0 && graph[s][j]>0){
                if(graph[s][j]<weight[j]){
                    weight[j]=graph[s][j];
                    strcpy(parent[j],nodes[s]);//parent[j]=nodes[s];
                }
            }
        }
    }
    printf("Parent->Child  Weight\n");
    print(n,nodes,parent,weight);
    printf("The Cost of Minimum spanning tree is : %d",sum);
}



