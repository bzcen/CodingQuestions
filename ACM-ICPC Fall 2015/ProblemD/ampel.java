import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class ampel {
	/*
	public static int optimize(int [][] likeness, int currItem, int totalItem, int W, int E){
		if (currItem == totalItem){
			return 0;
		}
		int max = 0;
		max = Math.max(max, optimize(likeness, currItem+1, totalItem, W, E) + likeness[currItem][0]*W + likeness[currItem][2]*E);
		max = Math.max(max, optimize(likeness, currItem+1, totalItem, W, E) + likeness[currItem][1]*W + likeness[currItem][3]*E);
		return max;
		
	}
	*/
	public static void main(String [] args){
		File f = new File("ampel.in");
		try{
			Scanner scan = new Scanner(f);
			int d =  scan.nextInt();
			for (int i = 0; i < d; i++){
				int n = scan.nextInt();
				int W = scan.nextInt();
				int E = scan.nextInt();
				
				int [][] likeness = new int[n][4];
				if (n == 0){
					System.out.println("Data Set " + (i+1) + ":");
					System.out.println("0");
					System.out.println();
				} else {
					int totalSum = 0;
					for (int j = 0; j < n; j++){
						for (int k = 0; k < 4; k++){
							likeness[j][k] = scan.nextInt();
						}
						int sum1 = likeness[j][0]*W + likeness[j][2]*E;
						int sum2 = likeness[j][1]*W + likeness[j][3]*E;
						totalSum += Math.max(sum1, sum2);
					}
					System.out.println("Data Set " + (i+1) + ":");
					System.out.println(totalSum);
					System.out.println();
				}
				
			}
			scan.close();
		} catch (Exception e){
			
		}
	}
}
