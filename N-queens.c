#include <stdio.h>
#include<stdbool.h>
#include <stdlib.h>
void printBoard(int n,int B[][n]){
    printf("Solution : \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%d ",B[i][j]);
        }
        printf("\n");
    }
}
bool canPlace(int n,int B[][n],int x,int y){
    //left upper diagonal
    for(int i=x-1,j=y-1;i>=0,j>=0;i--,j--){
        if(B[i][j]==1){
            return false;
        }
    }
    //right upper diagonal
    for(int i=x-1,j=y+1;i>=0,j<=n-1;i--,j++){
        if(B[i][j]==1){
            return false;
        }
    }
    //same column
    for(int i=0;i<x;i++){
        if(B[i][y]==1){
            return false;
        }
    }
    return true;
}
bool placeQueen(int n,int B[][n],int r){
    if(r==n){
        printBoard(n,B);
        return true;
    }
    for(int i=0;i<n;i++){
        if(canPlace(n,B,r,i)==true){
            B[r][i]=1;
            //printf("%d %d\n",r,i);
            placeQueen(n,B,r+1);
        }
        B[r][i]=0;
    }
    //return false;
}
void solveQueen(int n){
    int B[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            B[i][j]=0;
        }
    }
    placeQueen(n,B,0);
}
int main()
{
    int n;
    printf("Enter the number of queens : ");
    scanf("%d",&n);
    solveQueen(n);
    return 0;
}
