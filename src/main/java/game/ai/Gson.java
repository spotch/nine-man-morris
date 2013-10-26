package game.ai;

public class Gson implements IGson {

	com.google.gson.Gson _gson;
	
	public Gson() {
		_gson = new com.google.gson.GsonBuilder().serializeNulls().create();
	}
	
	@Override
	public String toJson(Object deserializedObject) {
		return _gson.toJson(deserializedObject);
	}

}
