import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LoadImages images = new LoadImages();

        MazeReader smallMazeReader = new MazeReader(images.getSmallMaze());
        System.out.println("Small maze: ");
        try {
            System.out.println(smallMazeReader.isEmpty(2, 2));
        } catch (WrongCoordinatesException e) {
            e.printStackTrace();
        }
        System.out.println(smallMazeReader.isWall(5, 6));
        System.out.println(smallMazeReader.isStop(2, 6));
        System.out.println(smallMazeReader.isStop(2, 8));
        System.out.println(smallMazeReader.isStart(18, 6));
        System.out.println(smallMazeReader.isStart(4, 4));

        MazeReader mediumMazeReader = new MazeReader(images.getMediumMaze());
        System.out.println("Medium maze: ");
        System.out.println(mediumMazeReader.isStart(4, 4));
        try {
            System.out.println(mediumMazeReader.isEmpty(10, 9));
        } catch (WrongCoordinatesException e) {
            e.printStackTrace();
        }

        MazeReader bigMazeReader = new MazeReader(images.getBigMaze());

        Graphics2D smallMazeGraphics2D = (images.getSmallMaze()).createGraphics();

        MazeWriter mazeWriter = new MazeWriter();
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

        PathFinder pathFinder = new PathFinder(smallMazeGraphics2D, smallMazeReader.getStartNode(), smallMazeReader.getEndNode());

    }
}