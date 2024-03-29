package me.masha.Parsers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;


public class CreationDateDeserializer implements JsonDeserializer<Long> {

    @Override
    public Long deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Date.parse(jsonElement.getAsJsonPrimitive().getAsString());
    }
}
