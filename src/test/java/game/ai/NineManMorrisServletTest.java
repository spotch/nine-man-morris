package game.ai;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NineManMorrisServletTest {

	IGson _gson;
	IBrain _boardFactory;
	
	NineManMorrisServlet _testObject;
	
	@Before
	public void setup()
	{
		_gson = mock(IGson.class);
		_boardFactory = mock(IBrain.class);
		
		_testObject = new NineManMorrisServlet(_gson, _boardFactory);
	}
	
	@After
	public void teardown()
	{
		verifyNoMoreInteractions(_gson, _boardFactory);
	}
	
	@Test
	public void retrieveBoard_Returns_Current_Json_Board_State()
	{
		Board deserializedBoard = new Board();
		String serializedBoard = "serialized board";
		
		when(_boardFactory.getCurrent()).thenReturn(deserializedBoard);
		when(_gson.toJson(deserializedBoard)).thenReturn(serializedBoard);
		
		String response = _testObject.retrieveBoard();
		
		verify(_boardFactory).getCurrent();
		verify(_gson).toJson(deserializedBoard);
		
		assertEquals(serializedBoard, response);
	}
}
