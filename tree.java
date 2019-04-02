//V00875386 Damani, Sujay
import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class tree{
  static Node root;
  static class Node {
		int value;
		int nodes = 0;
		BigInteger permutation;
		Node[] child = new Node[2];
		Node(int num) {
      this.value = num;
    }
	}
  static BigInteger factorial(int start, int end) {
		BigInteger x = new BigInteger("1");
		while (end>start) {
			x = x.multiply(BigInteger.valueOf(end));
      end--;
		}
		return x;
	}


	static void add(Node parent,int value) {
    int num=0;
		while (parent.child[num] != null) {
			parent = parent.child[num];
      if(value<parent.value){
        num=0;
      }
      else{
        num=1;
      }
		}
		parent.child[num] = new Node(value);
	}

	static void calculate(Node n) {
		int[] arr1 = new int[2];
    BigInteger[] arr = new BigInteger[2];
    for (int j = 0; j < 2; ++j) {
			Node temp = n.child[j];
			if (temp == null) {
				arr[j] = new BigInteger("1");
			} else {
				calculate(temp);
        arr1[j] = temp.nodes;
				arr[j] = temp.permutation;
			}
		}
		n.nodes= arr1[0] + arr1[1] + 1;
    int a=arr1[0]+arr1[1];
    int b=arr1[0];
    if (b > a/2){
       b = a-b;
    }
    BigInteger num=factorial(a-b, a).divide(factorial(0, b));;
		n.permutation = arr[0].multiply(arr[1]).multiply(num);
	}


	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line=br.readLine())!=null){

      if(Integer.parseInt(line)==0){
        break;
      }
      int size=Integer.parseInt(line);
      String []cool=br.readLine().split(" ");
			root = new Node(0);
			for(int i=0;i<size;i++) {
				add(root,Integer.parseInt(cool[i]));
			}
			calculate(root);
			System.out.println(root.permutation);
    }
	}
}
