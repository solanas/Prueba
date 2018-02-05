import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public static void main(String[] args) throws IOException {
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("Escribe ruta/nombre del archivo");
    	
        String ruta = teclado.nextLine();
        teclado.nextLine();
        File archivo = new File(ruta);
        
        //primero compruebo que exista el archivo
        //y sino lo creo
        
        if(archivo.exists()) {
            System.out.println("El archivo ya estaba creado");
        } else {
            
            System.out.println("Acaba de ser creado el archivo");
        }
        
        //aqui ejecuta el menu para leer o escribir
        
        System.out.println("Selecciona 1 para leer del fichero :");
        System.out.println("Selecciona 2 para escribir del fichero :");
        int opcion=0;
        opcion = teclado.nextInt();
        if(opcion==1) {
        	leerText(ruta);
        }else {
        	escribirText(ruta);
        }
        
        
    }
    //aqui estan las funciones de ller y escribir
    public static void leerText(String ruta) throws IOException {
    	String sCadena="";
    	FileReader f = new FileReader(ruta);
    	BufferedReader bf = new BufferedReader(f);
        while ((sCadena = bf.readLine())!=null) {
            System.out.println(sCadena);
         }
        bf.close();
    }
    public static void escribirText(String ruta) throws IOException {
    	Scanner teclado = new Scanner(System.in);
    	File archivo = new File(ruta);
    	BufferedWriter bw = null;
    	bw = new BufferedWriter(new FileWriter(archivo));
    	String frase="52";
    	teclado.nextLine();
    	do {
    		frase="";
    		System.out.println("Escribe la frase");
    		frase=teclado.nextLine();
    		bw.write(frase);
    		bw.write("\n");
    	}while(frase.length()>0);
    	bw.close();
    }
}
