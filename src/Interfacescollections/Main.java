package Interfacescollections;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        VideoGameCollection collection = new VideoGameCollection();

        collection.addGame(new PCGame("Elder Scrolls V: Skyrim", "RPG", LocalDate.of(2011, 11, 11), true));
        collection.addGame(new PCGame("Cyber Adventure 2077", "Action", LocalDate.of(2020, 12, 10), false));
        collection.addGame(new PCGame("Mystic Quest", "RPG", LocalDate.of(2018, 5, 15), true));
        collection.addGame(new PCGame("Shadow Warriors", "Action", LocalDate.of(2015, 10, 20), false));
        collection.addGame(new PCGame("Galaxy Raiders", "Sci-Fi", LocalDate.of(2022, 3, 22), true));
        collection.addGame(new PCGame("Zombie Apocalypse", "Horror", LocalDate.of(2017, 8, 14), true));
        collection.addGame(new PCGame("Fantasy Realms", "Fantasy", LocalDate.of(2019, 6, 18), false));
        collection.addGame(new PCGame("Racing Fury", "Racing", LocalDate.of(2016, 2, 11), true));
        collection.addGame(new PCGame("Space Odyssey", "Adventure", LocalDate.of(2021, 7, 19), true));
        collection.addGame(new PCGame("Battle Arena X", "Fighting", LocalDate.of(2013, 9, 27), false));
        collection.addGame(new ConsoleGame("Castle Defenders", "Tower Defense", LocalDate.of(2014, 11, 9), true));
        collection.addGame(new ConsoleGame("Ocean Explorer", "Simulation", LocalDate.of(2023, 4, 15), false));
        collection.addGame(new ConsoleGame("Dystopian Tales", "RPG", LocalDate.of(2012, 1, 30), true));
        collection.addGame(new ConsoleGame("Alien Invasion", "Sci-Fi", LocalDate.of(2018, 3, 5), true));
        collection.addGame(new ConsoleGame("Haunted Manor", "Horror", LocalDate.of(2020, 10, 13), false));
        collection.addGame(new ConsoleGame("Pirate's Cove", "Adventure", LocalDate.of(2019, 12, 25), true));
        collection.addGame(new ConsoleGame("Super Soccer League", "Sports", LocalDate.of(2021, 8, 2), false));
        collection.addGame(new ConsoleGame("Robot Uprising", "Sci-Fi", LocalDate.of(2016, 11, 8), true));
        collection.addGame(new ConsoleGame("Medieval Heroes", "Strategy", LocalDate.of(2017, 5, 4), true));
        collection.addGame(new ConsoleGame("Dragon's Quest", "Fantasy", LocalDate.of(2014, 6, 10), false));

       collection.listAllGames();
       //collection.listIsGamaing();
       // collection.showLastPlayed();
    }
}