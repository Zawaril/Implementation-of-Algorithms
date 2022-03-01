import java.util.*;
public class Lab09{
  public static void main(String[]args){
  Scanner sc=new Scanner(System.in);
  
  int[] value={5,8,2,10};
  int [] weight={2,3,1,2};
  int n=5;
  
  int m=Knapsack(n,weight,value);
  
  System.out.println(m);
  
  
  
   
  int[] v1={2,3,5};
  int [] w1={2,3,5};
   n=5;
  
   m=Knapsack(n,w1,v1);
  
  System.out.println(m);
  
  
  
  
  }
  

  public static int Knapsack(int n,int[] W,int[] v){
  int [][] m=new int[W.length+1][n+1];
  String [][] s=new String [W.length+1][n+1];
  
  for(int i=0;i<=n;i++){
  m[0][i]=0;
  s[0][i]=" ";
  }
  for(int j=0;j<=W.length;j++){
  m[j][0]=0;
  s[j][0]=" ";
  }
  
  for(int i=1;i<=W.length;i++){
    for(int j=1;j<=n;j++){
      if(j<W[i-1]){
      m[i][j]=m[i-1][j];
      s[i][j]=s[i-1][j]+" ";
      
      }
      else{
     // System.out.println(i);
      m[i][j]=Math.max(v[i-1]+m[i-1][j-W[i-1]],m[i-1][j]);
      if( m[i][j]==v[i-1]+m[i-1][j-W[i-1]]){
      s[i][j]=s[i-1][j-W[i-1]]+" "+v[i-1];
      }
      else{
        s[i][j]=s[i-1][j]+" ";
      }
      }
    
    }
  
  }
  System.out.println(s[W.length][n]);
  return m[W.length][n];
  
  }
  

}
