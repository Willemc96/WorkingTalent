public class Opdr3 {

	public static void main(String[] args) {
		int[] getallen = {1, 2, 3, 4,};
		int som = 0;
		
		System.out.print("De som van de lijst getallen ");
		for(int i=0; i<getallen.length; i++) {
			System.out.print(getallen[i] + " ");
			som += getallen[i];
		}
		System.out.println("is " + som);
	}
}