package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Product;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class JSONDataUtil {
    public static List<Product> getProductCatalog() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File("src/test/java/data/product-catalog.json");
            if (!file.exists()) {
                System.err.println("Error: Data file not found at " + file.getAbsolutePath());
                return Collections.emptyList();
            }
            return objectMapper.readValue(file, new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            System.err.println("Error reading product catalog data: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
