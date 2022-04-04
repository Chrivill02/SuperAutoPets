package proyecto1;



public class Zorro extends Mascota {
    private String[] type = new String[2];
    protected String nombre="Zorro";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Solitario";
        this.type[1] = "Terrestre";
    }

    public Zorro(int damage, int life, int tier) {
        this.vida = life;
        this.ataque = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Zorro zorro = new Zorro(5, 2, 2);
        misMascotas[this.posicion] = zorro;
    }

    //definir Habilidad
    public void habilidad(Mascota[] mascotasEnemigas) {
        giveAbility(mascotasEnemigas);
    }

    //definir cuando hara su habilidadAnimal
    public void giveAbility( Mascota[] mascotasEnemigas) {
        if (this.nivel == 1) {
            if (this.vecesAtacar == 3) {
                mascotasEnemigas[0].damageCaused(this.ataque);
                this.vecesAtacar=0;
            }
        } else if (this.nivel == 2) {
            if (this.vecesAtacar == 2) {
                mascotasEnemigas[0].damageCaused(this.ataque);
                this.vecesAtacar=0;
            }
        } else if (this.nivel == 3) {
            if (this.vecesAtacar == 1) {
                mascotasEnemigas[0].damageCaused(this.ataque);
                this.vecesAtacar=0;
            }
        }
    }

    //definir el danio
    public void extraDamage() {
        int extraDamage = 2;
        this.ataque = this.ataque * extraDamage;
    }

    //definir lo que hara la habilidadAnimal
    public void atacar(Mascota  [] mascotasEnemigas) {
        switch (mascotasEnemigas[0].getEfecto()) {
            case "Cebolla" -> {
                this.ataque = this.ataque - 2;
                mascotasEnemigas[0].damageCaused(this.ataque);
                this.vecesAtacar = +1;
                habilidad(mascotasEnemigas);
            }
            case "Melon" -> {
                this.ataque = 0;
                mascotasEnemigas[0].damageCaused(this.ataque);
                this.vecesAtacar = +1;
                habilidad(mascotasEnemigas);
                mascotasEnemigas[0].setEfecto("Ninguno");
            }
            case "Ninguno" -> {
                mascotasEnemigas[0].damageCaused(this.ataque);
                this.vecesAtacar = +1;
                habilidad(mascotasEnemigas);
            }
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
        Zorro.super.subirXp(fusion);

    }

}
