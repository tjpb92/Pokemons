package pokemons;

public class Dresseur {

    private int id;
    private String name;

    public Dresseur(int id, String name) {
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

    @Override
    public String toString() {
        return "Dresseur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
