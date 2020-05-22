package pokemons;

import java.util.GregorianCalendar;
import java.util.Random;

public class PokeBall {

    /**
     * Permet d'avoir des nombres aléatoires différents d'une exécution à l'autre
     */
    private static Random random = new Random(GregorianCalendar.getInstance().getTimeInMillis());

    /**
     * Pokémon capturé
     */
    private Pokemon pokemon;

    /**
     * Retourne le pokémon capturé
     * @return le pokémon capturé
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * Définit le pokémon capturé
     * @param pokemon pokémon capturé
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * Capture d'un pokémon
     * @param pokemon pokémon à capturer
     */
    public void capture(Pokemon pokemon) {
        if (this.pokemon == null) {
            if (pokemon.getHp() < 20 && random.nextFloat() < 0.8) {
                this.pokemon = pokemon;
                System.out.println("Capture de " + pokemon.getName() + " réussie.");
            } else {
                System.out.println("La capture a échoué.");
            }
        } else {
            System.out.println("Désolé, il y a déjà un pokémon dans cette Poké Ball");
        }
    }

    public Pokemon libere() {
        Pokemon pokemon = this.pokemon;

        if (pokemon != null) {
            System.out.println(pokemon.getName() + " a été libéré");
            this.pokemon = null;
        } else {
            System.out.println("Désolé cette poké ball est vide");
        }
        return pokemon;
    }

    @Override
    public String toString() {
        return "PokeBall{" +
                "pokemon=" + pokemon +
                '}';
    }
}
