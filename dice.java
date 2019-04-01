  //My solution to Dice Betting on Kattis
  import java.util.*;
  import java.io.*;
  public class dice{
    static Double arr[][];
    static int sides;
    static int diff_numbers;
    static double P(int r,int d){
      if(d>=diff_numbers){
        return 1;
      }
      else if(r==0){
        return 0;
      }

      else if(arr[r][d]!=null){
        return arr[r][d];
      }
      else{
      double cool=(double)d/sides;
      double ans =cool*P(r-1,d)+(1-cool)*P(r-1,d+1);
      return arr[r][d]=ans;
    }
    }
    public static void main(String[]args)throws IOException{
      BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
      String []input=in.readLine().split(" ");
      int r=Integer.parseInt(input[0]);
      sides=Integer.parseInt(input[1]);
      diff_numbers=Integer.parseInt(input[2]);
      arr=new Double [r+1][sides+1];
      double ans=P(r,0);
      System.out.printf("%.09f",ans);
    }
  }
