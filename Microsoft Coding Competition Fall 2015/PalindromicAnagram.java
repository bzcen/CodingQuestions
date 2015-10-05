import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PalindromicAnagram {
	int x;
	int y;
	public PalindromicAnagram(String s){
		ArrayList<Character> chars = new ArrayList<Character>();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i <s.length(); i++){
			char c = s.charAt(i);
			if(!chars.contains(c)){
				chars.add(c);
				ints.add(1);
			} else {
				ints.set(chars.indexOf(c), ints.get(chars.indexOf(c)) + 1);
			}
		}
		
		int length = s.length();
		boolean isEven = true;
		int numOdd = 0;
		for (int i = 0; i < ints.size(); i++){
			if(ints.get(i) %2 != 0){
				isEven = false;
				numOdd++;
				ints.set(i, ints.get(i) - 1);
				length--;
			}
		}
		if (isEven || numOdd == 1){
			x = 0;
		}
		else{
			x = numOdd - 1;
		}
		
		
		
		// calculate # of permutations
		int numPerm = factorial(length/2);
		for (int i = 0; i < ints.size(); i++){
			if (ints.get(i) > 2){
				numPerm = numPerm / (factorial(ints.get(i)/2));
			}
		}
		y = numPerm;
		
		
	}
	public int factorial(int x){
		if (x == 0){
			return 1;
		}
		return x * factorial(x-1);
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public static void main(String [] args){
		System.out.println("Please input the name of the input file");
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();
		File f = new File(filename);
		try {
			Scanner s = new Scanner(f);
			while(s.hasNextLine()){
				String word = s.nextLine();
				PalindromicAnagram pa = new PalindromicAnagram(word);
				System.out.println(pa.getX() + "," + pa.getY());
				
			}
			
		}catch (IOException ie){
			System.out.println("invalid filename");
			
		}
	}
}
