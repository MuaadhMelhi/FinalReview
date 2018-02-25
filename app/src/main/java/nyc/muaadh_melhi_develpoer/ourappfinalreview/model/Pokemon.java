package nyc.muaadh_melhi_develpoer.ourappfinalreview.model;

import java.util.List;

/**
 * Created by c4q on 2/24/18.
 */

public class Pokemon {
    private List<Abilities> abilities;
    private List<Stats> stats;
    private String name;
    private int weight;
    private Sprites sprites;
    private int height;
    private int id;
    private List<Types> types;

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public int getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public List<Types> getTypes() {
        return types;
    }
}
