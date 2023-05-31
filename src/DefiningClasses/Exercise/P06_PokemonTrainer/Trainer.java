package DefiningClasses.Exercise.P06_PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, List<Pokemon> pokemonList) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonList = pokemonList;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }
    public void commandExecuting(String command) {
        if (isExist(command)) {
            numberOfBadges += 1;
        } else {

            for (int i = 0; i < pokemonList.size(); i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if (pokemonList.get(i).getHealth() <= 0) {
                    pokemonList.remove(i);
                    i--;
                }
            }
        }
    }
    private boolean isExist(String command) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return name + " " + numberOfBadges + " " + pokemonList.size();
    }
}
