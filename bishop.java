//V00875386 Damani, Sujay
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
