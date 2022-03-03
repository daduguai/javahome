package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L1091_ShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null){
            return -1;
        }
        int len=grid.length;
        if(grid[0][0]==1||grid[len-1][len-1]==1){
            return -1;
        }else if(len<=2){
            return len;
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        int[]dx={0,0,1,-1,1,-1,1,-1};
        int[]dy={1,-1,0,0,1,-1,-1,1};
        while(!queue.isEmpty()){
            int[]temp=queue.poll();
            int m=temp[0];
            int n=temp[1];
            int l=temp[2];
            for(int i=0;i<8;i++){
                int x=m+dx[i];
                int y=n+dy[i];
                if(x>=0&&y>=0&&x<len&&y<len&&grid[x][y]==0){
                    grid[x][y]=1;
                    if(x==len-1&&y==len-1){
                        return l+1;
                    }else{
                        queue.offer(new int[]{x,y,l+1});
                    }
                }
            }

        }

        return -1;
    }


}
