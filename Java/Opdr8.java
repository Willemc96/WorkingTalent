public class Opdr8 {

	public static void main(String[] args) {
		Boot boot1 = new Boot();
		Boot boot2 = new SpeedBoot();
		
		Kapitein kapitein1 = new Kapitein();
		kapitein1.varen(boot2);
	}
}

	class Boot{
		void starten() {
		}
	}
	
	class SpeedBoot extends Boot {
	}
	
	class Kapitein{
		void varen(Boot b) {
			if(b.toString().contains("SpeedBoot")){
				System.out.println("Ik zet even mijn pet af");
			}
		}
	}