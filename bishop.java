//My solution to "Bishops" problem on kattis
import java.util.*;
import java.io.*;
import java.lang.Math;
public class right{
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    int[] array=new int[101];
    int i=1;
    int max_length=0;
    String num;
    while((num=br.readLine())!=null){
      String[] line = num.split("");
      array[i]=line.length;
      if(line.length>max_length){
        max_length=line.length;
      }
      i++;
    }
    double sum=0;
    for(int j=0;j<i-1;j++){
      if(array[j]<max_length&&array[j]!=0){
        sum=sum+Math.pow((max_length-array[j]),2);
      }
    }
    System.out.printf("%.0f",sum);
  }
}"
import java.util.*;
import java.io.*;
public class bishop{
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    String num;
    while((num=br.readLine())!=null){
    int line =Integer.parseInt(num);
    if(line==1){
      System.out.println(line);
    }
    else{
      int a=(2*line)-2;
        System.out.println(a);
    }

    }
  }
}
