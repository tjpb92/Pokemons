package pokemons;

public class Pokemons {

    public static void main(String[] args) {

        Pokemon miaouss = new Pokemon(52, "Miaouss");
        System.out.println(miaouss);

        Pokemon bulbizarre = new Pokemon(1, "Bulbizarre");
        System.out.println(bulbizarre);

        System.out.println(Pokemon.count() + " pokémon(s) créé(s)");

        Dresseur sacha = new Dresseur(1, "Sacha");
        System.out.println(sacha);

        PokeBall pb1 = new PokeBall();

        miaouss.attaquer(bulbizarre);
        System.out.println("après attaque de Miaouss : " + bulbizarre);

        bulbizarre.coupDeGriffe(miaouss);
        System.out.println("après coup de griffe de Bulbizarre : " + miaouss);

        miaouss.coupDeBoule(bulbizarre);
        System.out.println("après coup de boule de Miaouss : " + bulbizarre);

        boolean exit = false;
        int n = 0;
        while(!exit) {
            n++;
            System.out.println("Combat n°" + n);
            if (miaouss.isKO()) {
                exit=true;
            } else {
                miaouss.attaquer(bulbizarre);
                if (bulbizarre.isKO()) {
                    exit=true;
                }
                else {
                    bulbizarre.attaquer(miaouss);
                    exit = miaouss.isKO();
                }
            }
        }
        if (!miaouss.isKO()) {
            pb1.capture(miaouss);
        } else {
            pb1.capture(bulbizarre);
        }
        pb1.capture(miaouss);
        pb1.libere();
        pb1.libere();
    }
}
