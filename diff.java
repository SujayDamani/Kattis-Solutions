//V00875386 Damani, Sujay
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.math.BigInteger;
public class diff
{
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    String num;

    while((num=br.readLine())!=null){
      String[] line = num.split(" ");
      BigInteger x=new BigInteger(line[0]);
      BigInteger y=new BigInteger(line[1]);
      if(x.compareTo(y)==1){
        System.out.println(x.subtract(y));
      }
      else{
        System.out.println(y.subtract(x));
      }
    }
  }
}
