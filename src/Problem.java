import java.util.Scanner;

public class Problem {
	 static int max = 0;

	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int steps = sc.nextInt();
	    int x1 = sc.nextInt();
	    int y1 = sc.nextInt();
	    int x2 = sc.nextInt();
	    int y2 = sc.nextInt();
	    Point start = new Point(x1, y1);
	    Point end = new Point(x2, y2);
	    int[][] matrix = new int[n][m];
	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < m; j++) {
	        matrix[i][j] = sc.nextInt();
	      }
	    }
	    boolean[][] visited = new boolean[n][m];
	    visited[start.x][start.y] = true;
	    bfs(start, end, steps, matrix[start.x][start.y], matrix, visited);
	    System.out.println(max);
	    sc.close();
	  }

	  private static void bfs(Point start, Point end, int steps, int sum, int[][] matrix,
	      boolean[][] visited) {
	    if (start.equals(end)) {
	      if (max < sum) {
	        max = sum;
	        return;
	      }
	    }
	    if (steps > 0) {
	      int currentX = start.x - 1;
	      int currentY = start.y;
	      if (start.x > 0 && !visited[currentX][currentY]) {
	        boolean[][] newVisited = new boolean[visited.length][visited[0].length];
	        arrayCopy(newVisited, visited);
	        newVisited[currentX][currentY] = true;
	        bfs(new Point(currentX, currentY), end, steps - 1, sum + matrix[currentX][currentY],
	            matrix, newVisited);
	      }
	      currentX = start.x + 1;
	      if (start.x < matrix.length - 1 && !visited[currentX][currentY]) {
	        boolean[][] newVisited = new boolean[visited.length][visited[0].length];
	        arrayCopy(newVisited, visited);
	        newVisited[currentX][currentY] = true;
	        bfs(new Point(currentX, currentY), end, steps - 1, sum + matrix[currentX][currentY],
	            matrix, newVisited);
	      }
	      currentX = start.x;
	      currentY = start.y - 1;
	      if (start.y > 0 && !visited[currentX][currentY]) {
	        boolean[][] newVisited = new boolean[visited.length][visited[0].length];
	        arrayCopy(newVisited, visited);
	        newVisited[currentX][currentY] = true;
	        bfs(new Point(currentX, currentY), end, steps - 1, sum + matrix[currentX][currentY],
	            matrix, newVisited);
	      }
	      currentY = start.y + 1;
	      if (start.y < matrix[0].length - 1 && !visited[currentX][currentY]) {
	        boolean[][] newVisited = new boolean[visited.length][visited[0].length];
	        arrayCopy(newVisited, visited);
	        newVisited[currentX][currentY] = true;
	        bfs(new Point(currentX, currentY), end, steps - 1, sum + matrix[currentX][currentY],
	            matrix, newVisited);
	      }
	    }
	  }

	  private static void arrayCopy(boolean[][] result, boolean[][] original) {
	    for (int i = 0; i < result.length; i++) {
	      for (int j = 0; j < result[0].length; j++) {
	        result[i][j] = original[i][j];
	      }
	    }
	  }
	}

class Point{
	int x;
	int y;
	
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
}

