import java.awt.*;

public class MazeWriter {
    public void drawStep(Graphics2D graphics2D, int x1, int y1, int x2, int y2) throws WrongCoordinatesException {
        if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) throw new WrongCoordinatesException();
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(x1, y1, x2, y2);
    }
}
