package game.ai;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.inject.Inject;

@Path("/")
public class NineManMorrisServlet {

	IGson _gson;
	IBrain _boardFactory;
	
	@Inject
	public NineManMorrisServlet(IGson gson, IBrain boardFactory)
	{
		_gson = gson;
		_boardFactory = boardFactory;
	}
	
	@GET
	@Path("board")
	public String retrieveBoard()
	{
		Board currentBoard = _boardFactory.getCurrent();
		return _gson.toJson(currentBoard);
	}

	@POST
	@Path("move")
	public String move(String location)
	{
		Board currentBoard = _boardFactory.getCurrent();
		return _gson.toJson(currentBoard);
	}
}
