import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Opdr10 {

	public static void main(String[] args) {
		System.out.println("Ik ga op vakantie en neem mee...\n");
		List<String> woorden = new ArrayList<>();
		
		for(int i=0; i<100; i++) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Voer item in: ");
		String item = sc.nextLine();
		woorden.add(item);
		
		if(woorden.size()<=1) {
			System.out.println(woorden.get(0));
		}
		else {
			if(woorden.get(woorden.size()-2).charAt(woorden.get(woorden.size()-2).length()-1) == woorden.get(woorden.size()-1).charAt(0)) {
				System.out.println(String.join(", ", woorden));
			}
			else {
				System.out.println("Deze invoer wordt niet geaccepteerd, voer een ander item in");
				woorden.remove(woorden.size()-1);
			}
		}
	}
}
}