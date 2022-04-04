
package proyecto1;

/**
 * @author macbookpro
 */
public class Camion extends Mascota {
    public Camion(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Camion camion = new Camion(5, 5, 4);
        misMascotas[this.posicion] = camion;
    }

    public void atacar(Mascota[] mascotasEnemigas) {
        if (mascotasEnemigas[0].getEfecto().equals("Cebolla")) {
            this.ataque = this.ataque - 2;
            mascotasEnemigas[0].damageCaused(this.ataque);
            mascotasEnemigas[1].damageCaused(this.ataque);
            vecesAtacar += 1;
        } else if (mascotasEnemigas[0].getEfecto().equals("Melon")) {
            this.ataque = 0;
            mascotasEnemigas[0].damageCaused(this.ataque);
            mascotasEnemigas[1].damageCaused(this.ataque);
            vecesAtacar += 1;
            mascotasEnemigas[0].setEfecto("Ninguno");
        } else if (mascotasEnemigas[0].getEfecto().equals("Ninguno")) {
            mascotasEnemigas[0].damageCaused(this.ataque);
            mascotasEnemigas[1].damageCaused(this.ataque);
            vecesAtacar += 1;
        }

    }

}
