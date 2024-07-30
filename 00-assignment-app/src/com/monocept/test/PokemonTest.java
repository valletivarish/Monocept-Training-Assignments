package com.monocept.test;

import com.monocept.model.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Welcome Master");
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Gliscor", 0, 300));
        pokemons.add(new Pokemon("Necroma", 0, 300));
        pokemons.add(new Pokemon("Lickitung", 0, 300));
        pokemons.add(new Pokemon("Annihilape", 0, 300));
        pokemons.add(new Pokemon("Azumarill", 0, 300));
        pokemons.add(new Pokemon("Garchomp", 0, 300));
        pokemons.add(new Pokemon("Dragonite", 0, 300));

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Load the pokemons");
            System.out.println("2. Save the pokemons");
            System.out.println("3. Update the pokemons");
            System.out.println("4. Display the pokemons");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    loadThePokemons(pokemons);
                    break;
                case 2:
                    saveThePokemons(pokemons);
                    break;
                case 3:
                    updateThePokemons(pokemons);
                    break;
                case 4:
                	displayThePokemons(pokemons);
                	break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void updateThePokemons(List<Pokemon> pokemons) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the Pokemon to update:");
        int location = scanner.nextInt();
        if (location >= 1 && location <= pokemons.size()) {
            Pokemon pokemon = pokemons.get(location - 1);
            feedThePokemon(pokemon);
            System.out.println("Pokemon updated successfully.");
        } else {
            System.out.println("Invalid index. No Pokemon updated.");
        }
    }

    private static void feedThePokemon(Pokemon pokemon) {
        pokemon.incrementStars(1); // increment stars by 1
        pokemon.incrementBerryCount(); // increment berry count
    }

    private static void saveThePokemons(List<Pokemon> pokemons) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pokemons.txt"))) {
            for (Pokemon pokemon : pokemons) {
                out.writeObject(pokemon);
            }
            System.out.println("Pokemons saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving pokemons: " + e.getMessage());
        }
    }

    private static void loadThePokemons(List<Pokemon> pokemons) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pokemons.txt"))) {
            pokemons.clear(); // Clear existing pokemons
            while (true) {
                try {
                    Pokemon pokemon = (Pokemon) in.readObject();
                    pokemons.add(pokemon);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Pokemons loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading pokemons: " + e.getMessage());
        }
    }

    private static void displayThePokemons(List<Pokemon> pokemons) {
        if (pokemons.isEmpty()) {
            System.out.println("No pokemons to display.");
        } else {
            System.out.println("List of Pokemons:");
            int index = 1;
            for (Pokemon pokemon : pokemons) {
                System.out.println("Pokemon " + index + ": " + pokemon);
                index++;
            }
        }
    }
}
