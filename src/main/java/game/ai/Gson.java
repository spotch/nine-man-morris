package game.ai;

public class Gson implements IGson {

	@Override
	public String toJson(Object deserializedObject) {
		return new com.google.gson.Gson().toJson(deserializedObject);
	}

}
