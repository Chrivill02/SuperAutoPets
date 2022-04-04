
package proyecto1;

public class Mapache extends Mascota {
    private String type = "Solitario";
    protected String nombre="Mapache";

    public String getNombre() {
        return nombre;
    }

    public Mapache(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Mapache mapache = new Mapache(5, 4, 3);
        misMascotas[this.posicion] = mapache;
    }

    //definir habilidadAnimal
    public void habilidad(Mascota[] misMascotas, Mascota mascotasEnemigas[]) {
        if (this.vida <= 0)
            giveAbility(misMascotas, mascotasEnemigas);

    }

    public void giveAbility(Mascota[] misMascotas, Mascota mascotasEnemigas[]) {
        if (nivel == 1) {
            if (this.posicion - 1 > 0 && this.posicion<5) {
                int extraDamage = 1;
                misMascotas[this.posicion + 1].earnDamage(extraDamage);
                misMascotas[this.posicion - 1].earnDamage(extraDamage);
            }else if(this.posicion-1<0){
                int extraDamage = 1;
                misMascotas[this.posicion + 1].earnDamage(extraDamage);
                mascotasEnemigas[0].earnDamage(extraDamage);
            }else{
                int extraDamage = 1;
                misMascotas[this.posicion-1].earnDamage(extraDamage);
            }
        } else if (nivel == 2) {
        } else if (this.posicion - 1 > 0) {
            int extraDamage = 2;
            misMascotas[this.posicion + 1].earnDamage(extraDamage);
            misMascotas[this.posicion - 1].earnDamage(extraDamage);
        } else if (nivel == 3) {
        } else if (this.posicion - 1 > 0) {
            int extraDamage = 3;
            misMascotas[this.posicion + 1].earnDamage(extraDamage);
            misMascotas[this.posicion - 1].earnDamage(extraDamage);
        }

        if (nivel == 1) {
            if (this.posicion - 1 < 0) {
                int extraDamage = 1;
                misMascotas[this.posicion + 1].earnDamage(extraDamage);
                mascotasEnemigas[0].earnDamage(extraDamage);
            } else if (nivel == 2) {
            } else if (this.posicion - 1 < 0) {
                int extraDamage = 2;
                misMascotas[this.posicion + 1].earnDamage(extraDamage);
                mascotasEnemigas[0].earnDamage(extraDamage);
            }
        } else if (nivel == 3) {
        } else if (this.posicion - 1 < 0) {
            int extraDamage = 3;
            misMascotas[this.posicion + 1].earnDamage(extraDamage);
            mascotasEnemigas[0].earnDamage(extraDamage);
        }
    }

    //fusionar animal
    public void fusionar(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Mapache.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Mapache.super.subirXp(fusion);
        }
    }


}