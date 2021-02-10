import java.util.Scanner;

public class Opdr7 {

	public static void main(String[] args) {
		String woord1 = new String("fiets");
		
		System.out.println("_ ".repeat(woord1.length()));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Raad het woord: ");
		String woord2 = sc.nextLine();
		sc.close();
		
		for(int i=0; i<woord1.length(); i++) {
			if(woord1.charAt(i) == woord2.charAt(i)) {
				System.out.print(2);
			}
			else if(woord1.contains(String.valueOf(woord2.charAt(i)))){
				System.out.print(1);
			}
			else {
				System.out.print(0);
			}
		}
	}
}