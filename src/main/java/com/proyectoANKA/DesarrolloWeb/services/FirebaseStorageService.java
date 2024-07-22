
package com.proyectoANKA.DesarrolloWeb.services;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "anka-c5d0c.appspot.com";

    
    final String rutaSuperiorStorage = "Anka";

    
    final String rutaJsonFile = "firebase";

   
    final String archivoJsonFile = "anka-c5d0c-firebase-adminsdk-8m23q-a59d9817f3.json";
}
