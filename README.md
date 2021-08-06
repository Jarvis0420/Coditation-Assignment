# Coditation-Assignment
Imagine an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, live or dead. Every cell interacts with its eight neighbors, which are the cells that are directly horizontally, vertically, or diagonally adjacent.

At each step in time (tick), the following transitions occur:
Any live cell with fewer than two live neighbors dies, as if by loneliness.
Any live cell with more than three live neighbors dies, as if by overcrowding.
Any live cell with two or three live neighbors lives, unchanged, to the next generation.
Any dead cell with exactly three live neighbors comes to life. The initial pattern constitutes the 'seed' (randomly placed 500 cells) of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed — births and deaths happen simultaneously, and the discrete moment at which this happens is called a tick. (In other words, each generation is a pure function of the one before.)
Write a program in the language(s) of your choice with following guidelines:
Accept a user input of new cells (max 100 at every step/tick) to be placed; each cell should have a unique name which is to be accepted by the user. This input can be accepted through a CLI or HTML element or any other form of user interface
Acceptance of the user input represents a tick and program is expected to calculate the state of every cell
The program should output the state of the cells and changes - representation (UI/CLI et al.) of the state of the cells can be decided by the developer
The program should provide a way to search by the name of the cell and show the current state of the cell
The program should end on termination through appropriate OS specific signals
