import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MazeReader {
    public static final String BLACK = "#000000";
    public static final String WHITE = "#ffffff";
    public static final String RED = "#ff0000";
    public static final String GREEN = "#00ff00";
    private String[][] arrayOfColors;
    private List<Node> nodes;
    private Node startNode;
    private Node endNode;

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public MazeReader(BufferedImage maze) {
        int pixelLength = 14;
        int numberOfVerticalFields = maze.getHeight() / pixelLength;
        int numberOfHorizontalFields = maze.getWidth() / pixelLength;
        System.out.println(numberOfVerticalFields + ", " + numberOfHorizontalFields);

        this.arrayOfColors = new String[numberOfHorizontalFields][numberOfVerticalFields];
        this.nodes = new ArrayList<>();

        int horizontalCounter = 1, verticalCounter = 1;
        for (int i = 0; i < numberOfHorizontalFields; i++) {
            for (int j = 0; j < numberOfVerticalFields; j++) {
                int clr = maze.getRGB(horizontalCounter, verticalCounter);
                Color color = new Color(clr, true);
                arrayOfColors[i][j] = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());

                if(arrayOfColors[i][j].equals(BLACK)) nodes.add(new Node(i, j, 'B'));
                if(arrayOfColors[i][j].equals(WHITE)) nodes.add(new Node(i, j, 'W'));
                if(arrayOfColors[i][j].equals(RED)) {
                    Node tmp = new Node(i, j, 'R');
                    nodes.add(tmp);
                    this.startNode = tmp;
                }
                if(arrayOfColors[i][j].equals(GREEN)) {
                    Node tmp = new Node(i, j, 'G');
                    nodes.add(tmp);
                    this.endNode = tmp;
                }

                verticalCounter += pixelLength;
            }
            horizontalCounter += pixelLength;
            verticalCounter = 1;
        }
    }

    public boolean isEmpty(int x, int y) throws WrongCoordinatesException{
        if (x > arrayOfColors.length || y > arrayOfColors.length) throw new WrongCoordinatesException();
        if (arrayOfColors[x-1][y-1].equals(WHITE)) return true;
        else return false;
    }

    public boolean isWall(int x, int y) {
        if (arrayOfColors[x-1][y-1].equals(BLACK)) return true;
        else return false;
    }

    public boolean isStart(int x, int y) {
        if (arrayOfColors[x-1][y-1].equals(RED)) return true;
        else return false;
    }

    public boolean isStop(int x, int y) {
        if(arrayOfColors[x-1][y-1].equals(GREEN)) return true;
        else return false;
    }
}
