import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Bubble {
	public static int numSwaps;
	
	public static void bubble_srt(Vector<Integer> array) {
		int n = array.size();
		int k;
		for (int m = n; m>=0; m--) {
			for (int i = 0; i<n-1; i++) {
				k = i+1;
				if (array.elementAt(i)>array.elementAt(k)) {
					swapNumbers(i,k,array);
					numSwaps++;
				}
			}
			//printNumbers(array);
		}
		System.out.println(numSwaps + "\n");
		printNumbers(array);
	}
	
	private static void swapNumbers(int i, int j, Vector<Integer> array) {
		int temp;
		temp = array.elementAt(i);
		array.setElementAt(array.elementAt(j), i);
		array.setElementAt(temp, j);
	}
	
	private static void printNumbers(Vector<Integer> input) {
		for (int i = 0; i<input.size(); i++) {
			System.out.print(input.elementAt(i) + " ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//parse in input
		Scanner scanner = new Scanner(new File("Submission.txt"));
		Vector<Integer> v = new Vector<Integer>();
		while (scanner.hasNextInt()) {
			v.add(scanner.nextInt());
		}
		scanner.close();
		//save into array
		numSwaps = 0;
		bubble_srt(v);
	}
}
