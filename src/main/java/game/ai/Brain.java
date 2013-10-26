package game.ai;

public class Brain implements IBrain {

	@Override
	public Board getCurrent() {
		Board currentBoard = new Board();
		currentBoard.a1 = "white";
		currentBoard.a4 = "black";
		currentBoard.a7 = null;
		
		currentBoard.b2 = "black";
		currentBoard.b4 = "white";
		currentBoard.b6 = null;
		
		currentBoard.c3 = null;
		currentBoard.c4 = null;
		currentBoard.c5 = "black";
		
		currentBoard.d1 = null;
		currentBoard.d2 = null;
		currentBoard.d3 = null;
		currentBoard.d5 = null;
		currentBoard.d6 = "black";
		currentBoard.d7 = null;
		
		currentBoard.e3 = null;
		currentBoard.e4 = "white";
		currentBoard.e5 = null;
		
		currentBoard.f2 = "white";
		currentBoard.f4 = null;
		currentBoard.f6 = "white";
		
		currentBoard.g1 = "black";
		currentBoard.g4 = "black";
		currentBoard.g7 = null;
		
		return currentBoard;
	}

}
