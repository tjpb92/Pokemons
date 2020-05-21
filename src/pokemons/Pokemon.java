package pokemons;

import java.util.Random;

public class Pokemon {

    private int id;
    private String name;
    private int hp = 100;

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void dormir() {
        System.out.println("Ce Pokémon doit se reposer ...");
    }

    public void attaquer(Pokemon pokemon) {
        Random rand = new Random();

        float rnd = rand.nextFloat();
        if (rnd < 0.5) {
            coupDeBoule(pokemon);
        } else {
            coupDeGriffe(pokemon);
        }

    }

    public void coupDeGriffe(Pokemon pokemon) {
        System.out.println("Coup de griffe sur " + pokemon.getName() + " de la part de " + name);
        if (pokemon.isKO()) {
            System.out.println("Ce pokémon est déjà KO");
        } else {
            pokemon.setHp(pokemon.getHp()-2);
            if (pokemon.isKO()) {
                System.out.println("Ce pokémon a été mis KO");
                pokemon.dormir();
                System.out.println("Victoire de " + name);
            } else {
                System.out.println("C'était une très bonne attaque (" + pokemon.getHp() + ")");
            }
        }
    }

    public void coupDeBoule(Pokemon pokemon) {
        System.out.println("Coup de boule sur " + pokemon.getName() + " de la part de " + name);
        if (pokemon.isKO()) {
            System.out.println("Ce pokémon est déjà KO");
        } else {
            pokemon.setHp(pokemon.getHp()-1);
            if (pokemon.isKO()) {
                System.out.println("Ce pokémon a été mis KO");
                pokemon.dormir();
                System.out.println("Victoire de " + name);
            } else {
                System.out.println("C'était une bonne attaque (" + pokemon.getHp() + ")");
            }
        }
    }

    public void seReveiller() {
        System.out.println("Ce Pokémon est en pleine forme");
    }
    public boolean isKO() {
        return (hp == 0);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
