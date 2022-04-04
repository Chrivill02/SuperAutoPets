package proyecto1;

public class Buey extends Mascota {

    private String type = "mamifero";

    protected String nombre="Buey";

    public String getNombre() {
        return nombre;
    }

    public Buey(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Buey buey = new Buey(3, 2, 3);
        misMascotas[this.posicion] = buey;
    }

    //deifiniendo Habilidad
    public void habilidad(Mascota[] misMascotas) {
        extraDamage(misMascotas);
    }

    //definiendo lo que hara su habilidadAnimal
    public void giveAbility(Mascota[] misMascotas, int extraDamage) {
        if (this.posicion < 0) {
            if (misMascotas[this.posicion - 1].getDerrotado()) {
                misMascotas[this.posicion].efectoActivo("Melon");

            }
        }
    }

    //definiendo los niveles de la habilidadAnimal
    public void extraDamage(Mascota[] misMascotas) {
        if (nivel == 1) {
            int extraDamage = 2;
            giveAbility(misMascotas, extraDamage);
        } else if (nivel == 2) {
            int extraDamage = 4;
            giveAbility(misMascotas, extraDamage);
        } else if (nivel == 3) {
            int extraDamage = 6;
            giveAbility(misMascotas, extraDamage);
        }
    }


    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Buey.super.subirXp(fusion);

    }

}
