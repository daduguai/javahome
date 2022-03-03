package leetcode;

import java.util.Stack;

/*统计省份个数*/
public class L547_Province {
    public static  int getProvince(int[][]cities){
        int count=0;
        boolean[] visited=new boolean[cities.length];
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                count++;
                dfs(cities,visited,i);
            }
        }
        return count;
    }

    public static void dfs(int[][]cities,boolean[] visited,int i){
        for(int j=0;j<visited.length;j++){
            if(cities[i][j]==1&&!visited[j]){
                visited[j]=true;
                dfs(cities,visited,j);
            }
        }
    }
    public static void main(String[]args){
        //int[][] data={{1,1,0},{1,1,0},{0,0,1}};
        int[][] data={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int count;
        //boolean[] visited=new boolean[ci];

    }
}
