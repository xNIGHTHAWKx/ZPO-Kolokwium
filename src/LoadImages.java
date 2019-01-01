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

        MazeReader mazeReader = new MazeReader(smallMaze);

        System.out.println("Small maze: ");
        System.out.println(mazeReader.isEmpty(2, 2));
        System.out.println(mazeReader.isWall(5, 6));
        System.out.println(mazeReader.isStop(2, 6));
        System.out.println(mazeReader.isStop(2, 8));
        System.out.println(mazeReader.isStart(18, 6));
        System.out.println(mazeReader.isStart(4, 4));

        MazeReader mazeReader2 = new MazeReader(mediumMaze);

        System.out.println("Medium maze: ");
        System.out.println(mazeReader2.isStart(4, 4));
        System.out.println(mazeReader2.isEmpty(10, 9));

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
