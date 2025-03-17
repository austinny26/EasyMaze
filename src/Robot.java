
import java.util.ArrayList;

public class Robot {
    private String direction;
    private String[][] maze;
    private int x;
    private int y;
    private ArrayList<String> path = new ArrayList<>();


    public Robot(int x, int y, String[][] maze, String direction){
        this.maze = maze;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public void moveLeft(){
            y--;
            path.add("(" + y + "," + x + ")");
            direction = "West";
    }

    public void moveRight(){
            y++;
            path.add("(" + y + "," + x + ")");
            direction = "East";
    }

    public void moveUp(){
            x--;
            path.add("(" + y + "," + x + ")");
            direction = "North";
    }

    public void moveDown(){
            x++;
            if(!maze[x + 1][y].equals(".")){
                maze[x + 1][y] = "X";
            }
        if(!maze[x + 1][y + 1].equals(".")){
            maze[x + 1][y + 1] = "X";
        }
            path.add("(" + y + "," + x + ")");
            direction = "South";
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

    public boolean isHuggingLeftWall(String direction){
        boolean huggingLeft = false;
        if(direction.equals("South")){
            try {
                if (maze[x + 1][y].equals("X") || maze[x + 1][y - 1].equals("X") || maze[x + 1][y + 1].equals("X")) {
                    huggingLeft = true;
                }
            }catch (ArrayIndexOutOfBoundsException _){

            }
        }

        if(direction.equals("North")){
            if(maze[x][y - 1].equals("X") || maze[x + 1][y - 1].equals("X") || maze[x - 1][y - 1].equals("X")){
                huggingLeft = true;
            }
        }

        if(direction.equals("East")){
            if(maze[x - 1][y].equals("X") || maze[x - 1][y + 1].equals("X") || maze[x - 1][y - 1].equals("X")){
                huggingLeft = true;
            }
        }

        if(direction.equals("West")){
            if(maze[x + 1][y].equals("X") || maze[x + 1][y - 1].equals("X") || maze[x + 1][y + 1].equals("X")){
                huggingLeft = true;
            }
        }
        return huggingLeft;
    }

    public void hugLeft(){
        while(!maze[x][y].equals(maze[49][117])) {

            if(direction.equals("South")) {
                if (canMoveDown()) {
                    while ((canMoveDown()) && (isHuggingLeftWall("South"))) {
                        moveDown();
                        System.out.println("moving down");
                    }
                }
                if(!canMoveDown()){
                    direction = "";
                }
            }

            if (direction.equals("East")){
                if(canMoveRight()){
                    while (canMoveRight()){
                        moveRight();
                        System.out.println("Moving Right");
                    }
                }
                if(!canMoveRight()){
                    direction = "North";
                    System.out.println("Changing North");
                }
            }

            if(direction.equals("North")){
                if(canMoveUp()){
                    while (canMoveUp()){
                        moveUp();
                        System.out.println("Moving up");
                    }
                }
                if(!canMoveUp()){
                    direction = "West";
                    System.out.println("changing left");
                }
            }

            if(direction.equals("West")){
                if(canMoveLeft()){
                    while (canMoveLeft()){
                        moveLeft();
                        System.out.println("Moving left");
                    }
                }
                if(!canMoveLeft()){
                    direction = "South";
                    System.out.println("changing down");
                }
            }

        }
        System.out.println("end of maze");
    }

    public ArrayList<String> getPath() {
        return path;
    }

}
