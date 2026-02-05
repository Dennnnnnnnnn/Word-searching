import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class Reader {
    public static PuzzleData readFile(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            int N = Integer.parseInt(reader.readLine());

            char[][] grid = new char[N][N];
            Dictionary<Integer, String> dict = new Hashtable<>();

            for (int i = 0; i < N; i++){
                line = reader.readLine();
                char[] array = line.replace(" ", "").toCharArray();
                for (int col = 0; col < array.length; col++){
                    grid[i][col] = array[col];
                }
            }
            int key = 0;
            while ((line = reader.readLine()) != null){
                dict.put(key++, line.trim().toLowerCase());
            }
            return new PuzzleData(grid, dict);
        }
        catch(IOException e){
            System.out.println("Error in reading file: " + fileName);
        }
        return null;
    }
}
