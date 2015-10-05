
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HappyNumbers {
	ArrayList<Integer> input;
	ArrayList<Boolean> happies;
	ArrayList<Integer> lengths;
	
	
	public HappyNumbers(ArrayList<Integer> i){
		
		input = i;

		happies = new ArrayList<Boolean>();
		lengths = new ArrayList<Integer>();	
	}
	
	private void solveHelper(int n){
		if (n == 1){
			happies.add(true);
			lengths.add(0);
			return;
		}
		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(n);

		int num = n;
		int length = 0;
		while (true){

			length++;
			int new_num = 0;
			while (num != 0){
				new_num += (num%10) * (num%10);
				num = num/10;
			}
			num = new_num;
			if (v.contains(num)){
				happies.add(false);
				lengths.add(length);
				break;
			} else if (num == 1){
				happies.add(true);
				lengths.add(length);
				break;		
			} else {

				v.add(num);
			}
		}

	}
	private void solve(){

		for (int i = 0; i < input.size(); i++){
			solveHelper(input.get(i));
		}
	}
	private void print(){
		for (int i = 0; i < input.size(); i++){
			if (happies.get(i)){
				System.out.print("happy ");
			} else {
				System.out.print("unhappy ");
			}
			System.out.println(lengths.get(i));
		
		}
		System.out.println();
	}
	public static void main(String [] args){
		System.out.println("Please input the name of the input file");
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();
		File f = new File(filename);
		try {
			Scanner s = new Scanner(f);
			ArrayList<Integer> i = new ArrayList<Integer>();
			while (s.hasNextInt()){
				i.add(s.nextInt());
			}
			
			HappyNumbers hn = new HappyNumbers(i);
			hn.solve();
			hn.print();
			
		}catch (IOException ie){
			System.out.println("invalid filename");
			
		}
	}
}
