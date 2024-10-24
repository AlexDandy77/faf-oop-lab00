package oop.practice.lab1.task2;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    // Constructor
    public TextData(String text) {
        this.text = text;
        analyzeText();
    }

    // Method to analyze text
    private void analyzeText() {
        if (text == null || text.isEmpty()) {
            return;
        }

        String[] words = text.split("\\s+");
        longestWord = "";

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                numberOfLetters++;
                if (isVowel(ch)) {
                    numberOfVowels++;
                } else {
                    numberOfConsonants++;
                }
            }
        }

        // Sentences count based on punctuation
        numberOfSentences = text.split("[.!?]").length;

        // Longest word
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
    }

    // Check if a character is a vowel
    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

    // Getter methods
    public String getFilename() { return fileName; }
    public String getText() { return text; }
    public int getNumberOfVowels() { return numberOfVowels; }
    public int getNumberOfConsonants() { return numberOfConsonants; }
    public int getNumberOfLetters() { return numberOfLetters; }
    public int getNumberOfSentences() { return numberOfSentences; }
    public String getLongestWord() { return longestWord; }

    @Override
    public String toString() {
        return "Text Analysis Results:\n" +
                "Vowels: " + numberOfVowels + "\n" +
                "Consonants: " + numberOfConsonants + "\n" +
                "Letters: " + numberOfLetters + "\n" +
                "Sentences: " + numberOfSentences + "\n" +
                "Longest Word: " + longestWord;
    }
}
