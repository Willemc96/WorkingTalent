public class Opdr9 {
	
	public static void main(String[] args) {
		Vliegtuig mijnVliegtuig = new Vliegtuig(); 
		mijnVliegtuig.landen();
		
		Spreeuw mijnSpreeuw = new Spreeuw();
		mijnSpreeuw.opstijgen();
		  }
	
	}
	
	interface Vliegend {
		void opstijgen(); 
		void landen(); 
	}
	
	class Vliegtuig implements Vliegend {
		public void opstijgen() {
	    System.out.println("Het vliegtuig is opgestegen");
	  }
		public void landen() {
	    System.out.println("Het vliegtuig is geland");
	  }
	}
	
	class Spreeuw implements Vliegend{
		public void opstijgen() {
		    System.out.println("De spreeuw is weggevlogen");
		  }
		public void landen() {
		    System.out.println("De spreeuw is weer terug");
		  }
	}
	
	class Leeuw{
		
	}