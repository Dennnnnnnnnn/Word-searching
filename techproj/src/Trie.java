public class Trie {
    //Number of letters in English alphabet
    private final int ALPHABET_SIZE = 26;
    //English alphabet
    private final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }

    //Root of the trie
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    //Inserts specified word into the trie
    public void insert(String key){
        TrieNode current = root;
        for (int level = 0; level < key.length(); level++){
            int index = 0; //get index of letter in alphabet to correctly assign children
            for (char letter : ALPHABET){
                if (letter == key.charAt(level)){ //if we have found the letter index in alphabet, break
                    break;
                }
                index++;
            }

            if (current.children[index] == null){ //if we don't have this letter, we add
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    //Returns the node of a trie by prefix
    private TrieNode getNodeByPrefix(String key){
        TrieNode current = root;
        for (int level = 0; level < key.length(); level++){
            int index = 0; //index in alphabet
            for (char letter : ALPHABET){
                if (letter == key.charAt(level)){
                    break;
                }
                index++;
            }
            if (current.children[index] == null){
                return null;
            }
            current = current.children[index];
        }
        return current;
    }

    //Checks if the word is in the trie
    public boolean contains(String key){
        TrieNode trieNode = getNodeByPrefix(key);
        if (trieNode != null && trieNode.isEndOfWord){
            return true;
        }
        return false;
    }

    //Checks if the part of the word is in the trie
    public boolean containsPart(String key){
        TrieNode trieNode = getNodeByPrefix(key);
        return trieNode != null;
    }

    //Visualisation of the trie
    private void printTrieRecursive(TrieNode node, StringBuilder prefix, String indent) {
        if (node == null) {
            return;
        }

        if (node.isEndOfWord) {
            System.out.println(indent + prefix.toString() + " *");
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char c = (char) ('a' + i);
                prefix.append(c);
                System.out.println(indent + prefix.toString());
                printTrieRecursive(node.children[i], prefix, indent + "  ");
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    public void printTrieRecursive(){
        printTrieRecursive(root, new StringBuilder(), "");
    }

}
