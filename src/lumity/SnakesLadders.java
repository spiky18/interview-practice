package lumity;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SnakesLadders {
  int[] board;

  public void createBoard(int n, int[][] snakes, int[][] ladders) {
    board = new int[n];
    for (int[] i : snakes) {
      board[i[0] - 1] = i[1] - 1;
    }
    for (int[] i : ladders) {
      board[i[0] - 1] = i[1] - 1;
    }
    System.out.println(Arrays.toString(board));
  }

  public int minMoves() {
    int[] moves = new int[board.length];
    Arrays.fill(moves, -1);
    moves[0] = 0;
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    while (!queue.isEmpty()) {
      int index = queue.poll();
      for (int i = 1; i <= 6; i++) {
        if (index + i < moves.length && moves[index + i] == -1) {
          moves[index + i] = moves[index] + 1;
          if (board[index + i] == 0) {
            queue.add(index + i);
          } else if (board[index + i] > 0) {
            if (moves[board[index + i]] == -1) {
              moves[board[index + i]] = moves[index + i];
              queue.add(board[index + i]);
            }
          }
        }
      }
    }
    System.out.println(Arrays.toString(moves));
    return moves[moves.length - 1];
  }

  public static void main(String[] args) {
    SnakesLadders s = new SnakesLadders();
    s.createBoard(30, new int[][] {{27, 1}, {21, 9}, {17, 4}, {19, 7}},
        new int[][] {{3, 22}, {5, 8}, {11, 26}, {20, 29}});
    System.out.println(s.minMoves());
    s.createBoard(36, new int[][] {{34, 12}, {32, 30}, {24, 16}, {20, 6}, {17, 4}},
        new int[][] {{2, 15}, {5, 7}, {9, 27}, {18, 29}, {25, 35}});
    System.out.println(s.minMoves());
  }
}