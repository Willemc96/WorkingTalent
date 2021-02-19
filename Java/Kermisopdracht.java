import java.util.Scanner;

public class Kermisopdracht {
	
	public static void main(String[] args) {
		System.out.println("Welkom op de kermis!");
		System.out.println("\nVul het corresponderende getal in om de gewenste attractie te starten");
		System.out.println("1 = botsauto");
		System.out.println("2 = spin");
		System.out.println("3 = spiegelpaleis");
		System.out.println("4 = spookhuis");
		System.out.println("5 = hawaii");
		System.out.println("6 = laderklimmen");
		System.out.println("\nVoer een 'k' in om het totaal aantal verkochte kermiskaartjes in te zien");
		System.out.println("Voer een 'o' in om de totale omzet van de kermis in te zien");
		System.out.println("Voer een 'b' in om de belastinginspecteur langs te laten komen\n");
		System.out.println("Voer 'end' in om de kermis te stoppen\n\n");
		
		Botsauto mijnBotsauto = new Botsauto();
		Spin mijnSpin = new Spin();
		Spiegelpaleis mijnSpiegelpaleis = new Spiegelpaleis();
		Spookhuis mijnSpookhuis = new Spookhuis();
		Hawaii mijnHawaii = new Hawaii();
		Ladderklimmen mijnLadderklimmen = new Ladderklimmen();
		Kassa mijnKassa = new Kassa();
		
		boolean toonScanner = true;
		while (toonScanner) {
			Scanner mijnScanner = new Scanner(System.in);
		    System.out.println("Voer in: ");
		    String invoer = mijnScanner.nextLine().toLowerCase();
	
			if(invoer.equals("1")){
				Attractie.draaien(mijnBotsauto);
				mijnKassa.berekenTotaleOmzet(mijnBotsauto.kosten);
			}else if(invoer.equals("2")){
				RisicoRijkeAttracties.rdraaien(mijnSpin);
				if(RisicoRijkeAttracties.goedGekeurd) {
					mijnKassa.berekenTotaleOmzet(mijnSpin.kosten);
					mijnSpin.kansSpelBelastingBetalen();
				}else {
					System.out.println("De draailimiet is overschreden. Roep een monteur aan middels 'm'");
					String monteurInvoer = "";
					while (!monteurInvoer.equals("m")) {
						Scanner monteurScanner = new Scanner(System.in);
						monteurInvoer = monteurScanner.nextLine().toLowerCase();
						if(monteurInvoer.equals("m")) {
							System.out.println("De monteur is langsgekomen. De attractie kan er weer tegenaan!");
							RisicoRijkeAttracties.rgoedkeuren(mijnSpin);
						}else {
							System.out.println("Foutieve invoer. Roep een monteur aan middels 'm'");
						}
					}
				}
			}else if(invoer.equals("3")){
				Attractie.draaien(mijnSpiegelpaleis);
				mijnKassa.berekenTotaleOmzet(mijnSpiegelpaleis.kosten);
			}else if(invoer.equals("4")){
				Attractie.draaien(mijnSpookhuis);
				mijnKassa.berekenTotaleOmzet(mijnSpookhuis.kosten);
			}else if(invoer.equals("5")){
				RisicoRijkeAttracties.rdraaien(mijnHawaii);
				if(RisicoRijkeAttracties.goedGekeurd) {
					mijnKassa.berekenTotaleOmzet(mijnHawaii.kosten);
				}else {
					System.out.println("De draailimiet is overschreden. Roep een monteur aan middels 'm'");
					String monteurInvoer = "";
					while (!monteurInvoer.equals("m")) {
						Scanner monteurScanner = new Scanner(System.in);
						monteurInvoer = monteurScanner.nextLine().toLowerCase();
						if(monteurInvoer.equals("m")) {
							System.out.println("De monteur is langsgekomen. De attractie kan er weer tegenaan!");
							RisicoRijkeAttracties.rgoedkeuren(mijnHawaii);
						}
						else {
							System.out.println("Foutieve invoer. Roep een monteur aan middels 'm'");
						}
					}
				}
			}else if(invoer.equals("6")){
				Attractie.draaien(mijnLadderklimmen);
				mijnKassa.berekenTotaleOmzet(mijnLadderklimmen.kosten);
				mijnLadderklimmen.kansSpelBelastingBetalen();
			}else if(invoer.equals("o")){
				mijnKassa.toonTotaleOmzet();
			}else if(invoer.equals("k")) {
				mijnKassa.toonTotaalAantalKaartjes();
			}else if(invoer.equals("b")) {
				BelastingInspecteur.langskomen();
			}else if(invoer.equals("end")) {
				System.out.println("De kermis wordt gestopt");
				toonScanner = false;
			}else {
				System.out.println("Deze invoer wordt niet erkend. Probeer het opnieuw");
			}
		}
	}
}

