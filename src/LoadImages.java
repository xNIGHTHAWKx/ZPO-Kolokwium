import javax.imageio.ImageIO;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImages {
    private BufferedImage smallMaze;
    private BufferedImage mediumMaze;
    private BufferedImage bigMaze;

    public BufferedImage getSmallMaze() {
        return this.smallMaze;
    }

    public BufferedImage getMediumMaze() {
        return this.mediumMaze;
    }

    public BufferedImage getBigMaze() {
        return this.bigMaze;
    }

    public LoadImages() {
        File file = new File("images/map_21x21.png");
        try {
            BufferedImage smallMaze = ImageIO.read(file);
            this.smallMaze = smallMaze;
        } catch (IOException e) {
            e.printStackTrace();
        }
        file = new File("images/map_31x31.png");
        try {
            BufferedImage mediumMaze = ImageIO.read(file);
            this.mediumMaze = mediumMaze;
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = new File("images/map_51x51.png");
        try {
            BufferedImage bigMaze = ImageIO.read(file);
            this.bigMaze = bigMaze;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D graphics2D = smallMaze.createGraphics();
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(49, 49, 49, 21);

        try {
            ImageIO.write(smallMaze, "png", new File("images/modified.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
