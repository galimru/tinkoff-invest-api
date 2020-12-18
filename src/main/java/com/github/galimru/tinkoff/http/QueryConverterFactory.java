package com.github.galimru.tinkoff.http;

import com.github.galimru.tinkoff.json.market.CandleResolution;
import com.google.gson.annotations.SerializedName;
import retrofit2.Converter;
import retrofit2.Retrofit;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryConverterFactory extends Converter.Factory {

    public static QueryConverterFactory create() {
        return new QueryConverterFactory();
    }

    @Nullable
    @Override
    public Converter<?, String> stringConverter(@Nonnull Type type, @Nonnull Annotation[] annotations, @Nonnull Retrofit retrofit) {
        if (type == Date.class) {
            return DateQueryConverter.INSTANCE;
        } else if (type == CandleResolution.class) {
            return CandleResolutionQueryConverter.INSTANCE;
        }
        return null;
    }

    private static final class DateQueryConverter implements Converter<Date, String> {

        private static final DateQueryConverter INSTANCE = new DateQueryConverter();
        private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        @Override
        public String convert(@Nonnull Date date) {
            return DATE_FORMAT.format(date);
        }
    }

    private static final class CandleResolutionQueryConverter implements Converter<CandleResolution, String> {

        private static final CandleResolutionQueryConverter INSTANCE = new CandleResolutionQueryConverter();

        @Override
        public String convert(@Nonnull CandleResolution resolution) {
            String serializedName = getSerializedName(resolution);
            return serializedName != null
                    ? serializedName
                    : resolution.name();
        }

        private String getSerializedName(CandleResolution resolution) {
            SerializedName serializedName;
            try {
                serializedName = resolution.getClass().getField(resolution.name()).getAnnotation(SerializedName.class);
                if (serializedName != null) {
                    return serializedName.value();
                }
            } catch (NoSuchFieldException e) {
                throw new IllegalStateException("An error occurred while getting annotation from " + resolution);
            }
            return null;
        }
    }
}
