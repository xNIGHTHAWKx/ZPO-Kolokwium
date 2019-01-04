import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoadImages images = new LoadImages();

        System.out.println("Wybierz, którego labiryntu scieżkę chcesz otrzymać(1.21x21/2.31x31/3.51x51)");
        Scanner input = new Scanner(System.in);
        int menu = input.nextInt();
        MazeReader mazeReader = null;
        BufferedImage maze = null;
        String outputFilePathName = "";
        int mazeSize = 0;
        switch (menu) {
            case 1: {
                mazeReader = new MazeReader(images.getSmallMaze());
                maze = images.getSmallMaze();
                outputFilePathName = "images/modifiedSmallMaze.png";
                mazeSize = 21;
                break;
            }
            case 2: {
                mazeReader = new MazeReader(images.getMediumMaze());
                maze = images.getMediumMaze();
                outputFilePathName = "images/modifiedMediumMaze.png";
                mazeSize = 31;
                break;
            }
            case 3: {
                mazeReader = new MazeReader(images.getBigMaze());
                maze = images.getBigMaze();
                outputFilePathName = "images/modifiedBigMaze.png";
                mazeSize = 51;
                break;
            }
            default: {
                System.out.println("Nie wybrano żadnej z powyższych opcji. Uruchom program ponownie.");
                System.exit(0);
            }
        }

        MazeWriter mazeWriter = new MazeWriter();

        boolean[][] visited = new boolean[mazeSize][mazeSize];
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                visited[i][j] = false;
            }
        }
        int[] start = mazeReader.getStart();

        PathFinder pathFinder = new PathFinder(mazeReader);
        if (!pathFinder.findPath(visited, start)) try {
            throw new PathNotFoundException();
        } catch (PathNotFoundException e) {
            e.printStackTrace();
        }

        List<Node> nodes = new ArrayList<>(pathFinder.getPath());
        List<Node> helpfulNodes = new ArrayList<>(pathFinder.getPath());
        helpfulNodes.remove(0);

        Graphics2D maze2D = maze.createGraphics();

        for(int i = 0; i < helpfulNodes.size(); i++) {
            mazeWriter.drawStep(maze2D, nodes.get(i).getX(), nodes.get(i).getY(), helpfulNodes.get(i).getX(), helpfulNodes.get(i).getY());
        }

        try {
            ImageIO.write(maze, "png", new File(outputFilePathName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}