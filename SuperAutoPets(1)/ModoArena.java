package proyecto1;

public class ModoArena {
    //Atributos que tiene el modo que define si termina o sigue
    protected int victorias = 0;
    protected int vidas = 10;
    //Método para ejecutar el modo Arena

    public void jugarModoArena() {
        boolean animalGana = true;
        int rondas = 1;
        // instanciamos todos los objetos que necesitaremos

        Bot bot = new Bot();
        Mascota[] mascotasAmigas = new Mascota[5];
        Mascota[] mascotasEnemigas = new Mascota[5];
        Tienda tienda = new Tienda();
        Batalla batallas = new Batalla();
        Mascota[] mascotasClonadas = new Mascota[5];
        //ciclo do while para el juego, (tienda y batalla)
     while (victorias < 10 && vidas > 0){
            bot.crearAnimales(rondas, mascotasEnemigas);
            tienda.menuTienda(mascotasAmigas,rondas,animalGana,this.vidas, this.victorias);
            clonarMascotas(mascotasClonadas,mascotasAmigas);
            batallas.pelea(mascotasClonadas,mascotasEnemigas,rondas);
            if(mascotasClonadas[0]==null) {
                restarVidas(batallas.restarVida(mascotasClonadas, rondas,animalGana,mascotasEnemigas));
            }else {
                sumarVictorias(batallas.sumarVictoria(mascotasEnemigas, animalGana, mascotasClonadas));
            }
            rondas= rondas + 1;

        }
     if (victorias >= 10){
         System.out.println("Ganaste el modo arena!");
     }else if (vidas <= 0){
         System.out.println("Te haz quedado sin vidas, haz perdido en el modo arena");
     }

    }


    //Método para clonar mascotas y poder tener las mismas pero con diferentes atributos en la batalla y no cambiar a los pricipales

    public void clonarMascotas(Mascota[] misMascotasCopia, Mascota[] misMascotas) {
        for (int i = 0; i <= 4; i++) {
            if(misMascotas[i]!=null) {
                misMascotasCopia[i] = misMascotas[i].clone();
            }
        }
    }
    //Método para restar las vidas de el jugador

    public void restarVidas(int vidas){
        this.vidas-=vidas;
    }

    //Método para sumar las victorias de el jugador
    public void sumarVictorias(int victorias){
        this.victorias+=victorias;
    }


}
