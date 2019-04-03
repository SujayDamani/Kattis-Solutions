//My solution to Erase Securely on Kattis.
import java.util.*;
import java.io.*;
public class erase
{
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    String[] line = br.readLine().split(" ");
    int hit=Integer.parseInt(line[0]);
    String[] one = br.readLine().split("");
    boolean boo=true;
    String[] two = br.readLine().split("");
    if(hit%2==1){
      for(int i=0;i<one.length;i++){
        if((one[i].equals(two[i]))){
          boo=false;
          System.out.println("Deletion failed");
          break;
        }
      }
    }
    else{
      for(int i=0;i<one.length;i++){
        if(!(one[i].equals(two[i]))){
          boo=false;
          System.out.println("Deletion failed");
          break;
        }
      }
    }
    if(boo)
    System.out.println("Deletion succeeded");
  }

}
