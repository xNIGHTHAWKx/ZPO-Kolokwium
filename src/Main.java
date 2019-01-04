import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LoadImages images = new LoadImages();

        MazeReader smallMazeReader = new MazeReader(images.getSmallMaze());

        Graphics2D smallMazeGraphics2D = (images.getSmallMaze()).createGraphics();

        MazeWriter mazeWriter = new MazeWriter();

        int[][] map = new int[21][21];
        boolean[][] visited = new boolean[21][21];
        for(int i = 0; i < 21; i++) {
            for(int j = 0; j < 21; j++) {
                visited[i][j] = false;
            }
        }
        int[] start = smallMazeReader.getStart();
        int[] stop = smallMazeReader.getStop();

        PathFinder pathFinder = new PathFinder(smallMazeReader);
        System.out.println(pathFinder.findPath(map, visited, start, stop));

        try {
            mazeWriter.drawStep(smallMazeGraphics2D, 49, 49, 49, 21);
            mazeWriter.drawStep(smallMazeGraphics2D, 49, 21, 21, 21);
            mazeWriter.drawStep(smallMazeGraphics2D, 21, 21, 21, 28);
        } catch (WrongCoordinatesException e) {
            e.printStackTrace();
        }

        try {
            ImageIO.write(images.getSmallMaze(), "png", new File("images/modified.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(pathFinder.getPath());

    }
}