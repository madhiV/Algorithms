#include <stdio.h>
void strassens(int r1,int r2,int c1,int c2,int a[r1][c1],int b[r2][c2],int c[r1][c2]){
    int m1,m2,m3,m4,m5,m6,m7;
    m1=(a[0][0]+a[1][1])*(b[0][0]+b[1][1]);
    m2=(a[1][0]+a[1][1])*b[0][0];
    m3=a[0][0]*(b[0][1]-b[1][1]);
    m4=a[1][1]*(b[1][0]-b[0][0]);
    m5=(a[0][0]+a[0][1])*b[1][1];
    m6=(a[1][0]-a[0][0])*(b[0][0]+b[0][1]);
    m7=(a[0][1]-a[1][1])*(b[1][0]+b[1][1]);
    c[0][0]=m1+m4-m5+m7;
    c[0][1]=m3+m5;
    c[1][0]=m2+m4;
    c[1][1]=m1+m3-m2+m6;
}
void s(int r1,int r2,int c1,int c2,int a[r1][c1],int b[r2][c2],int c[r1][c2]){
    
}
void printmatrix(int r,int c,int m[r][c]){
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            printf("%d ",m[i][j]);
        }
        printf("\n");
    }
}
int main()
{
    int r1,r2,c1,c2;
    printf("Enter the number of rows of matrix 1 : ");
    scanf("%d",&r1);
    printf("Enter the number of columns of matrix 1 : ");
    scanf("%d",&c1);
    printf("Enter the number of rows of matrix 2 : ");
    scanf("%d",&r2);
    printf("Enter the number of columns of matrix 2 : ");
    scanf("%d",&c2);
    int a[r1][c1],b[r2][c2],c[r1][c2];
    printf("Enter the matrix 1 values : \n");
    for(int i=0;i<r1;i++){
        for(int j=0;j<c1;j++){
            scanf("%d",&a[i][j]);
        }
    }
    printf("Enter the matrix 2 values : \n");
    for(int i=0;i<r2;i++){
        for(int j=0;j<c2;j++){
            scanf("%d",&b[i][j]);
        }
    }
    strassens(r1,r2,c1,c2,a,b,c);
    printf("Matrix 1 : \n");
    printmatrix(r1,c1,a);
    printf("Matrix 2 : \n");
    printmatrix(r2,c2,b);
    printf("Product Matrix : \n");
    printmatrix(r1,c2,c);
}

