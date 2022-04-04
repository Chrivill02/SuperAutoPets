package proyecto1;



public class Pavoreal extends Mascota {
    private String[] type = new String[2];
    protected String nombre="Pavoreal";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Domestico";
        this.type[1] = "Volador";
    }

    public Pavoreal(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Pavoreal pavoreal = new Pavoreal(2, 5, 2);
        misMascotas[this.posicion] = pavoreal;
    }

    //definir Habilidad
    public void habilidad(Mascota misMascotas[]){
        giveAbility(misMascotas);
    }

    //definir cantidad de danio extra
    public int extraDamage(){
        if(nivel ==1){
            int extraDamage=this.ataque /2;
            return extraDamage;
        }else if(nivel ==2){
            int extraDamage=this.ataque;
            return extraDamage;
        }else{
            int extraDamage=(this.ataque /2)*3;
            return extraDamage;
        }
    }

    //definir dar habilidadAnimal
    public void giveAbility( Mascota misMascotas[] ){
        misMascotas[this.posicion].earnDamage(extraDamage());
    }

    public void receiveDamage(int damageCaused, Mascota[] misMascotas) {
        vidaEnPelea -= damageCaused;
        habilidad(misMascotas);
    }

    //fusionar animal
    public void fusion( Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Pavoreal.super.subirXp(fusion);

    }



}
