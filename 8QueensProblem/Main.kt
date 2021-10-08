class EightQueensProblem {
    /**
     * Solves the eight queens problem
     * @return a 2d array containing a solution
     */
    fun solve(): Array<IntArray> {
        // if all queens are placed, return true
        // place queen in first available column
        // mark places rendered invalid by queens placement
        // move ot next row
        val board = Array(8) { IntArray(8) }
        solveRecursively(board, 0)
        return board
    }

    /**
     * Recursive function that uses backtracking to solve the 8 queens problem
     * @param board the board containing the queens (0 open, 1 queen)
     * @param col   the column the function will attempt to place the queen
     * @return true if the queen was placed, false if not
     */
    private fun solveRecursively(board: Array<IntArray>, col: Int): Boolean {
        val n = board.size
        // base case: all queens have been placed
        if (col == n) {
            return true
        }

        // check the row and place the queen in the first available column
        for (row in 0 until n) {
            // place queen. if collision occurs, move queen to next column
            board[row][col] = 1
            // if collision occurs, remove and move to next col
            if (collisionFound(board)) {
                board[row][col] = 0
            } else {
                // if no collision, continue
                if (solveRecursively(board, col + 1)) {
                    return true
                } else {
                    // if solution not found, backtrack
                    board[row][col] = 0
                }
            }
        }
        // could not find a queen to place on this row
        return false
    }

    /**
     * Determines if a collision will occur between any queens on the board
     * @param board the board containing the queens (0 open, 1 queen)
     * @return true if a collision will occur, false if not
     */
    fun collisionFound(board: Array<IntArray>): Boolean {
        val n = board.size
        for (row in 0 until n) {
            for (col in 0 until n) {
                if (board[row][col] == 1) {
                    if (rowCollisionFound(board, row, col) ||
                        columnCollisionFound(board, row, col) ||
                        diagonalCollisionFound(board, row, col)
                    ) {
                        return true
                    }
                }
            }
        }
        return false
    }

    /**
     * Counts the number of queens on the board
     * @param board the board containing the queens (1 = queen)
     * @return the number of queens on the board
     */
    fun numOfQueens(board: Array<IntArray>): Int {
        var sum = 0
        val n = board.size
        for (row in 0 until n) {
            for (col in 0 until n) {
                if (board[row][col] == 1) {
                    sum++
                }
            }
        }
        return sum
    }

    /**
     * Determines if there will be a collision between queens on the row
     * @param board the board containing the queens (0 open, 1 queen)
     * @param row   the row containing the queen being checked
     * @param col   the column containing the queen being checked
     * @return false if the queen doesn't collide, true if she does
     */
    private fun rowCollisionFound(board: Array<IntArray>, row: Int, col: Int): Boolean {
        val n = board.size
        for (a in 0 until n) {
            if (a != col && board[row][a] == 1) {
                return true
            }
        }
        return false
    }

    /**
     * Determines if there will be a collision between queens on the column
     * @param board the board containing the queens (0 open, 1 queen)
     * @param row   the row containing the queen being checked
     * @param col   the column containing the queen being checked
     * @return false if the queen doesn't collide, true if she does
     */
    private fun columnCollisionFound(board: Array<IntArray>, row: Int, col: Int): Boolean {
        val n = board.size
        for (b in 0 until n) {
            if (b != row && board[b][col] == 1) {
                return true
            }
        }
        return false
    }

    /**
     * Determines if there will be a collision between queens on the diagonals
     * @param board the board containing the queens (0 open, 1 queen)
     * @param row   the row containing the queen being checked
     * @param col   the column containing the queen being checked
     * @return false if the queen doesn't collide, true if she does
     */
    private fun diagonalCollisionFound(board: Array<IntArray>, row: Int, col: Int): Boolean {
        val n = board.size
        var i: Int
        var j: Int

        // check northeast diagonal
        i = row - 1
        j = col + 1
        while (i >= 0 && j < n) {
            if (board[i][j] == 1) {
                return true
            }
            i--
            j++
        }

        // check northwest diagonal
        i = row - 1
        j = col - 1
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return true
            }
            i--
            j--
        }

        // check southeast diagonal
        i = row + 1
        j = col + 1
        while (i < n && j < n) {
            if (board[i][j] == 1) {
                return true
            }
            i++
            j++
        }

        // check southwest diagonal
        i = row + 1
        j = col - 1
        while (i < n && j >= 0) {
            if (board[i][j] == 1) {
                return true
            }
            i++
            j--
        }
        return false
    }
}

fun border(){
    println()
    for(i in 0 until 49){
        print("-")
    }
    println()
}

fun main() {
    val eightQueens = EightQueensProblem()
    val solution = eightQueens.solve()
    border()
    for(i in 0 until solution.size){
        print("|  ")
        for(j in 0 until solution.size){
            if(solution[i][j] == 1){
                print(solution[i][j])
                print("  |  ")
            }
            else print("   |  ")
        }
        border()
    }
}