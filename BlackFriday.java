//My Solution to Black Friday Problem
import java.util.*;
import java.io.*;
public class black
{
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    String[] line = br.readLine().split(" ");
    int []num=new int [7];
    line = br.readLine().split(" ");
    for(int i=0;i<line.length;i++){
      num[Integer.parseInt(line[i])]++;
    }
    int acc=0;
    for(int j=0;j<num.length;j++){
      if(num[j]==1) {
        if(j>acc)
        acc=j;
      }
    }
    int ans=0;

    if(acc!=0){
      for(int k=0;k<line.length;k++){
        if(acc==Integer.parseInt(line[k]))
        ans=k+1;
      }
      System.out.println(ans);
    }
    else{
      System.out.println("none");
    }
  }
}
