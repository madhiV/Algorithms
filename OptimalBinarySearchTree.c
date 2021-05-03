//optimal binary search tree
//Time complexity O(n^4)
#include <stdio.h>
void printTable(int n,float table[n][n]){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%f ",table[i][j]);
        }
        printf("\n");
    }
}
void printRoots(int n,int table[n][n]){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%d ",table[i][j]);
        }
        printf("\n");
    }
}
int main()
{
    int n;
    printf("Enter the number of keys : ");
    scanf("%d",&n);
    printf("Enter the frequencies of the keys:\n ");
    int key[n];
    float frequency[n];
    for(int i=0;i<n;i++){
        scanf("%f",&frequency[i]);
    }
    float table[n+1][n+1];
    int r[n+1][n+1];
    for(int i=0;i<n+1;i++){
        for(int j=0;j<n+1;j++){
            table[i][j]=-1;
            r[i][j]=-1;
            if(i-j==0){//for first diagonal
                table[i][j]=0;
            }
            else if(j-i==1){//for second diagonal
                table[i][j]=frequency[i];
                r[i][j]=i+1;
            }
        }
    }
    for(int z=2;z<n+1;z++){//for next each diagonals
    for(int i=0;i<n+1;i++){
        for(int j=0;j<n+1;j++){
            if(j-i==z){
                float min=99999;
                for(int k=i;k<j;k++){
                    if(table[i][k]+table[k+1][j]<min){
                        min=table[i][k]+table[k+1][j];
                        r[i][j]=k+1;
                    }
                }
                for(int k=i+1;k<j+1;k++){
                    min+=frequency[k-1];
                }
                table[i][j]=min;
                break;
            }
        }
    }
    }
    printf("Table : \n");
    printTable(n+1,table);
    printf("Root table : \n");
    printRoots(n+1,r);
}

