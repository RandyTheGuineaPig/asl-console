package asl.util;

import asl.dto.ConfigurationVector;
import asl.exceptions.ConfigurationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by sengir on 14.05.16.
 */
public class JsonBuilder {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String prepareJson(final Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "Oops, something went terribly wong!";
        }
    }

    public static ConfigurationVector prepareConfigurationVector(final String json) throws ConfigurationException {
        final JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(json);
            return objectMapper.treeToValue(jsonNode, ConfigurationVector.class);
        } catch (IOException e) {
            throw new ConfigurationException("Could not create ConfigurationVector from provided JSON: provided JSON is invalid");
        }
    }
}
