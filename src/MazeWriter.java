import java.awt.*;

public class MazeWriter {
    public void drawStep(Graphics2D graphics2D, int x1, int y1, int x2, int y2) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine((x1 * 14 + 7), (y1 * 14 + 7), (x2 *14 + 7), (y2 * 14 + 7));
    }
}
