//my solution to "Compound Words" problem on Kattis
import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Math;
import java.util.PriorityQueue;
public class cw{
public static void main(String[]args) throws IOException{
  BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
  String num;
  PriorityQueue<String> words = new PriorityQueue<String>();

  while((num=br.readLine())!=null){
    String[] line = num.split(" ");
    for (int i=0;i<line.length;i++ ) {
      if(!words.contains(line[i]))
      words.add(line[i]);
    }
  }
  String[] arr=new String[words.size()];
  PriorityQueue<String> work = new PriorityQueue<String>();
  String cool;
  for(int j=0;j<arr.length;j++)
  arr[j]=words.poll();
  for(int k=0;k<arr.length;k++){
    for(int m=0;m<arr.length;m++){
      if(m!=k){
        cool=arr[k]+arr[m];
        //System.out.println(cool)
        if(!work.contains(cool)){
          work.add(cool);
        }

      }

    }
  }
  while(work.size()>0)
  System.out.println(work.poll());
 }
}
