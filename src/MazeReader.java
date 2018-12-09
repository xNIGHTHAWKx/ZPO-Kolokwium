import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class MazeReader {
    public MazeReader(BufferedImage maze) {
        int pixelLength = 14;
        int numberOfVerticalFields = maze.getHeight();
        int numberOfHorizontalFields = maze.getWidth();
        System.out.println(numberOfVerticalFields + ", " + numberOfHorizontalFields);

        byte[] pixels = ((DataBufferByte) maze.getRaster().getDataBuffer()).getData();
        int[][] result = new int[numberOfHorizontalFields][numberOfVerticalFields];

    }
}
