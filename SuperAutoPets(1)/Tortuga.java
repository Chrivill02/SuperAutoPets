
package proyecto1;

public class Tortuga extends Mascota {
    private String type = "Reptil";
    protected String nombre="Tortuga";

    public String getNombre() {
        return nombre;
    }

    public Tortuga(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Tortuga tortuga = new Tortuga(1, 2, 3);
        misMascotas[this.posicion] = tortuga;
    }

    //definir habilidadAnimal
    public void habilidad(Mascota[] misMascotas) {
        giveAbility(misMascotas);

    }

    public void giveAbility(Mascota[] misMascotas) {
        if (this.nivel == 1) {
            if (this.posicion < 4) {
                misMascotas[this.posicion + 1].efectoActivo("Melon");
            }
        } else if (this.nivel == 2) {
            if (this.posicion < 3) {
                misMascotas[this.posicion + 2].efectoActivo("Melon");
                misMascotas[this.posicion + 1].efectoActivo("Melon");
            } else if (this.posicion < 4) {
                misMascotas[this.posicion + 1].efectoActivo("Melon");
            }
        } else if (this.nivel == 3) {
            if (this.posicion < 2) {
                misMascotas[this.posicion + 3].efectoActivo("Melon");
                misMascotas[this.posicion + 2].efectoActivo("Melon");
                misMascotas[this.posicion + 1].efectoActivo("Melon");
            } else if (this.posicion < 3) {
                misMascotas[this.posicion + 2].efectoActivo("Melon");
                misMascotas[this.posicion + 1].efectoActivo("Melon");
            } else if (this.posicion < 4) {
                misMascotas[this.posicion + 1].efectoActivo("Melon");

            }
        }
    }


    public void damageCaused(int damageCaused, Mascota[] misMascotas) {
        vidaEnPelea -= damageCaused;
        if(vidaEnPelea<=0){
            habilidad(misMascotas);
        }
    }

    //fusionar animal
    public void fusionar(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Tortuga.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Tortuga.super.subirXp(fusion);
        }

    }
}
