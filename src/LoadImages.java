import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImages {
    private BufferedImage smallMaze;
    private BufferedImage mediumMaze;
    private BufferedImage bigMaze;

    public LoadImages() {
        File file = new File("/home/kamil/DEV/IntelliJ_Projects/ZPO/Kolokwium07.12.18/images/map_21x21.png");
        try {
            BufferedImage smallMaze = ImageIO.read(file);
            this.smallMaze = smallMaze;
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = new File("/home/kamil/DEV/IntelliJ_Projects/ZPO/Kolokwium07.12.18/images/map_31x31.png");
        try {
            BufferedImage mediumMaze = ImageIO.read(file);
            this.mediumMaze = mediumMaze;
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = new File("/home/kamil/DEV/IntelliJ_Projects/ZPO/Kolokwium07.12.18/images/map_51x51.png");
        try {
            BufferedImage bigMaze = ImageIO.read(file);
            this.bigMaze = bigMaze;
        } catch (IOException e) {
            e.printStackTrace();
        }

        MazeReader mazeReader = new MazeReader(smallMaze);
    }
}
