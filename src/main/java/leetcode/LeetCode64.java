package leetcode;
/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步*/
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int row=grid.length;
        int column=grid[0].length;
        return getPath(grid,row-1,column-1);
    }
    private int getPath(int[][]data,int m,int n){
        if(m==0&&n==0){
            return data[0][0];
        }
        if(m<0||m>(data.length-1)||n<0||(n>data[0].length-1)){
            return -1;
        }
        if(m==0&&(n>=0)){
            return getPath(data,m,n-1)+data[m][n];
        }else if(m>=0&&n==0){
            return getPath(data,m-1,n)+data[m][n];
        }
        int res=Math.min(getPath(data,m-1,n),getPath(data,m,n-1))+data[m][n];
        return res;
    }


    int getPath2(int[][]grid,int row,int col){
        int[][]path=new int[row][col];
        path[0][0]=grid[0][0];
        if(row==0&&col==0){
            return path[0][0];
        }
        if(row==0&&col>0){
            path[row][col]=getPath(grid,row,col-1)+grid[row][col];
        }

        return -1;
    }
}
