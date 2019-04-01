//My solution to 'Kastenlauf' on Kattis
import java.util.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class Kastenlauf
{
  public static int distance(int x1,int y1,int x2, int y2){
    int sqrx=Math.abs(x2-x1);
    int sqry=Math.abs(y2-y1);
    int dist=sqrx+sqry;
    return dist;
  }
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    String[] aline = br.readLine().split(" ");  // line of ints
    int cases = Integer.parseInt( aline[0] );
    int [][]location;
    Queue<Integer> place;

    int beers=0;
    int distance=0;
    for(int i=0;i<cases;i++){
      place=new LinkedList<>();
      aline = br.readLine().split(" ");
      beers = Integer.parseInt( aline[0] );
      location=new int [beers+2][2];
      for(int j=0;j<beers+2;j++){
        aline = br.readLine().split(" ");
        location[j][0]=Integer.parseInt(aline[0]);
        location[j][1]=Integer.parseInt(aline[1]);
      }
      boolean[] boo= new boolean[beers+2];
      place.add(0);
      while(place.size()>0){
        int num=place.remove();
        if(!boo[num]){
          boo[num]=true;
          for(int k=0;k<boo.length;k++)
          {
            if(k!=num){
            distance=distance(location[k][0],location[k][1],location[num][0],location[num][1]);
            if((distance<=1000)){
                place.add(k);
              }
            }
          }
        }
      }
      //System.out.println(boo.length);
      if(boo[beers+1]){
        System.out.println("happy");
      }
      else{
        System.out.println("sad");
      }


    }
  }
}
