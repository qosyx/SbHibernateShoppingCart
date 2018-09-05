package org.o7planning.SbHibernateShoppingCart.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public final class PackedJsonTypeAdapterFactory
        implements TypeAdapterFactory {

    // Gson can instantiate this itself
    private PackedJsonTypeAdapterFactory() {
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        @SuppressWarnings("unchecked")
        final TypeAdapter<T> typeAdapter = (TypeAdapter<T>) new PackedJsonTypeAdapter(gson);
        return typeAdapter;
    }

    private static final class PackedJsonTypeAdapter extends TypeAdapter<String> {

        private final Gson gson;

        private PackedJsonTypeAdapter(final Gson gson) {
            this.gson = gson;
        }

        @Override
        public void write(final JsonWriter out, final String json) {
            final JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
            gson.toJson(jsonElement, out);
        }

        @Override
        public String read(final JsonReader in) {
            final JsonElement jsonElement = gson.fromJson(in, JsonElement.class);
            return jsonElement != null ? jsonElement.toString() : null;
        }

    }

}