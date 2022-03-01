import java.util.*;
import java.lang.*;
public class Lab08_LCS{
  public static void main(String[]args){
  Scanner sc=new Scanner(System.in);
  String s1=sc.next();
  String s2=sc.next();
  
  String[] s=LCS(s1,s2);
  System.out.println("Longest Common Sequence : ");
  for(int i=0;i<s.length;i++){
  System.out.print(s[i]);
  }
  System.out.println();
  System.out.println("Length of the Sequence :"+s.length);
  
  }
  public static String[] LCS(String s1,String s2){
  int x=s1.length()+1;
  int y=s2.length()+1;
  int[][] cost=new int[x][y];
  int [][] direction=new int[x][y];//0=no direction,1=corner,2=up,3=left
  for(int i=0;i<x;i++){
  cost[i][0]=0;
  direction[i][0]=0;
  }
   for(int i=0;i<y;i++){
  cost[0][i]=0;
  direction[0][i]=0;
  }
   for(int i=1;i<x;i++){
     for(int j=1;j<y;j++){
       if(s1.charAt(i-1)==s2.charAt(j-1)){
       cost[i][j]=cost[i-1][j-1]+1;
       direction[i][j]=1;//corner=1
       }
       else if(cost[i-1][j]>=cost[i][j-1]){
       cost[i][j]=cost[i-1][j];
       direction[i][j]=2;//up=2
       }
       else{
        cost[i][j]=cost[i][j-1];
       direction[i][j]=3;//left=3
       }
     
     }
   }
   System.out.println("Cost MATRIX :");
   for(int i=0;i<x;i++){
     for(int j=0;j<y;j++){
       System.out.print(cost[i][j]+" ");
     }
     System.out.println();
   }
     System.out.println("Direction MATRIX :");
   for(int i=0;i<x;i++){
     for(int j=0;j<y;j++){
       System.out.print(direction[i][j]+" ");
     }
     System.out.println();
   }
   
  
   //back Tracking
   int ss=cost[x-1][y-1]-1;
    
   String[] lcs=new String[ss+1];
   int i=x-1;
   int j=y-1;
   while(ss>=0){
     if(direction[i][j]==1){
    lcs[ss]=s1.charAt(i-1)+"";
     i--;
     j--;
     ss--;
     
     }
     else if(direction[i][j]==2){
     i--;
     }
     else if(direction[i][j]==3){
     j--;
     }
   }
   return lcs;
  
  }

}