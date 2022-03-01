import java.util.*;
import java.io.*;
import java.lang.*;
public class Lab4{
  public static int nodes;
public static String[] color;
  public static int[] parent;
  public static int [] d;
  public static int [] f;
  public static int time;
  public static void main(String[]args) throws IOException{
    Scanner sc=new Scanner(System.in);
     File f1=new File("C:\\Users\\USER\\Desktop\\FINAL LAB 221\\LAB 4\\graph.txt");
     
      BufferedReader br=new BufferedReader( new FileReader(f1));
      
      String s=br.readLine();
       nodes=Integer.parseInt(s);
      
      System.out.println(nodes);
      
      int [] [] m=new int[nodes][nodes];
       color=new String[nodes];
   parent=new int[nodes];
  d=new int[nodes];
   f=new int [nodes];
      try{
      StringTokenizer st;
      while((s=br.readLine())!=null){
        st=new StringTokenizer(s);
        while(st.hasMoreTokens()){
          String s1=st.nextToken();
          int row=Integer.parseInt(s1);
          
          String s2=st.nextToken();
          int col=Integer.parseInt(s2);
          
          m[row-1][col-1]=1;
          
        }
      }
      
//      for(int i=0;i<m.length;i++){
//        for(int j=0;j<m.length;j++){
//          
//          System.out.print(m[i][j]);
//        }
//        System.out.println();
//      }
//      
    
      
    }
    catch(Exception e){
      System.out.println("Problem");
      
    }

    
    DFS(m);
    
    //visited/discovered nodes(grey):ascending order of start time
    System.out.println("visited/discovered nodes(grey): ");
    Ascending(d);
    
    //processed/finished nodes(black):ascending order of end time
    
     System.out.println("processed/finished nodes(black): ");
    Ascending(f);
    
   //topological sort : descending order of end time
    System.out.println("Topological sort:");
    Descending(f);
  }


public static void DFS(int[][] m){
  for(int i=0;i<m.length;i++){
  color[i]="WHITE";
  parent[i]=-1;
  
  }
   time=0;
  
  for(int i=0;i<m.length;i++){
    if(color[i]=="WHITE"){
    DFS_VISIT(m,i);
    }
  }


}

public static void DFS_VISIT(int[][]m,int u){
color[u]="GREY";
time=time+1;
d[u]=time;
for(int i=0;i<m.length;i++){
  if(m[u][i]==1){
    if(color[i]=="WHITE"){
    parent[i]=u;
    DFS_VISIT(m,i);
    }
  }
}
color[u]="BLACK";
++time;
f[u]=time;

}
public static void Ascending(int[]a){
int [] b=new int[a.length];
for(int i=0;i<b.length;i++){
b[i]=a[i];
}
Arrays.sort(b);

for(int i=0;i<b.length;i++){
for(int j=0;j<a.length;j++){
  if(b[i]==a[j]){
  System.out.print((j+1)+" ");
  break;
  }

}
}
System.out.println();

}

public static void Descending(int[]a){
int [] b=new int[a.length];
for(int i=0;i<b.length;i++){
b[i]=a[i];
}
Arrays.sort(b);

for(int i=b.length-1;i>=0;i--){
for(int j=0;j<a.length;j++){
  if(b[i]==a[j]){
  System.out.print((j+1)+" ");
  break;
  }

}
}
System.out.println();

}

}