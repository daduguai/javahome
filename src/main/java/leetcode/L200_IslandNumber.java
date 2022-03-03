package leetcode;

import java.util.Stack;

public class L200_IslandNumber {
    public static int numIslands(char[][] grid) {
        int res=0;
        if(grid==null){
            return res;
        }
        int [][]flag=new int[grid.length][grid[0].length];
        for(int i=0;i<flag.length;i++){
            for(int j=0;j<flag[0].length;j++){
                flag[i][j]=0;
            }
        }
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                Stack<int[]>stack=new Stack<>();
                if(grid[i][j]=='1'&&flag[i][j]==0){
                    res++;
                    stack.push(new int[]{i,j});
                    flag[i][j]=1;
                    while(!stack.isEmpty()){
                        int[]temp=stack.peek();
                        stack.pop();
                        int m=temp[0];
                        int n=temp[1];
                        if(n+1<col&&grid[m][n+1]=='1'&&flag[m][n+1]==0){
                            stack.push(new int[]{m,n+1});
                            flag[m][n+1]=1;
                        }
                        if(n-1>=0&&grid[m][n-1]=='1'&&flag[m][n-1]==0){
                            stack.push(new int[]{m,n-1});
                            flag[m][n-1]=1;
                        }
                        if(m+1<row&&grid[m+1][n]=='1'&&flag[m+1][n]==0){
                            stack.push(new int[]{m+1,n});
                            flag[m+1][n]=1;
                        }
                        if(m-1>=0&&grid[m-1][n]=='1'&&flag[m-1][n]==0){
                            stack.push(new int[]{m-1,n});
                            flag[m-1][n]=1;
                        }
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[]args){
        char[][]grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int res=numIslands(grid);
    }
}
