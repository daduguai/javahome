package leetcode;

/*树叶整理成rrryyyrrr*/
public class Lcp19_LeavesSweep {
    static int sweepLeaves(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int count = 0;
        if (ch[0] == 'y') {
            ch[0] = 'r';
            count++;
        }
        if (ch[s.length() - 1] == 'y') {
            ch[s.length() - 1] = 'r';
            count++;
        }
        int yFirstIndex = -1, yLastIndex = -1;
        int yCount = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            if (ch[i] == 'y' && yFirstIndex == -1) {
                yFirstIndex = i;
                yLastIndex = i;
                yCount++;
            } else if (ch[i] == 'y') {
                yLastIndex = i;
                yCount++;
            }
        }
        if (yFirstIndex == -1) {
            count++;
        } else if (yCount > yLastIndex - yFirstIndex + 1 - yCount) {
            count = count + yLastIndex - yFirstIndex + 1 - yCount;
        } else {
            count = count + yCount - 1;
        }
        return count;
    }

    static int sweepLeaves2(String s) {
        int res = 0;
        int[][] f = new int[s.length()][3];
        f[0][0] = s.charAt(0) == 'r' ? 0 : 1;
        f[0][1]=s.length();
        f[0][2]=s.length();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'r') {
                f[i][0] = f[i - 1][0];
                f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + 1;
                f[i][2] = Math.min(f[i - 1][2], f[i - 1][1] );
            } else {
                f[i][0] = f[i - 1][0] + 1;
                f[i][1] = Math.min(f[i - 1][1], f[i - 1][0]);
                f[i][2] = Math.min(f[i - 1][2], f[i - 1][1]) + 1;
            }
        }
        return f[s.length() - 1][2];
    }

    public static void main(String[] args) {
        String s = "yry";
        sweepLeaves2(s);
    }
}
