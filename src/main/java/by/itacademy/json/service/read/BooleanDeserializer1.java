package by.itacademy.json.service.read;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by user on 03.07.2018.
 */
public class BooleanDeserializer1 implements JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return jsonElement.getAsString().equals("здоров");
    }
}