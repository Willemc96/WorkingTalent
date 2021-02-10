public class Opdr4 {    
	
    public static void main(String[] args) {             
        int [] getallen = {7, 15, 8, 12, 5, 9};     
        int max = 0;    
        
       System.out.println("Oorspronkelijke lijst getallen: ");    
       for (int i = 0; i <getallen.length; i++) {     
           System.out.print(getallen[i] + " ");    
        }    
   
        for (int i=0; i<getallen.length-1; i++) {     
          for (int j=i+1; j<getallen.length; j++) {     
              if(getallen[i]<getallen[j]) {      
                 max = getallen[j];    
                 getallen[j] = getallen[i];    
                 getallen[i] = max;    
               }     
            }     
        }    
        System.out.println("\n\nGesorteerde lijst getallen: ");    
        for (int i = 0; i <getallen.length; i++) {     
            System.out.print(getallen[i] + " ");    
        }    
    }    
}