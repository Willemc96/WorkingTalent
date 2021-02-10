import java.util.Scanner;

public class Opdr6 {
	
   public static void main(String args[]) {
	   
      Scanner sc = new Scanner(System.in);
      System.out.println("Voer een string in: ");
      String str = sc.nextLine();
      sc.close();
      
      System.out.println("De ingevoerde string is " + str + "\n");
      
      char characterlist[] = str.toCharArray();
      int max;

      for(int i=0; i<characterlist.length-1; i++ ) {
         for(int j=i+1; j<characterlist.length; j++) {
            if(characterlist[i]>characterlist[j]) {
               max = characterlist[i];
               characterlist[i] = characterlist[j];
               characterlist[j] = (char) max;
            }
         }
      }
      System.out.print("Alfabetisch geordend is deze string gelijk aan: ");
      System.out.print(characterlist);
   }
}