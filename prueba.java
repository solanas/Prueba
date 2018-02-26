import java.util.Scanner;

/*
 * Aviso importante
 * he arreglado lo de alinearlos uno encima de otro
 * falta comprobar si estan en linea y tal
 * yo recomiendo hacer metodos que lo comprueben
 * por ejemplo metodo horizontal
 * metodo vertical y asi....
 * 
 * 
 */




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
    	boolean ganar=false;
    	
    	
    	
    	do {
    		if(movedor) {
    			ficha = f1;
    			movedor=!movedor;
    		}else {
    			ficha = f2;
    			movedor=!movedor;
    		}
    		do {
    			System.out.println("Escribe numero de columna a colocar ficha");
        		opc = teclado.nextInt();
    		}while(opc>=6);
    		matriz=meterCosa(opc, matriz, ficha);
    		mostrarMatriz(matriz);
    		ganar=hasGanado(matriz,ficha);
    	}while(opc<=6&&!ganar);
    	System.out.println("Ha ganado el jugador con la ficha "+ficha);
    	
    	
    	
    	
    	
	}

	public static void menu() {
		System.out.println("---Bienvenido al 4 en raya---");
		//falta po rimplementar modelos de varios jugadores o algo asi
		
	}
	
	public static  String[][] meterCosa(int fila, String matriz[][],String ficha){
		boolean debug=false;
		boolean asignado=false;
		int opc;
		Scanner teclado = new Scanner(System.in);
		int i =0;
		do {
			if(i<6) {
				if(matriz[6-i][fila].equals("")&&i<6) {
					matriz[6-i][fila]=ficha;
					asignado =true;
					if(debug) {
						System.out.println("Debug : ");
						System.out.println("Entra en if : ");
						System.out.println("La i es :  "+i);
						teclado.nextLine();
					}
				}else {
					i++;
					if(debug) {
						System.out.println("Debug : ");
						System.out.println("NOO Entra en if : ");
						System.out.println("La i es :  "+i);
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
			}else {
				System.out.println("NOOOOOO se ha asignado la ficha ");
				System.out.println("Escribe numero de columna a colocar ficha");
	    		opc = teclado.nextInt();
	    		fila=opc;
	    		i=0;
			}
			
			
		}while(i<7&&!asignado);
		if(asignado) {
			System.out.println("La se ha asignado la ficha ");
		}else {
			System.out.println("NOOOOOO se ha asignado la ficha ");
		}
		
		return (matriz );
	}
	
	public static void mostrarMatriz(String matriz[][]) {
		//bucle para enseñar matriz
    	System.out.println("-----------------------------------------------------");
    	for(int i = 0;i<7;i++) {
    		for(int p =0;p<6;p++) {
    			System.out.print(matriz [i] [p]);
    			System.out.print("\t ||");
    		}
    		System.out.println();
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
	
	public static boolean hasGanado(String matriz[][],String ficha) {
		boolean hasGanado=false;
		boolean compHorizontal=false;
		int fichLinea=0;
		int s=1;
		boolean sigue=true;
		boolean debug=false;
		boolean debug1=true;
		
		for(int i = 0;i<matriz.length;i++) {
			for(int p = 0;p<matriz[i].length;p++) {
				if(matriz[i][p].equals(ficha)) {
					//primero comprobamos linea horizontal
					fichLinea=0;
					s=0;
					do {
						s++;
						if(!(p-s<0)) {
							if(matriz[i][p-s].equals(ficha)) {
								fichLinea++;
								sigue=true;
								if(debug) {
									System.out.println("Suma a fichLinea de la izq");
								}
							}else {
								sigue=false;
							}
						}
						if(debug) {
							System.out.println("No sale del primer bucle");
						}
					}while(p-s>0&&sigue&&s<4);
					if(debug) {
						System.out.println("Ha salido del primer bucle");
					}
					
					s=0;
					do {
						s++;
						if(!(p+s>5)) {
							if(matriz[i][p+s].equals(ficha)) {
								fichLinea++;
								sigue=true;
								if(debug) {
									System.out.println("Suma a fichLinea de la drch");
								}
							}else {
								sigue=false;
							}
							if(debug) {
								System.out.println("No sale del segundo bucle");
							}
						}
						
					}while(p+s>5&&sigue&&s<4);
					if(debug) {
						System.out.println("Ha salido del segundo bucle");
					}
					if(debug) {
						System.out.println("Ha comprobado la ficha : "+matriz[i][p]);
						System.out.println("En la posicion i  : "+i);
						System.out.println("En la posicion p  : "+p);
						System.out.println("Ha contado   : "+fichLinea+" fichas");
					}
					if(fichLinea>=3) {
						hasGanado=true;
					}
					
					
					
					//aqui debo seguir comprobando para vertical 
					
					fichLinea=0;
					s=0;
					do {
						s++;
						if(i-s>0) {
							if(matriz[i-s][p].equals(ficha)) {
								fichLinea++;
								sigue=true;
								if(debug) {
									System.out.println("Suma a fichLinea hacia abajo");
								}
							}else {
								sigue=false;
							}
							if(debug) {
								System.out.println("No sale del tercer bucle");
							}
						}	
					}while(i-s>0&&sigue&&s<4);
					if(debug) {
						System.out.println("Ha salido del tercer bucle");
					}
					s=0;
					do {
						s++;
						if(!(i+s>6)) {
							if(matriz[i+s][p].equals(ficha)) {
								fichLinea++;
								sigue=true;
								if(debug) {
									System.out.println("Suma a fichLinea hacia arriba");
								}
							}else {
								sigue=false;
							}
							if(debug) {
								System.out.println("No sale del cuarto bucle");
							}
						}
						
					}while(i+s>5&&sigue&&s<4);
					if(debug) {
						System.out.println("Ha salido del cuarto bucle");
					}
					if(debug) {
						System.out.println("Ha comprobado la ficha : "+matriz[i][p]);
						System.out.println("En la posicion i  : "+i);
						System.out.println("En la posicion p  : "+p);
						System.out.println("Ha contado   : "+fichLinea+" fichas");
					}
					if(fichLinea>=3) {
						hasGanado=true;
					}
					
					
					//aqui compruebo diagonales ,la de abajo a la drch
					
					fichLinea=0;
					s=0;
					do {
						s++;
						if(i+s<6&&p+s<6) {
							if(matriz[i+s][p+s].equals(ficha)) {
								fichLinea++;
								sigue=true;
								if(debug1) {
									System.out.println("Suma a fichLinea en quinto bucle");
								}
							}else {
								sigue=false;
								if(debug1) {
									System.out.println("Ha salido del quinto bucle");
								}
							}
							
						}	
					}while(i+s<=5&&sigue&&s<4&&p+s<=5);
					
					if(debug1) {
						System.out.println("Ha comprobado la ficha : "+matriz[i][p]);
						System.out.println("En la posicion i  : "+i);
						System.out.println("En la posicion p  : "+p);
						System.out.println("Ha contado   :\t\t "+fichLinea+" fichas");
					}
					
					//aqui compruebo la diagonal de arriba a la izq
					
					
					
					s=0;
					do {
						s++;
						if(i-s>=0&&p-s>=0) {
							if(matriz[i-s][p-s].equals(ficha)) {
								fichLinea++;
								sigue=true;
								if(debug1) {
									System.out.println("Suma a fichLinea en sexto bucle");
								}
							}else {
								sigue=false;
								if(debug1) {
									System.out.println("Ha salido del sexto bucle");
								}
							}
							
						}	
					}while(i-s>0&&sigue&&s<4&&p-s>0);
					
					if(debug1) {
						System.out.println("Ha comprobado la ficha : "+matriz[i][p]);
						System.out.println("En la posicion i  : "+i);
						System.out.println("En la posicion p  : "+p);
						System.out.println("Ha contado   :\t\t "+fichLinea+" fichas");
					}
					
					if(fichLinea>=3) {
						hasGanado=true;
					}
					
					
					
					
					
					
					
					
					
					
				}
			}
		}
		
		if(fichLinea>=3) {
			hasGanado=true;
		}
		
		
		return hasGanado;
	}
	
	
}
