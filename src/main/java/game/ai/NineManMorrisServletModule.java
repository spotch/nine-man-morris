package game.ai;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class NineManMorrisServletModule extends ServletModule {

	@Override
	protected void configureServlets()
	{
		bind(NineManMorrisServlet.class);
		bind(IGson.class).to(Gson.class);
		bind(IBrain.class).to(Brain.class);
		serve("/*").with(GuiceContainer.class);
	}
}
