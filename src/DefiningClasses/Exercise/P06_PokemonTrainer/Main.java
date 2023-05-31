package DefiningClasses.Exercise.P06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<Pokemon>> pokemonByTrainers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            //{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}
            String[] pokemonData = input.split("\\s+");

            String trainerName = pokemonData[0];
            String pokemonName = pokemonData[1];
            String pokemonElement = pokemonData[2];
            int pokemonHealth = Integer.parseInt(pokemonData[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonByTrainers.putIfAbsent(trainerName, new ArrayList<>());
            pokemonByTrainers.get(trainerName).add(pokemon);

            input = scanner.nextLine();
        }

        List<Trainer> trainerList = pokemonByTrainers.entrySet().stream().map(t -> new Trainer(t.getKey(), t.getValue())).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(command);
            }


            command = scanner.nextLine();
        }
        trainerList.stream().sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed()).forEach(System.out::println);
    }
}
