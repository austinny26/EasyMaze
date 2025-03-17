import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] maze = getMaze("src/Maze");
        Robot mouse = new Robot(0,0, maze, "South");
        System.out.println(mouse.canMoveDown());
        System.out.println(mouse.isHuggingLeftWall("South"));
        mouse.moveDown();
        mouse.hugLeft();
        System.out.println(Arrays.deepToString(maze));
        System.out.println(maze[0][0].equals(maze[49][117]));
        mouse.getPath();
        System.out.println(mouse.getPath());



    }

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                    maze[i][j] = d.charAt(j) + "";
                }
        }
        return maze;

    }

}