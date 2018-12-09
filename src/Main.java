public class Main {
    public static void main(String[] args) {
        LoadImages images = new LoadImages();
    }
}

//do wczytywania/modyfikacji obrazu skorzystaj z paczki klas File, BufferedImage, Graphics2D, ImageIO.read, getHeigh/getWidth, getRGB
//set RGB (dla obrazu BufferedImage). W programie utwórz oraz wykorzystaj czytnik labiryntu w postaci obrazkowej - klasę MazeReader, która
//udostępnia metody isEmpty, isWall, isStart, isStop zorientowane na współrzędne polowe a nie pikselowe. MazeWriter udostępnia metodę
//drawStep rysującą element ścieżki w postaci linii.