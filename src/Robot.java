
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

    public boolean moveLeft(){
        if(maze[x][y-1].equals("#") || maze[x][y-1] == null){
            return false;
        }else {
            y--;
            path.add("(" + y + "," + x + ")");
            return true;
        }
    }

    public boolean moveRight(){
        if(maze[x][y+1].equals("#") || maze[x][y+1] == null){
            return false;
        }else {
            y++;
            path.add("(" + y + "," + x + ")");
            return true;
        }
    }

    public boolean moveUp(){
        if(maze[x-1][y].equals("#") || maze[x-1][y] == null){
            return false;
        }else {
            x++;
            path.add("(" + y + "," + x + ")");
            return true;
        }
    }

    public boolean moveDown(){
        if(maze[x+1][y].equals("#") || maze[x+1][y] == null){
            return false;
        }else {
            x++;
            path.add("(" + y + "," + x + ")");
            return true;
        }
    }

    public void hugLeft(){
        while(!maze[x][y].equals(maze[49][117])) {
            if (moveLeft()) {
                while (moveLeft()) {
                    moveLeft();
                    System.out.println("moving left");
                }
            }
            if (moveDown()) {
                while (moveDown()) {
                    moveDown();
                    System.out.println("moving down");
                }
            }
            if (moveRight()) {
                while (moveRight()) {
                    moveRight();
                    System.out.println("moving right");
                }
            }
            if (moveUp()) {
                while (moveUp()) {
                    moveUp();
                    System.out.println("moving up");
                }
            }
        }
    }

    public ArrayList<String> getPath() {
        return path;
    }

}
