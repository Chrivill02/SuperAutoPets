
package proyecto1;

public class Hipopotamo extends Mascota {


    private String[] type = new String[2];
    protected String nombre="Hipopotamo";

    public String getNombre() {
        return nombre;
    }
    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Acuatico";
        this.type[1] = "Terrestre";
    }

    public Hipopotamo(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Hipopotamo hipopotamo = new Hipopotamo(4, 7, 4);
        misMascotas[this.posicion] = hipopotamo;
    }

    public void habilidad(Mascota[] misMascotas) {
        giveAbility(misMascotas);

    }

    public void giveAbility(Mascota[] misMascotas) {
        if (nivel == 1) {
            int extraDamage = 2;
            int extraLife = 2;
            misMascotas[this.posicion].earnDamageInBatle(extraDamage);
            misMascotas[this.posicion].earnLifeInBatle(extraLife);
        } else if (nivel == 2) {
            int extraDamage = 4;
            int extraLife = 4;
            misMascotas[this.posicion].earnDamageInBatle(extraDamage);
            misMascotas[this.posicion].earnLifeInBatle(extraLife);
        } else if (nivel == 3) {
            int extraDamage = 6;
            int extraLife = 6;
            misMascotas[this.posicion].earnDamageInBatle(extraDamage);
            misMascotas[this.posicion].earnLifeInBatle(extraLife);
        }
    }

    public void atacar(Mascota[] mascotasEnemigas, Mascota[] misMascotas) {
        if (mascotasEnemigas[0].getEfecto().equals("Cebolla")) {
            this.ataque = this.ataque - 2;
            mascotasEnemigas[0].damageCaused(this.ataque);
            vecesAtacar += 1;
        } else if (mascotasEnemigas[0].getEfecto().equals("Melon")) {
            this.ataque = 0;
            mascotasEnemigas[0].damageCaused(this.ataque);
            vecesAtacar += 1;
            mascotasEnemigas[0].setEfecto("Ninguno");
        } else if (mascotasEnemigas[0].getEfecto().equals("Ninguno")) {
            mascotasEnemigas[0].damageCaused(this.ataque);
            vecesAtacar += 1;
        }
        habilidad(misMascotas);

    }

    //fusionar animal
    public void fusionar(Mascota[] misMascotas, int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Hipopotamo.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Hipopotamo.super.subirXp(fusion);
        }
    }
}
