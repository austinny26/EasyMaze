
import java.util.ArrayList;
import java.util.Objects;

public class Robot {
    private String[][] maze;
    private int rows, cols;
    private int x, y, dir; // Current position and direction
    private final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private ArrayList<String> cordList = new ArrayList<>();


    public Robot(String[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;


        this.x = 0;
        this.y = 0;
        this.dir = 1;
    }

    public void removeDuplicates(ArrayList<String> arr){
        for(String cord : arr){
            if (arr.contains(cord))
        }
    }

    public void solve() {
        while (x >= 0 && x < rows && y >= 0 && y < cols && !Objects.equals(maze[x][y], "d")) { // While not out of bounds or at the exit (marked as 2)
            // turn left
            dir = (dir + 3) % 4;
            if (canMove()) {
                moveForward();
                cordList.add(y + "," + x);
                continue;
            }

            // forward
            dir = (dir + 1) % 4;
            if (canMove()) {
                moveForward();
                System.out.println(y + "," + x);
                cordList.add(y + "," + x);
                continue;
            }

            // Turn right
            dir = (dir + 1) % 4;
            if (canMove()) {
                moveForward();
                cordList.add(y + "," + x);
                continue;
            }

            // Turn around
            dir = (dir + 1) % 4;
            if (canMove()) {
                moveForward();
                cordList.add(y + "," + x);
            }
        }
    }

    private boolean canMove() {
        int nextX = x + DIRECTIONS[dir][0];
        int nextY = y + DIRECTIONS[dir][1];
        return nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !Objects.equals(maze[nextX][nextY], "#"); // # represents a wall
    }

    private void moveForward() {
        x += DIRECTIONS[dir][0];
        y += DIRECTIONS[dir][1];
    }

}
