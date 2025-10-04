package pollosenfadados;

import java.util.Scanner;

public class PollosEnfadados {

	private static final double g = 9.80665;
		
		public static void main(String[] args) {
			
			System.out.println("");
			System.out.println("Aquellos dias en los que la Luna se encuentra perpendicular a la Tierra, se libra la guerra eterna entre cerditos y...");
			System.out.println("");
			System.out.println("¡POLLOS ENFADADOS! (nadie sabe por qué están enfadados)");
			System.out.println("");
			System.out.println("REGLAS: ");
			System.out.println("-Intenta darle un pollazo al cerdo dándole valores numéricos al ángulo y a la velocidad de tiro (la interfaz gráfica me da pereza hacerla).");
			System.out.println("-El cerdito muere si alcanzas una distancia de +-3m a donde está, porque es MUY gordo. Su distancia máxima son 300m (sólo aparece delante).");
			System.out.println("-El pollo empieza desde altura = 0m. ");
			System.out.println("-Matar al cerdito es esencial. Haz lo que sea para conseguirlo, cueste lo que cueste, incluso si rompes el juego en el intento. ");
			System.out.println(" ");
		
			try (Scanner sc = new Scanner(System.in)) {
				
				boolean newGame= true;
				
				while (newGame) {	//el while genera el bucle. Mientras que sea verdad se repite el programa, con distanciaCerdito distinta.
					
				int distanciaCerdito = (int) ((Math.random() * (300-100)) + 100); 
				int distanciaRC = (int) ((Math.random() * (10000000-100)) + 100); 
				//esto se genera fuera del bucle volverAIntentar para que se mantenga constante en la misma partida, y puedas volver a intentar con la misma distancia
				
				boolean volverAIntentar = true; //condición para la que se repite el bucle. Cuando es =false, juego nuevo

				while (volverAIntentar) { //para mantener distanciaCerdito igual entre intentos, no victorias
					System.out.println( " ");
					System.out.println("El cerdito está a una distancia de " + distanciaCerdito + "m.");
				
				System.out.println("Ángulo: ");
				double angulo = sc.nextDouble();
				
				System.out.println("Velocidad: ");
				double velocidad = sc.nextDouble();
				
				//condiciones independientes de valores físicos
				if (angulo >= 270) {
					System.out.println( " ");
					System.out.println("Eres gilipollas? Te has estampado contra el suelo.");
					System.out.println("Vuelve a intentarlo.");
				}else if (angulo > 360 || angulo < -360){
					System.out.println( " ");
					System.out.println ("Técnicamente existen los valores angulares mayores a 360, pero como el pollo no es un spinner le hemos limitado el movimiento a máx una vuelta. No seas tonto.");
					System.out.println("Vuelve a intentarlo.");
				}else if (angulo < -270) {
					System.out.println( " ");
					System.out.println("El cerdito está delante, no detrás. Y no le eches la culpa a la falta de una interfaz gráfica.");
					System.out.println("Vuelve a intentarlo.");
				}else if (angulo > 180 || angulo < -90) {
					System.out.println( " ");
					System.out.println("Ya no sólo estás disparando para atrás, sino que también hacia el suelo. ¿Seguro que no te caíste de la cuna cuando eras bebé?");
					System.out.println("Vuelve a intentarlo.");
				}else if (angulo <= 0) {
					System.out.println( " ");
					System.out.println("¿Eres gilipollas? Te has estampado contra el suelo.");
					System.out.println("Vuelve a intentarlo.");
				}else if (angulo >90){
					System.out.println( " ");
					System.out.println("El cerdito está delante, no detrás. Y no le eches la culpa a la falta de una interfaz gráfica.");
					System.out.println("Vuelve a intentarlo.");
				}else if (angulo <= 1 && velocidad >= 999){
					System.out.println( " ");
					System.out.println("El pollazo que le has metido al cerdo ha roto la fábrica del espacio-tiempo. Nos has matado a todos.");
						
					volverAIntentar=false;
					newGame= false; 
				
				}else if (angulo == 90 && velocidad <9999) {
					System.out.println( " ");
					System.out.println("...sabes que un ángulo de 90 te lanza recto hacia arriba, ¿no? Usa el cerebro, que pareces tonto.");
					System.out.println("Vuelve a intentarlo.");
				}else if (angulo == 90 && velocidad >= 9999) {
					System.out.println( " ");
					System.out.println("Si tu objetivo era llegar a la Luna, lo has conseguido, y le has metido un pollazo al cerdito alienígena. ");
					System.out.println("Es inmortal, pero también pacífico, así que os vais de picnic juntos y empezáis a filosofar sobra la futilidad de nuestra existencia y sobre la belleza inherente en la mortalidad. ");
					System.out.println("También te ha contado que si matas al Rey Cerdito, los pollos te empezarán a alabar como el nuevo Dios. Ha escuchado que está a una distancia de " + distanciaRC +"m...");
					System.out.println("Eso te recuerda que deberías estar en la Tierra matando a cerdos a pollazos, asi que le das dos besitos al cerdito alienígena y vuelves a intentarlo.");
						
				}else {
				//calculos físicos
				double anguloRadianes = Math.toRadians(angulo);
				double senoA = Math.sin(anguloRadianes);
				double cosenoA = Math.cos(anguloRadianes);
				double vx = velocidad*cosenoA; //estas funciones tratan con radianes, no pueden ser ángulos. Hacer una conversion previa
				double vy = velocidad*senoA;
				double tiempo = Math.round(((2*vy)/g) * 100.0) / 100.0;
				int distancia = (int) ((2*vx*vy)/g);
				
				System.out.println( " ");
				System.out.println("Tarda "+ tiempo + " s en caer.");
				System.out.println("La distancia recorrida son "+ distancia + "m");	
				System.out.println( " ");
				
				double toleranciaRC = 10000;
				
				//condiciones dependientes de valores físicos
				if (Math.abs(distanciaRC-distancia)<= toleranciaRC){
					
					System.out.println("Has... ¡has matado al Rey Cerdito! ¡Ya no será necesario seguir matando cerditos a pollazos! Gracias, Dios. Te debemos la vida");
					
					volverAIntentar= false;
					newGame= false;	
					
				}else if (distancia >= (distanciaCerdito*2)) {
					
					System.out.println("¡Te has pasado por " + (distancia - distanciaCerdito) + "m, pedazo bestia! ¡Más del doble! Dale un poco más fuerte, a ver si llegas a Lepe. Vuelve a intentarlo.");
					
				}else {
				
				double tolerancia = 3; // Tolerancia de tres unidades para crear un rango dentro del que puede entrar el lanzamiento para que se de por válido
			
				if (Math.abs(distanciaCerdito - distancia) <= tolerancia){
					
					System.out.println("¡Le has metido un pollazo al cerdito! ¿Quieres volver a jugar? (si/1 ; no/0)");
					
					sc.nextLine(); // Consumir el carácter de nueva línea, para poder insertar luego el si/no
					
					String respuesta = sc.nextLine();
							
					if (respuesta.equals("si") || respuesta.equals("1")) { //El jugador quiere volver a jugar, asi que while sigue siendo true
				      
						System.out.println( " ");
						System.out.println("Empezando nueva partida:");
				      
				      volverAIntentar = false;
				      
				  } else if (respuesta.equals("no") || respuesta.equals("0")) {
					  
					  System.out.println( " ");
					  System.out.println("¡Gracias por jugar!");	
					  
					  volverAIntentar = false;
					  newGame = false; 
				            
				  } else {
					  boolean falseInput = true; //para que si/no se repita siempre que no des si/no.
					    while (falseInput) {
					    	
					    	System.out.println("...si/1 , no/0 ");	      
					    	String respuesta1 = sc.nextLine();
					    	
					    	if (respuesta1.equals("si") || respuesta1.equals("1")) {
					    		falseInput = false;
					    		System.out.println( " ");
					    		System.out.println("Empezando nueva partida:");
					    		volverAIntentar = false;
						      
					    	} else if (respuesta1.equals("no")|| respuesta1.equals("0")) {
					    		falseInput= false;
					    		System.out.println( " ");
					    		System.out.println("¡Gracias por jugar!");			  
					    		volverAIntentar = false;
					    		newGame = false; 
				        }}}
				  }else{
					  if (distanciaCerdito - distancia > tolerancia) {
						  System.out.println("Te has quedado corto por " + (Math.abs(distanciaCerdito - distancia) - Math.round(tolerancia)) +"m, y no has matado al cerdito... ");
					  	  
					 }else {
						 System.out.println("Te has pasado por " + (Math.abs(distanciaCerdito - distancia) - Math.round(tolerancia)) +"m, y no has matado al cerdito... ");
					 		}
					  
					  System.out.println("Vuelve a intentarlo.");
					
					  //todo esto de abajo es la funcion de volver a intentar si no ganas. meter si/no en cada fallo era muy coñazo
					  
					/*sc.nextLine(); // Consumir el carácter de nueva línea, para poder insertar luego el si/no
					
					String respuesta = sc.nextLine();
							
						if (respuesta.equals("si")) {
				            //El jugador quiere volver a intentarlo, asi que while sigue siendo true
						} else if (respuesta.equals("no")) {
							System.out.println( " ");
							System.out.println("Has perdido...");	
							volverAIntentar= false;
							newGame = false; 
				            // El jugador no quiere volver a intentar, salir del bucle (volverAIntentar=false)
						} else {	 
							boolean falseInput = true;
							while (falseInput) {
					    	
								System.out.println("...si / no");			    	
								String respuesta2 = sc.nextLine();
					    	
								if (respuesta2.equals("si")) {
									falseInput = false;
							      
								} else if (respuesta2.equals("no")) {
									System.out.println( " ");
									System.out.println("Has perdido...");	
									volverAIntentar = false;
									newGame = false; 	
								}}}    */
				    
				  				}
							}
						}	
					}
				}
			}
		
		System.out.println( " ");
		System.out.println("Fin del juego.");
		
	}
}
