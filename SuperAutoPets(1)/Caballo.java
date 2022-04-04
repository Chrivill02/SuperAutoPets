package proyecto1;



public class Caballo extends Mascota {

    private String[] type = new String[2];
    protected String nombre="Caballo";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Domestico";
        this.type[1] = "Mamifero";
    }

    public Caballo(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Caballo caballo = new Caballo(2, 1, 1);
        misMascotas[this.posicion] = caballo;

    }

    //definir  su habilidadAnimal
    public void habilidad(Mascota misMascotas[], int posicionDeAnimalInvocado) {
        giveAbility(misMascotas, posicionDeAnimalInvocado);
       

    }

    //definir lo que hara su habilidadAnimal
    public void giveAbility(Mascota misMascotas[], int posicion) {
        if (nivel == 1) {
            int extraDamage = 1;
            misMascotas[posicion].earnDamage(extraDamage);
        } else if (nivel == 2) {
            int extraDamage = 2;
            misMascotas[posicion].earnDamage(extraDamage);
        } else if (nivel == 3) {
            int extraDamage = 3;
            misMascotas[posicion].earnDamage(extraDamage);
        }
    }

    //fusionar animal
    public void fusion( Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Caballo.super.subirXp(fusion);

    }



}
