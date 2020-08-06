package com.rubenskj.config.provider;

import com.rubenskj.config.codec.DocumentCodec;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentCodecProvider implements CodecProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentCodecProvider.class);

    @Override
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry codecRegistry) {
        LOGGER.info("Getting CodecProvider");
        return new DocumentCodec<>(clazz);
    }
}
