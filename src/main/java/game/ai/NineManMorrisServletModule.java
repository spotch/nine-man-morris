package game.ai;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class NineManMorrisServletModule extends ServletModule {

	@Override
	protected void configureServlets()
	{
		bind(NineManMorrisServlet.class);
		serve("/*").with(GuiceContainer.class);
	}
}
