import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    private MazeReader mazeReader;
    private List<Node> path;

    public List<Node> getPath() {
        return path;
    }

    public PathFinder(MazeReader mazeReader) {
        this.mazeReader = mazeReader;
        this.path = new ArrayList<>();
    }

    public boolean findPath(boolean[][] visited, int[] current) {
        int x = current[0];
        int y = current[1];

        Node node = new Node(x, y);

        if(visited[x][y]) return false;
        visited[x][y] = true;
        if(mazeReader.isStop(x, y)) return true;
        if(mazeReader.isWall(x, y)) return false;
        path.add(node);

        if(findPath(visited, new int[]{x + 1, y}) == true) return true;
        if(findPath(visited, new int[]{x - 1, y}) == true) return true;
        if(findPath(visited, new int[]{x, y + 1}) == true) return true;
        if(findPath(visited, new int[]{x, y - 1}) == true) return true;

        path.remove(node);
        return false;
    }
}
