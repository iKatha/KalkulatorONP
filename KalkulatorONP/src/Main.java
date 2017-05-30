

public class Main {

	public static void main(String[] args) {
		SterownikONP onp = new SterownikONP();
		String wyrazenie="";
		double wynik=0;
		for(int i=0;i<args.length;i++) {
			System.out.println("///////////////////////W Y R A ¯ E N I E  "+(i+1)+"////////////////////////");
			System.out.println("wyra¿enie: " + args[i]);
			try {
				wyrazenie=onp.zamienNaONP(args[i]);
				System.out.println("wyra¿enie onp: " + wyrazenie);
				wynik=onp.obliczONP(wyrazenie);
				System.out.println("wynik: "+ wynik);
				System.out.println("///////////////////////////////////////////////////////////////////");
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ERROR: "+e.getMessage());
				System.out.println("///////////////////////////////////////////////////////////////////");
				System.out.println();
			}
			
		}
		
	}

}
