//fibonacci DP
#include <stdio.h>
int main()
{
    int f[1000],p;
    f[0]=0;
    f[1]=1;
    printf("Enter the position of the number to display : ");
    scanf("%d",&p);
    for(int i=2;i<p;i++){
        f[i]=f[i-1]+f[i-2];
    }
    printf("The term %d of the fibonacci series is : %d",p,f[p-1]);
}

