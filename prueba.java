import java.util.Scanner;

public class CuatroEnRaya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
    	String matriz [] []= new String [7] [6];
    	
    	String f1 = "A";
    	String f2 = "O";
    	int opc=0;
    	boolean movedor = true;
    	String ficha="";
    	menu();
    	iniarMatriz(matriz);
    	
    	
    	
    	do {
    		if(movedor) {
    			ficha = f1;
    			movedor=!movedor;
    		}else {
    			ficha = f2;
    			movedor=!movedor;
    		}
    		System.out.println("Escribe numero de columna a colocar ficha");
    		opc = teclado.nextInt();
    		matriz=meterCosa(opc, matriz, ficha);
    		mostrarMatriz(matriz);

    	}while(opc<=6);
    	
    	
    	
    	
    	
	}

	public static void menu() {
		System.out.println("---Bienvenido al 4 en raya---");
		//falta po rimplementar modelos de varios jugadores o algo asi
		
	}
	
	public static  String[][] meterCosa(int fila, String matriz[][],String ficha){
		boolean debug=true;
		Scanner teclado = new Scanner(System.in);
		int i =0;
		do {
			if(matriz[6-i][fila].equals("")&&i<5) {
				matriz[6-i][fila]=ficha;
				if(debug) {
					System.out.println("Debug : ");
					System.out.println("Entra en if : ");
					teclado.nextLine();
				}
			}else {
				i++;
				if(debug) {
					System.out.println("Debug : ");
					System.out.println("NOO Entra en if : ");
					teclado.nextLine();
				}
				
			}
			
			if(debug) {
				System.out.println("Debug : ");
				System.out.println("La i es :  "+i);
				System.out.println("La ficha es : "+ficha);
				System.out.println("La posicion en la matriz es : "+matriz[6-i][fila]);
				teclado.nextLine();
			}
			
		}while(i<5&&(matriz[6-i][fila].equals("")));
		return (matriz );
	}
	
	public static void mostrarMatriz(String matriz[][]) {
		//bucle para enseñar matriz
    	System.out.println("-----------------------------------------------------");
    	for(int i = 0;i<7;i++) {
    		System.out.println();
    		for(int p =0;p<6;p++) {
    			System.out.print(matriz [i] [p]);
    			System.out.print("\t ||");
    		}
    	}
    	System.out.println();
    	System.out.println("-----------------------------------------------------");
	}
	
	public static void iniarMatriz(String matriz[][]) {
		String vacio = "";
	   	//rellenamos la matriz vacia
    	for(int i = 0;i<7;i++) {
    		for(int p =0;p<6;p++) {
    			matriz [i] [p] = vacio;
    		}
    	}
	}
	
	
}
