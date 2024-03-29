package me.masha.parsers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

public class CreationDateSerializer implements JsonSerializer<java.util.Date> {

    /**
     * @param creationDate
     * @param type
     * @param jsonSerializationContext
     * @return
     */
    @Override
    public JsonElement serialize(Date creationDate, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(creationDate.getTime());
    }
}
