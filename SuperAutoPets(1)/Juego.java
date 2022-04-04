package proyecto1;

import java.util.Scanner;

public class Juego {
    Scanner scanner = new Scanner(System.in);
    //Creamos una variable opcion para almacenar las respuestas del usuario

    protected int opcion = 0;

    //Método para iniciar el jugarModoArena desplegando un menú

    public void iniciarJuego() {
        while (opcion != 4) {
            System.out.println("Super Auto Pets");
            System.out.println("Bienvenido al mejor juego de estrategia con mascotas!");
            System.out.println("Elige el modo de juego o si quieres salir presiona 4");
            System.out.println("1) Modo Arena");
            System.out.println("2) Modo verus");
            System.out.println("3) Modo Creativo");
            System.out.println("4) Salir");
            opcion=scanner.nextInt();
            if(opcion==1){
                ModoArena arena = new ModoArena();
                arena.jugarModoArena();
            }else if(opcion==2){
                System.out.println("Modo no disponible");
            }else if(opcion==3){
                System.out.println("Modo no disponible");
            }else if(opcion==4){
                System.out.println("Gracias por jugar Super Auto Pets! vuelve pronto");
                break;

            }
        }

    }
}


