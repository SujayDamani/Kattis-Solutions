//My solution to Cookie Selection problem on Kattis
import java.util.*;
import java.io.*;
import java.util.PriorityQueue;
public class cookie
{
  public static void main(String[]args)throws IOException
  {
  //  Scanner in = new Scanner(System.in);
  BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    int val=0;
    int out=0;
    String line = br.readLine();


    PriorityQueue<Integer> min = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> max = new PriorityQueue<Integer>();
    while(line!=null){
      if(Character.isDigit(line.charAt(0))){
        val=Integer.parseInt(line);
        if(val>=1&&val<=300000000){
          if(min.size()==0){
            min.add(val);
          }
          else if(max.size()==0){
            max.add(val);
          }
          else if(val<=max.peek()) {
            min.add(val);
        	  if (min.size()-max.size()>1)
        	    max.add(min.poll());
          }
          else {

              max.add(val);
              if(max.size()-min.size()>1){
                min.add(max.poll());
              }
            }
        }
      }
      else {
        if(min.size()-max.size()<0){
          out=max.poll();
        }
        else if((max.size()+min.size())%2==0){
          out=max.poll();
        }
        else{
          out=min.poll();
        }


        System.out.println(out);
      }


          line = br.readLine();

    }

  }
}
