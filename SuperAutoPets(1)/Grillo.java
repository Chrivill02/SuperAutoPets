package proyecto1;

public class Grillo extends Mascota {

    private String type = "Insecto";
    protected String nombre="Grillo";

    public String getNombre() {
        return nombre;
    }

    public Grillo(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Grillo grillo = new Grillo(1, 2, 1);
        misMascotas[this.posicion] = grillo;

    }


    //definiendo que hara su habilidadAnimal
    public void habilidad(Mascota misMascotas[]) {

        if (nivel == 1) {
            misMascotas[0] = new GrilloZombie(1, 1, 1);
        } else if (nivel == 2) {
            misMascotas[0] = new GrilloZombie(2, 2, 1);
        } else if (nivel == 3) {
            misMascotas[0] = new GrilloZombie(3, 3, 1);
        }

    }

    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Grillo.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Grillo.super.subirXp(fusion);
        }

    }

    public void receiveDamage(int damageCaused, Mascota misMascotas[]) {
        vida -= damageCaused;
        if (vida <= 0) {
            habilidad(misMascotas);
        }
    }

}