abstract class Attractie {
	String naam;
	double kosten;
	double omzet;
	int aantalKaartjes = 0;
	int aantalDraaien = 0;

	static void draaien(Attractie attractie) {
		System.out.println("De attractie " + attractie.naam + " draait!");
		attractie.omzet += attractie.kosten;
		attractie.aantalKaartjes += 1;
		attractie.aantalDraaien += 1;
	}
}

class Botsauto extends Attractie {
	Botsauto(){
		naam = "Botsauto";
		kosten = 2.50;
	}
}

class Spin extends RisicoRijkeAttracties implements GokAttractie{
	Spin(){
		naam = "Spin";
		kosten = 2.25;
		draaiLimiet = 5;
	}
	
	static double belasting;
	public double kansSpelBelastingBetalen() {
		belasting += kosten * 0.3;
		return belasting;
	}
}

class Spiegelpaleis extends Attractie{
	Spiegelpaleis(){
		naam = "Spiegelpaleis";
		kosten = 2.75;
	}
}

class Spookhuis extends Attractie{
	Spookhuis(){
		naam = "Spookhuis";
		kosten = 3.20;
	}
}

class Hawaii extends RisicoRijkeAttracties{
	Hawaii(){
		naam = "Hawaii";
		kosten = 2.90;
		draaiLimiet = 10;
	}
}

class Ladderklimmen extends Attractie implements GokAttractie{
	Ladderklimmen(){
		naam = "Ladderklimmen";
		kosten = 5.00;
	}
	
	static double belasting;
	public double kansSpelBelastingBetalen() {
		belasting += kosten * 0.3;
		return belasting;
	}
}

class Kassa {
	int totaalAantalkaartjes = 0;
	double totaleOmzet = 0;
	
	void berekenTotaleOmzet(double nieuweOmzet) {
		totaleOmzet += nieuweOmzet;
		totaleOmzet = Math.round(totaleOmzet * 100.0) / 100.0;
		totaalAantalkaartjes += 1;
	}
	
	void toonTotaleOmzet() {
		System.out.println("De totale omzet bedraagt: " + totaleOmzet + " euro");
		if(BelastingInspecteur.belastingOpgehaald>0) {
			System.out.println("Echter, hiervan heeft de belastinginspecteur " + BelastingInspecteur.belastingOpgehaald + " euro afgesnoept");
			System.out.println("Omzet na aftrek van belasting is zodoende: " + (totaleOmzet - BelastingInspecteur.belastingOpgehaald ) + " euro");
		}
	}
	void toonTotaalAantalKaartjes() {
		System.out.println("Het totaal aantal verkochte kaartjes is: " + totaalAantalkaartjes);
	}
}

abstract class RisicoRijkeAttracties extends Attractie{
	int draaiLimiet;
	static boolean goedGekeurd = true;
	
	static void rdraaien(RisicoRijkeAttracties rattractie) {
		if(rattractie.aantalKaartjes == 0) {
			System.out.println("De attractie " + rattractie.naam + " is goedekeurd");
			Attractie.draaien(rattractie);
		}else if (rattractie.aantalDraaien == rattractie.draaiLimiet && rattractie.aantalDraaien != 0) {
			goedGekeurd = false;
		}else {
			Attractie.draaien(rattractie);
		}
		}
	
	static void rgoedkeuren(RisicoRijkeAttracties rattractie) {
		rattractie.aantalDraaien = 0;
		goedGekeurd = true;
	}
	}

interface GokAttractie{
	double kansSpelBelastingBetalen();
}



class BelastingInspecteur{
	static double belastingOpgehaald;
	static void langskomen() {
		belastingOpgehaald = Math.round((Ladderklimmen.belasting + Spin.belasting) * 100.0) / 100.0;
		System.out.println("De belastinginspecteur is langsgekomen. Er is nu in totaal " + belastingOpgehaald + " euro uit de omzet gehaald");
}
}