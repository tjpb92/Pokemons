package pokemons;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Random;

public class Pokemon {

    private int id;
    private String name;
    private int hp = 100;

    /**
     * Permet d'avoir des nombres aléatoires différents d'une exécution à l'autre
     */
    private static Random random = new Random(GregorianCalendar.getInstance().getTimeInMillis());

    /**
     * Indique le nombre de pokémon(s) créé(s)
     */
    private static int nbPokemons = 0;

    /**
     * Constructeur principal
     *
     * @param id   : identifiant unique du pokémon
     * @param name : nom du pokémon
     */
    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
        nbPokemons++;
    }

    /**
     * Retourne le nombre de pokémon(s) créé(s)
     *
     * @return le nombre de pokémon(s) créé(s)
     */
    public static int count() {
        return nbPokemons;
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

        float rnd = random.nextFloat();
        if (rnd < 0.20) {
            coupDeBoule(pokemon);
        } else if (rnd >= 0.20 && rnd < 0.4) {
            coupDeGriffe(pokemon);
        } else if (rnd >= 0.4 && rnd < 0.6) {
            plaquage(pokemon);
        } else if (rnd >= 0.6 && rnd < 0.8) {
            cyclone(pokemon);
        } else {
            ultralaser(pokemon);
        }

    }

    /**
     * Définit une attaque générique
     *
     * @param nom     : nom de l'attaque,
     * @param points  : points d'attaque = dégats infligés à l'adversaire
     * @param pokemon : pokémon recevant l'attaque
     */
    public void attaque(String nom, int points, Pokemon pokemon) {
//        System.out.println(nom + " sur " + pokemon.getName() + " de la part de " + name);
        System.out.println(name + " attaque " + pokemon.getName() + "(" + pokemon.getHp()+ ")" + " avec " + nom.toLowerCase());
        if (pokemon.isKO()) {
            System.out.println("Ce pokémon est déjà KO");
        } else {
            pokemon.setHp(pokemon.getHp() - points);
            if (pokemon.isKO()) {
                System.out.println("Ce pokémon a été mis KO");
                pokemon.dormir();
                System.out.println("Victoire de " + name);
            } else {
                System.out.println("C'était une très bonne attaque (" + pokemon.getHp() + ")");
            }
        }
    }

    /**
     * Attaque de type ultralaser entrainant la perte de 10 points de vie
     *
     * @param pokemon pokémon recevant l'attaque
     */
    public void ultralaser(Pokemon pokemon) {
        attaque("Utralaser", 10, pokemon);
    }

    /**
     * Attaque de type cyclone entrainant la perte de 7 points de vie
     *
     * @param pokemon pokémon recevant l'attaque
     */
    public void cyclone(Pokemon pokemon) {
        attaque("Cyclone", 7, pokemon);
    }

    /**
     * Attaque de type plaquage entrainant la perte de 4 points de vie
     *
     * @param pokemon pokémon recevant l'attaque
     */
    public void plaquage(Pokemon pokemon) {
        attaque("Plaquage", 4, pokemon);
    }

    /**
     * Attaque de type coup de griffe entrainant la perte de 2 points de vie
     *
     * @param pokemon pokémon recevant l'attaque
     */
    public void coupDeGriffe(Pokemon pokemon) {
        attaque("Coup de griffe", 2, pokemon);
    }

    /**
     * Attaque de type coup de boule entrainant la perte de 1 point de vie
     *
     * @param pokemon pokémon recevant l'attaque
     */
    public void coupDeBoule(Pokemon pokemon) {
        attaque("Coup de boule", 1, pokemon);
    }

    public void seReveiller() {
        System.out.println("Ce Pokémon est en pleine forme");
    }

    public boolean isKO() {
        return (hp <= 0);
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
