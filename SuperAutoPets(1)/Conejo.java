package proyecto1;

public class Conejo extends Mascota {
    private String type = "mamifero";
    protected String nombre="Conejo";

    public String getNombre() {
        return nombre;
    }

    public Conejo(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Conejo conejo = new Conejo(3, 2, 3);
        misMascotas[this.posicion] = conejo;
    }

    //definiendo habilidadAnimal
    public void habilidad(Mascota[] misMascotas, int posicion) {
        giveAbility(misMascotas, posicion);
    }

    //definiendo lo que hara
    public int extraLife() {
        if (nivel == 1) {
            return 1;
        } else if (nivel == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    //dando la habilidadAnimal
    public void giveAbility(Mascota[] misMascotas, int posicion) {
        misMascotas[posicion].earnLife(extraLife());
    }

    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Conejo.super.subirXp(fusion);

    }
}
