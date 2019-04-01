//V00875386 Damani, Sujay
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class kitten
{
  public static void main(String[]args)
  {
    Scanner in = new Scanner(System.in);


    //String line=in.next();
    int key=0;
    String first=in.nextLine();
    //int ans=key;
    int pick=0;
    int value=0;
    int kel=0;
    int array1[]=new int[100000];
    String array[]=new String [10000];
    while(in.hasNextLine())
    {
      array=first.split(" ");
      if(pick==0){
        kel=Integer.parseInt(array[0]);
      }
      for(int i=0;i<array.length;i++){
        value=Integer.parseInt(array[i]);
        if(i==0){
          key=value;
        }
        else{
          array1[value]=key;
        }
      }
      first=in.nextLine();
      pick++;
    }
    while(array1[kel]!=0){
      System.out.println(kel);
      kel=array1[kel];
    }
    System.out.println(kel);
  }
}
