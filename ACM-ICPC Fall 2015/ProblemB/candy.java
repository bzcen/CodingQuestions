import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class candy {
	private int[]planes;
	private int[][]pilots;
	private int totalPilots;
	private int planesLeft;
	
	private candy(int [] planes, int [][] pilots, int totalPilots){
		this.planes = planes;
		this.pilots = pilots;
		this.totalPilots = totalPilots;
		planesLeft = planes.length;
	}
	
	public int optimize(int currPilot){
		if (currPilot == totalPilots || planesLeft == 0){
			return 0;
		}
		int max = -1000;
		for (int i = 0; i < pilots[currPilot].length; i++){
			if (pilots[currPilot][i] == 1 && planes[i] == 1){
				planes[i] = 0;
				planesLeft--;
				max = Math.max(max, optimize(currPilot+1) + 1);
				planes[i] = 1;
				planesLeft++;
			}
		}
		max = Math.max(max, optimize(currPilot+1));
		return max;
		
	}
	public static void main(String [] args){
		File f = new File("candy.in");
		try{
			Scanner scan = new Scanner(f);
			int d =  scan.nextInt();
			for (int i = 0; i < d; i++){

				int numPlanes = scan.nextInt();
				int numPilots = scan.nextInt();
				if (numPilots == 0){
					System.out.println("Data Set " + (i+1) + ":");
					System.out.println("0");
					System.out.println();
				} else if (numPlanes == 0){
					for (int j = 0; j < numPilots; j++){
						int x = scan.nextInt();
					}
					System.out.println("Data Set " + (i+1) + ":");
					System.out.println("0");
					System.out.println();
				} else {
					int [] planes = new int[numPlanes];
					int [][] pilots = new int[numPilots][numPlanes];
					
					//System.out.println("test");
					for (int j = 0; j < numPlanes; j++){
						planes[j] = 1;
					}
					for (int j = 0; j < numPilots; j++){
						for (int k = 0; k < numPlanes; k++){
							pilots[j][k] = 0;
						}
					}
	
					for (int j = 0; j < numPilots; j++){
						int mPlanes = scan.nextInt();
						for (int k = 0; k < mPlanes; k++){
							int planeNum = scan.nextInt() - 1;
							pilots[j][planeNum] = 1;
						}
					}
					candy c = new candy(planes, pilots, numPilots);
					System.out.println("Data Set " + (i+1) + ":");
					System.out.println(c.optimize(0));
					System.out.println();
				}
				
			}
			scan.close();
		} catch (Exception e){
			
		}
	}
}
