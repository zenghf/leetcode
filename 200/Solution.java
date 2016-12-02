import java.util.HashSet;

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        int[] id = new int[height * width];

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int v = y * width + x;
                if (grid[y][x] == '1')
                    id[v] = v;
                else
                    id[v] = -1;
            }
        }

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                if (grid[y][x] == '1'){
                    int v = y * width + x;
                    if (x > 0 && grid[y][x - 1] == '1')
                        unite(id, v, v - 1);
                    if (y > 0 && grid[y - 1][x] == '1')
                        unite(id, v, v - width);
                }
            }
        }

        for (int i = 0; i < height * width; i++)
            if (id[i] != -1)
                id[i] = root(id, i);

        HashSet<Integer> roots = new HashSet<>();
        for (int i = 0; i < height * width; i++)
            if (id[i] != -1)
                roots.add(id[i]);

        return roots.size();
    }

    private int root(int[] id, int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private void unite(int[] id, int p, int q){
        int i = root(id, p);
        int j = root(id, q);
        id[i] = j;
    }
}