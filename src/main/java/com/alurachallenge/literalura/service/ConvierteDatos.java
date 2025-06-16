package com.alurachallenge.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            JsonNode root = objectMapper.readTree(json);           // 1. Parsear JSON
            JsonNode results = root.path("results");               // 2. Acceder a "results"

            if (!results.isArray() || results.size() == 0) {       // 3. Validar que hay resultados
                throw new RuntimeException("No se encontraron resultados en el JSON.");
            }

            JsonNode primerElemento = results.get(0);              // 4. Obtener el primer objeto
            return objectMapper.treeToValue(primerElemento, clase); // 5. Mapear al tipo T

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al procesar el JSON", e);
        }
    }
}
