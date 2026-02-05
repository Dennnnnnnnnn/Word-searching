import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Main {
    //Matrix with letters
    public static char[][] grid;
    //Trie that stores all words from the dictionary
    public static Trie trie = new Trie();
    //Array with words that are somewhere in the puzzle
    public static ArrayList<String> result = new ArrayList<>();
    //Dictionary with words
    public static Dictionary<Integer, String> words = new Hashtable<>();

    public static void main(String[] args) {
        PuzzleData data = Reader.readFile("initial_data.txt");
        grid = data.getGrid();
        words = data.getDictionary();

        //Insert words into trie
        for (int i = 0; i < words.size(); i++){
            String word = words.get(i);
            trie.insert(word);
        }
        trie.printTrieRecursive();
        checkGrid();

        System.out.println("Results: ");
        for (String element : result){
            System.out.println(element);
        }
    }

    //Main algorithm of the program, checks each cell in the matrix in 8 directions
    public static void checkGrid(){
        int[] directionX = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] directionY = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid.length; col++){

                for (int direction = 0; direction < 8; direction++){
                    StringBuilder sb = new StringBuilder();

                    int currX = row;
                    int currY = col;

                    while (currX >= 0 && currX < grid.length && currY >= 0 && currY < grid.length){
                        sb.append(grid[currX][currY]);
                        String prefix = sb.toString();

                        if (!trie.containsPart(prefix)){
                            break;
                        }
                        if (trie.contains(prefix) && !result.contains(prefix)){ //if word appears in the matrix more than once, add only 1 time
                            result.add(prefix);
                        }

                        currX += directionX[direction];
                        currY += directionY[direction];
                    }
                }
            }
        }
    }

}