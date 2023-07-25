import java.util.ArrayList;

class RatInAMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
    ArrayList < String > ans = new ArrayList < > ();
    if (m[0][0] == 1) solve(0, 0, m, n, ans, "");
    return ans;
    }
    
    private static void solve(int i, int j, int[][] maze, int n, ArrayList<String> ans, String move){
        if(i == n-1 && j == n-1){
            ans.add(move);
            return;
        }
        else if(i < n-1 && j < n-1){
            if(maze[i+1][j] == 1){
                solve(i + 1, j, maze,n, ans, move+"D");
            } if(maze[i][j+1] == 1){
                solve(i , j+1, maze,n, ans, move+"R");
            }
        }else if(i == n-1 && j < n-1 && maze[i][j+1] == 1){
             solve(i , j+1, maze,n, ans, move+"R");
        }else if(i < n-1 && j == n-1 && maze[i+1][j] == 1){
             solve(i + 1, j, maze,n, ans, move+"D");
        }
        
        return;
    }
    
}