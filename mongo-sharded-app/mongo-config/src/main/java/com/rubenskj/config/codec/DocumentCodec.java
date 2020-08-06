package com.rubenskj.config.codec;

import com.mongodb.MongoClientSettings;
import com.rubenskj.config.exception.DocumentCodecException;
import org.bson.*;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.lang.reflect.Field;
import java.util.UUID;

public class DocumentCodec<T, K> implements CollectibleCodec<T> {

    private final Codec<Document> documentCodec;
    private final Class<T> clazz;

    public DocumentCodec(Class<T> clazz) {
        this.clazz = clazz;
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter bsonWriter, T t, EncoderContext encoderContext) {
        System.out.println("Encoding");
    }

    @Override
    public Class<T> getEncoderClass() {
        System.out.println("Class by Constructor" + clazz.getName());
        System.out.println("Casted Class: " + getClass().getComponentType().getName());
        return (Class<T>) getClass().getComponentType();
    }

    @Override
    public T generateIdIfAbsentFromDocument(T t) {
        if (!documentHasId(t)) {
            K id = getObjectDocumentId(t);

            id = (K) UUID.randomUUID().toString();
        }
        return t;
    }

    @Override
    public boolean documentHasId(T t) {
        K id = this.getObjectDocumentId(t);

        return id != null;
    }

    @Override
    public BsonValue getDocumentId(T t) {
        return new BsonString(getObjectDocumentId(t).toString());
    }

    @Override
    public T decode(BsonReader bsonReader, DecoderContext decoderContext) {
        System.out.println("Decoding");
        return null;
    }

    private K getObjectDocumentId(T t) {
        Class<?> clazz = t.getClass();

        Field fieldId = this.getFieldId(clazz);

        return this.getId(fieldId, clazz);
    }

    private Field getFieldId(Class<?> clazz) {
        try {
            Field id = clazz.getField("id");

            return id;
        } catch (NoSuchFieldException e) {
            throw new DocumentCodecException("Document hasn't field called 'id'.");
        }
    }

    private K getId(Field fieldId, Class<?> clazz) {
        try {
            fieldId.setAccessible(true);

            Object id = fieldId.get(clazz);

            fieldId.setAccessible(false);

            return (K) id;
        } catch (IllegalAccessException e) {
            throw new DocumentCodecException("Cannot get id from document.");
        }
    }
}
