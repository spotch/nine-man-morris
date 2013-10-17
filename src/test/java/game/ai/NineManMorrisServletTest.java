package game.ai;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;

public class NineManMorrisServletTest {

	HttpServer _httpServer;
	URI _baseUri;
	WebResource _webResource;

	@Before
	public void setup() throws IOException
	{
		_baseUri = UriBuilder.fromUri("http://localhost/nine-man-morris/").port(9998).build();
		Injector injector = Guice.createInjector();
		ResourceConfig resourceConfig = new PackagesResourceConfig( "game.ai" );
		IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory( resourceConfig, injector );
		_httpServer = GrizzlyServerFactory.createHttpServer(_baseUri, resourceConfig, ioc );

		Client client = Client.create(new DefaultClientConfig());
		_webResource = client.resource(_baseUri);
	}

	@After
	public void teardown()
	{
		_httpServer.stop();
	}

	@Test
	public void retrieveBoard_Retrieves_A_Board()
	{
		ClientResponse clientResponse = _webResource.path("board").get(ClientResponse.class);

		String textResponse = clientResponse.getEntity(String.class);

		assertEquals(200, clientResponse.getStatus());
		assertEquals("current", textResponse);
	}

	@Test
	public void move_Takes_A_Move_And_Returns_New_Board_State_If_Move_Is_Valid()
	{
		ClientResponse clientResponse = _webResource.path("move").post(ClientResponse.class, "valid move");

		String textResponse = clientResponse.getEntity(String.class);

		assertEquals(200, clientResponse.getStatus());
		assertEquals("new board", textResponse);
	}

	@Test
	public void move_Takes_A_Move_And_Returns_Old_Board_State_If_Move_Is_Invalid()
	{
		ClientResponse clientResponse = _webResource.path("move").post(ClientResponse.class, "invalid move");

		String textResponse = clientResponse.getEntity(String.class);

		assertEquals(200, clientResponse.getStatus());
		assertEquals("old board", textResponse);
	}
}
