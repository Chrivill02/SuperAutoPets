
package proyecto1;

public class Canguro extends Mascota {
    private String[] type = new String[2];
    protected String nombre="Canguro";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Doméstico";
        this.type[1] = "Terrestre";
    }

    public Canguro(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;

    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Canguro canguro = new Canguro(1, 2, 3);
        misMascotas[this.posicion] = canguro;
    }

    //definir habilidadAnimal
    public void habilidadAnimal(Mascota[] misMascotas) {
        darHabilidad(misMascotas);

    }

    public void darHabilidad(Mascota[] misMascotas) {
        if (nivel == 1) {
            if (this.posicion - 1 >= 0) {
                int extraDamage = 2 * (misMascotas[this.posicion - 1].getVecesAtacar());
                int extraLife = 2 * (misMascotas[this.posicion - 1].getVecesAtacar());
                misMascotas[this.posicion].earnDamageInBatle(extraDamage);
                misMascotas[this.posicion].earnLifeInBatle(extraLife);
            }
        } else if (nivel == 2) {
            if (this.posicion - 1 >= 0) {
                int extraDamage = 4 * (misMascotas[this.posicion - 1].getVecesAtacar());
                int extraLife = 4 * (misMascotas[this.posicion - 1].getVecesAtacar());
                misMascotas[this.posicion].earnDamage(extraDamage);
                misMascotas[this.posicion].earnLife(extraLife);
            }
        } else if (nivel == 3) {
                int extraDamage = 6 * (misMascotas[this.posicion - 1].getVecesAtacar());
                int extraLife = 6 * (misMascotas[this.posicion - 1].getVecesAtacar());
                misMascotas[this.posicion].earnDamage(extraDamage);
                misMascotas[this.posicion].earnLife(extraLife);
        }

    }

    //fusionar animal
    public void fusionar(Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Canguro.super.subirXp(fusion);
    }
}