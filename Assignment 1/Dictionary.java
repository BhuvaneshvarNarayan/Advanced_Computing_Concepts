/*
Author: Bhuvaneshvar Narayan J H
Subject: Advanced Computing Concepts
University of Windsor
Assignment 1
 */
import java.util.*; // Import the necessary Java utilities, including the HashMap and Scanner classes.
public class Dictionary {
    private static Map<String, String> dictionary = new HashMap<>(); // Create a HashMap to store word definitions.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input.

        // Here we populate dictionary object with various definitions
        dictionary.put("apple", "a round fruit with red or green skin and sweet white flesh");
        dictionary.put("banana", "a long, curved fruit with a yellow skin and soft, sweet flesh"); // These are the sample value and its definition
        dictionary.put("computer", "an electronic device for storing and processing data");
        dictionary.put("guava", "Guavas are plants in the genus Psidium of the family Myrtaceae. There are about 100 species of tropical shrubs and small trees in the genus.");
        dictionary.put("honeyberry", "The honeyberry (also known as a blue honeysuckle, sweetberry honeysuckle, fly honeysuckle, blue fly honeysuckle, blue-berried honeysuckle or haskap) is a fruit that is edible");
        dictionary.put("loquat", "A loquat is a tropical fruit that grows on a tree. Since it is tropical, it will only grow in a warm, wet climate. It grows in Spain, Italy, Portugal, Turkey, India and Iran.");
        dictionary.put("sapote", "Sapote is a word for a soft, edible fruit. The word is part of the names of several plants from Mexico, Central America and northern parts of South America that have fruits.");
        dictionary.put("yuzu", "The yuzu is a citrus fruit and plant. It originated in East Asia. The fruit looks like a rough small and yellow grapefruit, and changes colour from green to yellow when it becomes more ripe.");
        dictionary.put("satsuma", "Satsuma is a variety of tangerine with a loose skin. It is named after the former Satsuma Province of Japan. In the United Kingdom it is often associated with Christmas");
        dictionary.put("redcurrant", "A redcurrant (Ribes rubrum) is a type of fruit. It is related to the blackcurrant. They are in the same genus Ribes.");

        System.out.println("Welcome to your Java GUI based Dictionary App developed by Bhuvaneshvar Narayan"); // Shows the welcome text

        while (true) {
            System.out.println("\nMain-Menu:");
            System.out.println("1. Search or lookup for a word in Bhuvan's Dictionary");
            System.out.println("2. Don't remember the word? We got you covered! Get some suggestions by typing the words partially");
            System.out.println("3. Interested in Contributing to Bhuvan's Dictionary? Feel free to Add a new word!");
            System.out.println("4. We hate to see you go though, have a wonderful day! Bye!");
            System.out.print("What would you like to do? ");
            int bhuvan_s_options = scanner.nextInt(); // This is where the user input is taken
            scanner.nextLine();  // Consume a newline character here

            switch (bhuvan_s_options) {
                case 1:
                    bhuvan_find_a_new_word(scanner); // This will call the function to find a new word
                    break;
                case 2:
                    bhuvan_helprs(scanner); // This will call the function to get you the suggestions for the partial words or phrases you enter
                    break;
                case 3:
                    contrbute_to_BD(scanner); // This will call the function to contribute new words to Bhuvan's Dictionary
                    break;
                case 4:
                    System.out.println("Have a wonderful day!"); // This will close the scanner input window and exits the Bhuvan's application
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ah! That doesn't count. Guess you will have to try typing that again!"); // Default value
            }
        }
    }

    private static void bhuvan_find_a_new_word(Scanner scanner) {
        System.out.print("Please enter a word: ");
        String word = scanner.nextLine().toLowerCase(); // This reads the word entered by the user and converts it to lower case.

        if (dictionary.containsKey(word)) {
            String definition = dictionary.get(word); // This will get the definition of the word from the user.
            System.out.println("Here is the definition you asked: " + definition);
        } else {
            System.out.println("Sorry, the word you are looking for is not found in Bhuvan's Dictionary. Perhaps, try adding this word in Bhuvan's Dictionary for future use.");
        }
    }

    private static void bhuvan_helprs(Scanner scanner) {
        System.out.print("Please enter a partial word or phrase you remember: ");
        String partialWord = scanner.nextLine().toLowerCase(); // This will read the partial word entered by the user and convert it to lower case.

        List<String> suggestions = new ArrayList<>(); // This creates a list to store suggestions.
        
     // Iterate through the dictionary to find words that start with the partial word.
        for (String word : dictionary.keySet()) {
            if (word.startsWith(partialWord)) {
                suggestions.add(word); // Add matching words to the suggestions list
            }
        }

        if (suggestions.isEmpty()) {
            System.out.println("Sorry, no suggestions are found in Bhuvan's Dictionary!");
        } else {
            System.out.println("Here are your suggestions: " + String.join(", ", suggestions)); // This will print the suggestions
        }
    }

    private static void contrbute_to_BD(Scanner scanner) {
        System.out.print("Please enter the new word that you would like to contribute to Bhuvan's Dictionary: ");
        String newWord = scanner.nextLine().toLowerCase(); // This will read the new word to be added and convert it to lower case

        if (dictionary.containsKey(newWord)) {
            System.out.println("I'm afraid the word already exists in Bhuvan's dictionary.");
        } else {
            System.out.print("Please enter the word's definition: "); 
            String definition = scanner.nextLine(); // Read the definition of the new word.
            dictionary.put(newWord, definition); // Add the new word and its definition to the dictionary
            System.out.println("Thank you for your contribution. The word has been added to Bhuvan's dictionary successfully.");
        }
    }
}