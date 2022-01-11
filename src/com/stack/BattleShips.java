package com.stack;

public class BattleShips {
    public static int countBattleships(char[][] board) {
        int ships = 0;
        for(int runner = 0; runner < board.length; runner++){
            for(int runnerTwo = 0; runnerTwo < board[0].length; runnerTwo++){
                if(board[runner][runnerTwo] == 'X'){
                    ships++;
                    traceShip(board,runner,runnerTwo);
                }
            }
        }
        
        return ships;
    }
    
    
    
    public static void traceShip(char[][]board,int x ,int y){
        
        if( x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] != 'X'){
            return;
        }
        board[x][y] = ' ';
        traceShip(board,x + 1, y);
        traceShip(board,x , y + 1);
        traceShip(board,x - 1 , y);
        traceShip(board,x , y - 1);
        
    }
	public static void main(String[] args) {
		//char[][] board = [['X','.','.','X'],['.','.','.','X'],['.','.','.','X']]
		
		char[][] array = {{'X','.','.','X'},
				  		  {'.','.','.','X'},
				  		  {'.','.','.','X'},
				  		  };
		System.out.println(countBattleships(array));
	}

}
