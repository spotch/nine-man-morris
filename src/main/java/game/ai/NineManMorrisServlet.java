package game.ai;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.inject.Inject;

@Path("/")
public class NineManMorrisServlet {

	@Inject
	public NineManMorrisServlet()
	{
	}

	@GET
	@Path("board")
	public String retrieveBoard()
	{
		return "current";
	}

	@POST
	@Path("move")
	public String move(String location)
	{
		if (location.equals("valid move"))
			return "new board";
		return "old board";
	}
}
