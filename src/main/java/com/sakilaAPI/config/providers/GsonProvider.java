package com.sakilaAPI.config.providers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.MessageBodyWriter;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class GsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {
    // gson
    private final Gson gson = new Gson();

    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public Object readFrom(Class<Object> aClass, Type type, Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> multivaluedMap, InputStream inputStream)
            throws IOException, WebApplicationException {

        try (InputStreamReader is = new InputStreamReader(inputStream, "UTF-8")) {
            return gson.fromJson(is, type);
        } catch (JsonSyntaxException e) {
            System.out.println("Gson parsing error"+e);
        }

        return null;
    }

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(Object o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(Object o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream)
            throws IOException, WebApplicationException {

        try (OutputStreamWriter os = new OutputStreamWriter(outputStream, "UTF-8")) {
            gson.toJson(o, type, os);
        }
    }
}