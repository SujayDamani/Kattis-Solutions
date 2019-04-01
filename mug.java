//V00875386 Damani, Sujay
import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Math;
public class mug{
  public static void main(String[]args)throws IOException{
    try {
      BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
      String line = br.readLine();
      /*for(int j=0;j<101;j=j+2){
        System.out.println();
        System.out.print(j+" ");
        int num=j;*/
        int num=Integer.parseInt(line);
        if(num>=0&&num<=200000){
          if(num%2==0){
            if(Math.sqrt(num)-Math.floor(Math.sqrt(num))==0){
            double a=Math.sqrt(num);
            System.out.printf("0 %.0f",a);
          }
          else if(Math.sqrt(num+1)-Math.ceil(Math.sqrt(num))==0){
            double a=Math.sqrt(num+1);
            System.out.printf("1 %.0f",a);
          }
          else if(num==2){
            System.out.printf("impossible");
          }
          else if(num>4){
            int x=((num/2)+2)/2;
            int y=Math.abs((num/2)-x);


            if(Math.pow(x,2)-Math.pow(y,2)==num){
              System.out.print(y+" ");
              System.out.print(x);
            }
            else{
              System.out.printf("impossible");
            }

          }

        }
        else {
          if(Math.sqrt(num)-Math.floor(Math.sqrt(num))==0){
            double a=Math.sqrt(num);
            System.out.printf("0 %.0f",a);
          }
          else if(Math.sqrt(num+1)-Math.ceil(Math.sqrt(num))==0){
            double a=Math.sqrt(num+1);
            System.out.printf("1 %.0f",a);
          }
          else{
            int x=0;
            for(int i = 1; i <= num; i++) {
               if(num%i == 0) {
                    x=i;
                 }
               }
               if(x!=1){
                int y=num/x;
                int a=Math.abs((x+y)/2);
                int b=Math.abs(x-a);
                System.out.print(b+" ");
                System.out.print(a);
               }
               else{
                 System.out.printf("impossible");
               }
          }


      // }
      }
    }
    else{
      System.out.printf("impossible");
    }
//  }

}
catch (Throwable t) {
}

  }
}
