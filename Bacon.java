//My Solution to Bacon, Eggs, and Spam problem on kattis
import java.util.*;
import java.io.*;
import java.util.PriorityQueue;
public class bacon
{
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    String[] line = br.readLine().split(" ");
    String [][] customers;
    String item;
    String name;
    int size=0;
    PriorityQueue<String> list = new PriorityQueue<String>();
    PriorityQueue<String> order;
    while(Integer.parseInt(line[0])!=0){
      size=Integer.parseInt(line[0]);
      customers= new String[size][10];
      for(int i=0;i<size;i++){
        line = br.readLine().split(" ");
        for(int j=0;j<line.length;j++){
          if(j>=1&&!list.contains(line[j])){
            list.add(line[j]);
          }
          customers[i][j]=line[j];
        }
      }
      while(list.size()>0){
        item=list.poll();
        order = new PriorityQueue<String>();
        System.out.print(item);
        for(int m=0;m<size;m++){
          for(int k=1;k<customers[m].length;k++){
            if(customers[m][k]!=null){
            if(item.equals(customers[m][k])){
              order.add(customers[m][0]);
              break;
            }
            }
          }
        }
        while(order.size()>0){
          name=order.poll();
          System.out.print(" "+name);
        }
        System.out.println();
      }
      System.out.println();
      line = br.readLine().split(" ");
    }
  }
}
