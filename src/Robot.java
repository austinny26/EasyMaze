
import java.util.ArrayList;

public class Robot {
    private int[][] currentPos;
    private String[][] maze;
    private int x;
    private int y;
    private ArrayList<String> path = new ArrayList<>();

    public Robot(int x, int y, String[][] maze){
        this.maze = maze;
        currentPos = new int[y][x];
        this.x = x;
        this.y = y;
    }

    public void moveLeft(){
            y--;
            path.add("(" + y + "," + x + ")");
    }

    public void moveRight(){
            y++;
            path.add("(" + y + "," + x + ")");

    }

    public void moveUp(){
            x--;
            path.add("(" + y + "," + x + ")");
    }

    public void moveDown(){
            x++;
            path.add("(" + y + "," + x + ")");
    }

    public boolean canMoveDown(){
        try {
            if (!maze[x + 1][y].equals(".")) {
                return false;
            }
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public boolean canMoveUp(){
        try {
            if (!maze[x - 1][y].equals(".")) {
                return false;
            }
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public boolean canMoveLeft(){
        try {
            if (!maze[x][y - 1].equals(".")) {
                return false;
            }
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public boolean canMoveRight(){
        try {
            if (!maze[x][y + 1].equals(".")){
                return false;
            }
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public void hugLeft(){
        while(!maze[x][y].equals(maze[49][117])) {

            if (canMoveRight()) {
                while (canMoveRight()) {
                    moveRight();
                    System.out.println("moving right");
                }
            }
            if (canMoveUp()) {
                while (canMoveUp()) {
                    moveUp();
                    System.out.println("moving up");
                }
            }
            if (canMoveLeft()) {
                while (canMoveLeft()) {
                    moveLeft();
                    System.out.println("moving left");
                }
            }
            if (canMoveDown()) {
                while (canMoveDown()) {
                    moveDown();
                    System.out.println("moving down");
                }
            }
        }
        System.out.println("end of maze");
    }

    public ArrayList<String> getPath() {
        return path;
    }

}
