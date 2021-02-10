public class Opdr5 {

	public static void main(String[] args) {
		Auto auto1 = new Auto();
		
		auto1.motor = true;
		auto1.deur = true;
		auto1.vooruit = true;
		auto1.uitlaat = false;
		
		Monteur monteur1 = new Monteur();
		monteur1.monteren(auto1);
	}
}

class Monteur{
	int count = 0;
	void monteren(Auto a) {
		if(a.motor == true){
			System.out.println("De motor is kapot, dit kost 25 euro");
			count += 25;
		}
		if(a.deur == true){
			System.out.println("De deur is kapot, dit kost 25 euro");
			count += 25;
		}
		if(a.vooruit == true){
			System.out.println("De vooruit is kapot, dit kost 25 euro");
			count += 25;
		}
		if(a.uitlaat == true){
			System.out.println("De uitlaat is kapot, dit kost 25 euro");
			count += 25;
		}
		System.out.println("\nDe totale kosten voor het monteren bedragen " + count + " euro");
	}
}


class Auto{
	boolean motor;
	boolean deur;
	boolean vooruit;
	boolean uitlaat;
}