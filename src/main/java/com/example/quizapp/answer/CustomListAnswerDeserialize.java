package com.example.quizapp.answer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomListAnswerDeserialize extends StdDeserializer<List<AnswerDTO>> {

    public CustomListAnswerDeserialize() {
        this(null);
    }

    protected CustomListAnswerDeserialize(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<AnswerDTO> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return new ArrayList<>();
    }
}
