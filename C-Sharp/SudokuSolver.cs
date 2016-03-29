// Bethy Diakabana
// COMP 3071
// Project 1
using System;

namespace SudokuSolver
{
    class SudokuSolver
    {
        private int[,] sudokuGrid;
        private const int NUMBER_OF_CELLS = 9;
        private const int EMPTY_CELL = 0;

        /// <summary>
        /// intializes a new SudokuSolver object.</summary>
        /// <param name="sudokuGrid">a 9x9 Sudoku grid</param>
        SudokuSolver(int[,] sudokuGrid)
        {
            this.sudokuGrid = sudokuGrid;
        } // end constructor

        ///<summary>Reads a partially filled Sudoku grid and attempts to assigns
        ///values to empy cells while adhering to the rules of Sudoku
        ///(no duplicate numbers across columns, rows, and 3x3 boxes). </summary>
        bool solveSudokuPuzzle(int[,] sudokuGrid)
        {
            int row = 0;
            int column = 0;

            // terminates if all cells are filled
            if (!findEmptyCell(sudokuGrid, ref row, ref column))
                return true; 

            // iterates through each possible value
            for (int i = 1; i <= 9; i++)
            {
                // if the number is allowed in the cell
                if (isSafeToUseCell(sudokuGrid, row, column, i))
                {
                    // adds cell
                    sudokuGrid[row, column] = i;

                    // finished if puzzle is solved
                    if (solveSudokuPuzzle(sudokuGrid))
                        return true;
                    // fills the cell if puzzle isn't solved
                    sudokuGrid[row, column] = EMPTY_CELL;
                }
            }
            // backtracks through method if not solved
            return false; 
        } // end method solveSudokuPuzzle

        ///<summary>
        ///Searches the grid to find a cell that is empty.
        /// If found, the parameters row and column will be set 
        /// to the empty location, and then return true. 
        /// If there are no remaining blank cells, the method returns
        ///false. 
        ///</summary>
        ///<param name="sudokuGrid"> a hard coded 9x9 Sudoku grid></param>
        ///<param name="row"> a row in a Sudoku grid></param>
        ///<param name="column"> a column in a Sudoku grid></param> 
        private bool findEmptyCell(int[,] sudokuGrid, ref int row, ref int column)
        {
            for (row = 0; row < NUMBER_OF_CELLS; row++)
            {
                for (column = 0; column < NUMBER_OF_CELLS; column++)
                {
                    if (sudokuGrid[row, column] == EMPTY_CELL)
                        return true;
                }
            }
            return false;
        } // end method findEmptyCell

        ///<summary>
        /// Returns a boolean indicating if the assigned entry in the
        /// specified row matches the given number.</summary>
        ///<param name="sudokuGrid">a hard coded 9x9 Sudoku grid</param>
        ///<param name="row"> a row in a Sudoku grid</param>
        ///<param name="column"> a column in a Sudoku grid></param> 
        ///<param name="number">The number to be searched in Sudoku grid</param>
        private bool isUsedInRow(int[,] sudokuGrid, int row, int number)
        {
            for (int column = 0; column < NUMBER_OF_CELLS; column++)
            {
                if (sudokuGrid[row, column] == number)
                    return true;
            }
            return false;
        } // end method isUsedInRow

        ///<summary></summary>
        ///Returns a boolean indicating if the assigned entry in the
        ///specified column matches the given number.</summary>
        ///<param name="sudokuGrid">a hard coded 9x9 Sudoku grid</param>
        ///<param name="number">The number to be searched in Sudoku grid</param>
        private bool isUsedInColumn(int[,] sudokuGrid, int column, int number)
        {
            for (int row = 0; row < NUMBER_OF_CELLS; row++)
            {
                if (sudokuGrid[row, column] == number)
                    return true;
            }
            return false;
        } // end method isUsedInColun

        ///<summary>
        ///Returns a boolean indicating if the assigned entry
        ///in the specified 3x3 box matches the given number.</summary>
        ///<param name="sudokuGrid">a hard coded 9x9 Sudoku grid</param>
        ///<param name="boxStartingRow">The starting row of a 3x3 Sudoku box</param>
        ///<param name="boxStartingColumn">The starting column of a 3x3 Sudoku box</param>
        ///<param name="number">The number to be searched in Sudoku grid</param>
        private bool isUsedInBox(int[,] sudokuGrid, int boxStartingRow,
            int boxStartingColumn, int number)
        {
            for (int row = 0; row < 3; row++)
            {
                for (int column = 0; column < 3; column++)
                {
                    if (sudokuGrid[(row + boxStartingRow), (column + boxStartingColumn)] == number)
                        return true;
                }
            }
            return false;
        } // end method isUsedInCell

        ///<summary>
        ///Checks if the number isn't already
        ///in the current row, column, or 3x3 box. 
        ///Returns a boolean indicating if a number
        ///can be placed in the given location </summary>
        ///<param name="row"> a row in a Sudoku grid</param>
        ///<param name="column"> a column in a Sudoku grid></param> 
        ///<param name="number">The number to be searched in Sudoku grid</param>
        private bool isSafeToUseCell(int[,] sudokuGrid, int row,
            int column, int number)
        {
            return !isUsedInRow(sudokuGrid, row, number) &&
                    !isUsedInColumn(sudokuGrid, column, number) &&
                    !isUsedInBox(sudokuGrid, row - row % 3, column - column % 3, number);
        } // end method isSafeToUseCell

        ///<summary>prints a Sudoku grid.</summary>
        public void printSudokuGrid(int[,] sudokuGrid)
        {
            for (int row = 0; row < NUMBER_OF_CELLS; row++)
            {
                for (int column = 0; column < NUMBER_OF_CELLS; column++)
                    Console.Write(sudokuGrid[row, column] + " ");
                Console.WriteLine();
            } // end for
            Console.WriteLine();
        } // end method printGrid

        /* runs Sudoku puzzle */
        static void Main(string[] args)
        {
            int[,] grid = new int[9, 9]
                        {{0, 6, 0, 1, 0, 4, 0, 5, 0},
                         {0, 0, 8, 3, 0, 5, 6, 0, 0},
                         {2, 0, 0, 0, 0, 0, 0, 0, 1},
                         {8, 0, 0, 4, 0, 7, 0, 0, 6},
                         {0, 0, 6, 0, 0, 0, 3, 0, 0},
                         {7, 0, 0, 9, 0, 1, 0, 0, 4},
                         {5, 0, 0, 0, 0, 0, 0, 0, 2},
                         {0, 0, 7, 2, 0, 6, 9, 0, 0},
                         {0, 4, 0, 5, 0, 8, 0, 7, 0}};

            SudokuSolver solver = new SudokuSolver(grid);
            Console.WriteLine("Welcome to the Sudoku Solver!");
            Console.WriteLine("This program takes a hard coded Sudoku puzzle");
            Console.WriteLine("and prints the solution below.");
            Console.WriteLine();

            Console.WriteLine("Unsolved Puzzle");
            Console.WriteLine();
            solver.printSudokuGrid(grid);

            if (solver.solveSudokuPuzzle(grid))
            {
                Console.WriteLine("Solved Puzzle");
                Console.WriteLine();
                solver.printSudokuGrid(grid);
            }
            else
            {
                Console.WriteLine("A solution is not possible.");
            } // end if  
        } // end main
    } // end class SudokuSolver
} // end namespace
