package proyecto1;

public abstract class Mascota implements Cloneable {

    protected int vida;
    protected int ataque;
    protected int xp = 0;
    protected int nivel = 1;
    protected int posicion;
    protected int tier;
    protected int vecesAtacar = 0;
    protected boolean vendido=false;
    protected boolean derrotado = false;
    protected String efecto ="Ninguno";
    protected String nombre;
    protected int vidaEnPelea = vida;
    protected int danioEnPelea = ataque;

    protected Mascota() {
    }


    public String getNombre(){
        return nombre;
    }

    public int getXP(){
        return this.xp;
    }

    public boolean getDerrotado() {
        return this.derrotado;
    }

    public int getVecesAtacar() {
        return this.vecesAtacar;
    }

    public void efectoActivo(String fruta) {
        if (fruta.equals("Cebolla")) {
            this.efecto = "Cebolla";
        } else if (fruta.equals("Melon")) {
            this.efecto = "Melon";
        } else if (fruta.equals("Miel")) {
            this.efecto = "Miel";
        } else if(fruta.equals("Hueso de carne")){
            this.efecto = "Hueso de carne";
        } else if(fruta.equals("Chile")){
            this.efecto ="Chile";
        }
    }

    public void setVendido(boolean vendido){
        this.vendido = vendido;
    }
    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getPosicion() {

        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getVida() {

        return vida;
    }



    public int getTier() {

        return tier;
    }

    public Mascota(int life, int damage) {
        this.vida = life;
        this.ataque = damage;
    }

    public void fusion(){

    }

    public void subirXp(boolean fusion) {
        if (!fusion) {
            System.out.println("No se puede fusionar");
        } else {
            xp += 1;
            this.vida +=1;
            this.ataque +=1;
        }
        //comprobando si subio de nivel
        if (xp == 2) {
            System.out.println("Mascota subio a nivel 2");
            nivel = 2;
        } else if (xp == 5) {
            System.out.println("Mascota subio a nivel 3");
            nivel = 3;
        }
    }

    public void subirXpPorChocolate(int extraXp){
        this.xp+=extraXp;
    }


    public void damageCaused(int damageCaused) {
        vida -= damageCaused;
        if (vida <= 0) {
            this.derrotado = true;
        }


    }


    public void atacar(Mascota[] mascotasEnemigas) {
        if (mascotasEnemigas[0].getEfecto().equals("Ajo")) {
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
        } else if (mascotasEnemigas[0].getEfecto().equals("Miel")) {
            mascotasEnemigas[0].damageCaused(this.ataque);
            if (mascotasEnemigas[0].getDerrotado()) {
                mascotasEnemigas[0] = new Abeja(1, 1, 1);
            }
        }

    }

    public void earnDamage(int extraDamage) {
        this.ataque += extraDamage;
    }


    public void earnLife(int extraLife) {
        this.vida += extraLife;
    }

    @Override
    public Mascota clone(){
        try {
            return (Mascota) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public void earnDamageInBatle(int extraDamage) {
        danioEnPelea = +extraDamage;
    }

    public void earnLifeInBatle(int extraLife) {
        vidaEnPelea += extraLife;
    }

}
