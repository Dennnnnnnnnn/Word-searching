import java.util.Dictionary;

public class PuzzleData {
    char[][] grid;
    Dictionary<Integer, String> dict;

    public PuzzleData(char[][] grid, Dictionary<Integer, String> dict){
        this.grid = grid;
        this.dict = dict;
    }

    public char[][] getGrid(){
        return grid;
    }

    public Dictionary<Integer, String> getDictionary(){
        return dict;
    }
}
