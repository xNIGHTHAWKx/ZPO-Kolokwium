import java.awt.*;
import java.awt.image.BufferedImage;

public class MazeReader {
    public static final String BLACK = "#000000";
    public static final String WHITE = "#ffffff";
    public static final String RED = "#ff0000";
    public static final String GREEN = "#00ff00";
    private String[][] arrayOfColors;
    int[] start;
    int[] stop;

    public int[] getStart() {
        return start;
    }

    public int[] getStop() {
        return stop;
    }

    public MazeReader(BufferedImage maze) {
        int pixelLength = 14;
        int numberOfVerticalFields = maze.getHeight() / pixelLength;
        int numberOfHorizontalFields = maze.getWidth() / pixelLength;
        System.out.println(numberOfVerticalFields + ", " + numberOfHorizontalFields);
        this.start = new int[2];
        this.stop = new int[2];

        this.arrayOfColors = new String[numberOfHorizontalFields][numberOfVerticalFields];

        int horizontalCounter = 1, verticalCounter = 1;
        for (int i = 0; i < numberOfHorizontalFields; i++) {
            for (int j = 0; j < numberOfVerticalFields; j++) {
                int clr = maze.getRGB(horizontalCounter, verticalCounter);
                Color color = new Color(clr, true);
                arrayOfColors[i][j] = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());

                if (arrayOfColors[i][j].equals(RED)) {
                    this.start[0] = i;
                    this.start[1] = j;
                }

                if (arrayOfColors[i][j].equals(GREEN)) {
                    this.stop[0] = i;
                    this.stop[1] = j;
                }

                    verticalCounter += pixelLength;
                }
                horizontalCounter += pixelLength;
                verticalCounter = 1;
            }
        }

    public boolean isEmpty(int x, int y) {
        if (arrayOfColors[x][y].equals(WHITE)) return true;
        else return false;
    }

    public boolean isWall(int x, int y) {
        if (arrayOfColors[x][y].equals(BLACK)) return true;
        else return false;
    }

    public boolean isStart(int x, int y) {
        if (arrayOfColors[x][y].equals(RED)) return true;
        else return false;
    }

    public boolean isStop(int x, int y) {
        if(arrayOfColors[x][y].equals(GREEN)) return true;
        else return false;
    }
}
