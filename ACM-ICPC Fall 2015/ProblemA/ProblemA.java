import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class ProblemA {
	public static void main(String [] args){
		File f = new File("wall.in");
		try{
			Scanner scan = new Scanner(f);
			int d =  scan.nextInt();
			for (int i = 0; i < d; i++){
				
				int n =  scan.nextInt();
				int s = scan.nextInt();
				int p = scan.nextInt();
				ArrayList<Integer> allX = new ArrayList<Integer>();
				ArrayList<Integer> allY = new ArrayList<Integer>();
				
				for (int j = 0; j < n+1; j++){
					int x = scan.nextInt();
					int y = scan.nextInt();
					allX.add(x);
					allY.add(y);
				}
				int length = 0;
				for (int j = 0; j < n; j++){
					int x1 = allX.get(j);
					int y1 = allY.get(j);
					int x2 = allX.get(j+1);
					int y2 = allY.get(j+1);
					if (x1 == x2){
						length += Math.abs(y1 - y2);
					} else {
						length += Math.abs(x1-x2);
					}
				}
				int time;
				if ((s*length)%p != 0){
					time = (int)Math.floor((s*length)/(double)p) +1;
				} else {
					time = (int)(s*length/(double)p);
				}
				System.out.println("Data Set " + (i+1) + ":");
				System.out.println(time);
				System.out.println();
			}
			scan.close();
		} catch (Exception e){
			
		}
	}
}
