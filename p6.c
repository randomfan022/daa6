#include<stdio.h> 
#include<stdlib.h> 
#include<time.h> 
int visited[10],a[10][10],n; 
void bfs(int city) 
{ 
 int f=0,r=-1,i,temp,q[10]; 
 q[++r]=city; 
 visited[city]=1; 
 while(f<=r) 
 { 
 temp=q[f++]; 
 for(i=0;i<n;i++) 
 { 
 if(a[temp][i]==1 && visited[i]==0) 
 { 
 q[++r]=i; 
 printf("%d %d\n",temp,i); 
 visited[i]=1; 
 } 
 } 
 } 
} 
int main(){ 
 int i,j,src; 
 clock_t start,end; 
 double clk; 
 printf("ENTER THE NO. OF CITIES\n"); 
 scanf("%d",&n); 
 
 printf("ENTER THE MATRIX REPRESENTATION\n"); 
 for(i=0;i<n;i++) 
 { 
 for(j=0;j<n;j++) 
 { 
 scanf("%d",&a[i][j]); 
 } 
 visited[i]=0; 
 } 
 
 
 printf("ENTER SOURCE CITY\n"); 
 scanf("%d",&src); 
 
 printf("THE BREADTH-FIRST SEARCH PATH IS:\n"); 
 start=clock(); 
 bfs(src); 
 end=clock(); 
 clk=(double)(end-start)/CLOCKS_PER_SEC; 
 printf("\n"); 
 
 printf("TIME TAKEN FOR EXECUTION: %f\n",clk); 
} 
