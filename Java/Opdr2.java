public class Opdr2{
	
	public static void main(String[] args) {
		String woord = new String("regenen");
		int count = 0;
		
		for(int i=0; i<woord.length(); i++) {
			String letter = String.valueOf(woord.charAt(i));
			if(letter.equals("e")) {
				count += 1;
			}		
		}
		System.out.println("In " + woord + " zit " + count + " keer een 'e'");
	}	
}