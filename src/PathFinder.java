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

    public boolean findPath(int[][] map, boolean[][] visited, int[] current, int[] end) {
        int x = current[0];
        int y = current[1];
        visited[current[0]][current[1]] = true;

        if(current[0] == end[0] && current[1] == end[1]) return true;

        if(visited[current[0]+1][current[1]] == false) {
            if (!mazeReader.isWall(current[0] + 1, current[1]))
                findPath(map, visited, new int[]{x + 1, y}, end);
        }

        if(visited[current[0]-1][current[1]] == false) {
            if (!mazeReader.isWall(current[0] - 1, current[1]))
                findPath(map, visited, new int[]{x - 1, y}, end);
        }

        if(visited[current[0]][current[1]+1] == false) {
            if (!mazeReader.isWall(current[0], current[1] + 1))
                findPath(map, visited, new int[]{x, y + 1}, end);
        }

        if(visited[current[0]][current[1]-1] == false) {
            if (!mazeReader.isWall(current[0], current[1] - 1))
                findPath(map, visited, new int[]{x, y - 1}, end);
        }

        return false;
    }
}
