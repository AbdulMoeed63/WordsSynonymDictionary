import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SynonymDictionary {

    private HashMap<String, List<String>> synonymMap;

    public SynonymDictionary() {
        synonymMap = new HashMap<>();
    }

    public void insertWord(String word, List<String> synonyms) {
        if (synonymMap.containsKey(word)) {
            synonymMap.get(word).addAll(synonyms);
        } else {
            synonymMap.put(word, new ArrayList<>(synonyms));
        }
        System.out.println("Word \"" + word + "\" added or updated successfully");
    }

    public void searchWord(String word) {
        if (synonymMap.containsKey(word)) {
            List<String> synonyms = synonymMap.get(word);
            System.out.println("Synonyms for \"" + word + "\": " + synonyms);
        } else {
            System.out.println("Word \"" + word + "\" not found in the dictionary");
        }
    }

    public void deleteWord(String word) {
        if (synonymMap.containsKey(word)) {
            synonymMap.remove(word);
            System.out.println("Word \"" + word + "\" removed from the dictionary.");
        } else {
            System.out.println("Word \"" + word + "\" not found.");
        }
    }

    public void updateWord(String word, List<String> newSynonyms, boolean add) {
        if (synonymMap.containsKey(word)) {
            List<String> existingSynonyms = synonymMap.get(word);
            
            if (add) {
                existingSynonyms.addAll(newSynonyms);
                System.out.println("Synonyms added for \"" + word + "\".");
            } else {
                existingSynonyms.removeAll(newSynonyms);
                System.out.println("Synonyms removed for \"" + word + "\".");
            }
        } else {
            System.out.println("Word \"" + word + "\" not found.");
        }
    }
    public static void main(String[] args)  {

        SynonymDictionary dictionary = new SynonymDictionary();

        List<String> synonyms1 = List.of("happy", "joyful", "cheerful", "content");
        dictionary.insertWord("happy", synonyms1);
        dictionary.searchWord("happy");
        List<String> newSynonyms = List.of("elated", "delighted");
        dictionary.updateWord("happy", newSynonyms, true);  // Add new synonyms
        dictionary.searchWord("happy");
        List<String> synonymsToRemove = List.of("joyful");
        dictionary.updateWord("happy", synonymsToRemove, false);  // Remove synonym
        dictionary.searchWord("happy");
        dictionary.deleteWord("happy");
        dictionary.searchWord("happy");
    }
}

