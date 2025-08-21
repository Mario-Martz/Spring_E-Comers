package com.spring.ecomers.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Service
public class UploadFileService {

    private static final String FOLDER = "src/main/resources/static/images" + File.separator;

    public String saveImage(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // Asegura que la carpeta exista
            Path folderPath = Paths.get(FOLDER);
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }

            // Usa el nombre original del archivo
            String originalName = file.getOriginalFilename();

            // Reemplaza espacios para evitar problemas en URL y archivos
            String sanitizedFileName = originalName != null
                    ? originalName.replaceAll("\\s+", "_")
                    : "default.jpg";

            Path path = folderPath.resolve(sanitizedFileName);
            Files.write(path, file.getBytes());

            return sanitizedFileName;
        }
        return "default.jpg";
    }

    public void deleteImage(String nombre) {
        try {
            Path path = Paths.get(FOLDER).resolve(nombre);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            System.err.println("Error al eliminar la imagen: " + e.getMessage());
        }
    }
}
