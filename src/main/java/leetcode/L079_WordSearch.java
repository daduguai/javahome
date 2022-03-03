package leetcode;

import java.util.*;

/*单词是否存在，给定了一个二维字符数组以及指定单词，判断该单词是否存在*/
public class L079_WordSearch {
    static int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//控制方向
    static int row, col;
    static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        if (word.isEmpty()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;

        int[][] flag = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; i < col; j++) {
                flag[i][j] = 0;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && flag[i][j] == 0) {
                    Deque<int[]> queue = new LinkedList();
                    queue.push(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        if (queue.size() == word.length()) {
                            if (queue.toString().equals(word)) {
                                return true;
                            } else {

                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean exist2(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        if (word.isEmpty()) {
            return true;
        }
        char[] ch = word.toCharArray();
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean res= dfs(board, i, j , ch, 0, visited);
                if(res){
                    return res;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int x, int y, char[] ch, int index, boolean[][] visited) {
        if(x<0||x>=row||y<0||y>=col||visited[x][y]){
            return false;
        }
        if (index == ch.length - 1 && board[x][y] == ch[index] && !visited[x][y]) {
            return true;
        }
        if(board[x][y]!=ch[index]){
            return false;
        }
        for (int[] xy : direct) {
            visited[x][y] = true;
            boolean res = dfs(board, x + xy[0], y + xy[1], ch, index + 1, visited);
            visited[x][y] = false;
            if (res) {
                return res;
            }
        }
        return false;
    }
}
