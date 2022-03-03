package leetcode;
/*环形区域*/

//深度优先遍历或者广度优先遍历
public class L130_Souroud {
    int row,col;
    public void solve(char[][] board) {
        if(board==null||board.length<3||board[0].length<3){
            return;
        }
        row=board.length;
        col=board[0].length;
        for(int i=0;i<col;i++){
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='A'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][]board,int i,int j){
        if(i<0||i>=row||j<0||j>=col||board[i][j]!='O'){
            return;
        }
        board[i][j]='A';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}
