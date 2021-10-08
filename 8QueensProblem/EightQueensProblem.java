package com.mgraca.app;

public class EightQueensProblem 
{
  /**
   * Solves the eight queens problem
   * @return a 2d array containing a solution
   */
  public static int[][] solve(){
    // if all queens are placed, return true
    // place queen in first available column
    // mark places rendered invalid by queens placement
    // move ot next row
    int[][] board = new int[8][8];
    solveRecursively(board, 0);
    return board;
  }

  /**
   * Recursive function that uses backtracking to solve the 8 queens problem
   * @param board the board containing the queens (0 open, 1 queen)
   * @param col   the column the function will attempt to place the queen
   * @return true if the queen was placed, false if not
   */
  private static boolean solveRecursively(int[][] board, int col){
    int n = board.length;
    // base case: all queens have been placed
    if (col == n){
      return true;
    }

    // check the row and place the queen in the first available column
    for (int row = 0; row < n; row++){
      // place queen. if collision occurs, move queen to next column 
      board[row][col] = 1;
      // if collision occurs, remove and move to next col
      if (collisionFound(board)){
        board[row][col] = 0;
      }
      else{
        // if no collision, continue
        if (solveRecursively(board, col+1)){
          return true;
        }
        else{
          // if solution not found, backtrack
          board[row][col] = 0;
        }
      }
    }
    // could not find a queen to place on this row
    return false;
  }

  /**
   * Determines if a collision will occur between any queens on the board
   * @param board the board containing the queens (0 open, 1 queen)
   * @return true if a collision will occur, false if not
   */
  public static boolean collisionFound(int[][] board){
    int n = board.length;
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        if (board[row][col] == 1){
          if (rowCollisionFound(board, row, col) ||
              columnCollisionFound(board, row, col) ||
              diagonalCollisionFound(board, row, col))
          {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Counts the number of queens on the board
   * @param board the board containing the queens (1 = queen)
   * @return the number of queens on the board
   */
  public static int numOfQueens(int[][] board){
    int sum = 0;
    int n = board.length;
    for (int row = 0; row < n; row++){
      for (int col = 0; col < n; col++){
        if (board[row][col] == 1){
          sum++;
        }
      }
    }
    return sum;
  }

  /**
   * Determines if there will be a collision between queens on the row
   * @param board the board containing the queens (0 open, 1 queen)
   * @param row   the row containing the queen being checked
   * @param col   the column containing the queen being checked
   * @return false if the queen doesn't collide, true if she does
   */
  private static boolean rowCollisionFound(int[][] board, int row, int col){
    int n = board.length;
    for (int a = 0; a < n; a++){
      if (a != col && board[row][a] == 1){
        return true;
      }
    }
    return false;
  }

  /**
   * Determines if there will be a collision between queens on the column 
   * @param board the board containing the queens (0 open, 1 queen)
   * @param row   the row containing the queen being checked
   * @param col   the column containing the queen being checked
   * @return false if the queen doesn't collide, true if she does
   */
  private static boolean columnCollisionFound(int[][] board, int row, int col){
    int n = board.length;
    for (int b = 0; b < n; b++){
      if (b != row && board[b][col] == 1){
        return true;
      }
    }
    return false;
  }

  /**
   * Determines if there will be a collision between queens on the diagonals
   * @param board the board containing the queens (0 open, 1 queen)
   * @param row   the row containing the queen being checked
   * @param col   the column containing the queen being checked
   * @return false if the queen doesn't collide, true if she does
   */
  private static boolean diagonalCollisionFound(int[][] board, int row, int col){
    int n = board.length;
    int i, j;

    // check northeast diagonal
    for (i = row-1, j = col+1; i >= 0 && j < n; i--, j++){
      if (board[i][j] == 1){
        return true;
      }
    }

    // check northwest diagonal
    for (i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
      if (board[i][j] == 1){
        return true;
      }
    }

    // check southeast diagonal
    for (i = row+1, j = col+1; i < n && j < n; i++, j++){
      if (board[i][j] == 1){
        return true;
      }
    }

    // check southwest diagonal
    for (i = row+1, j = col-1; i < n && j >= 0; i++, j--){
      if (board[i][j] == 1){
        return true;
      }
    }
    return false;
  }
}
