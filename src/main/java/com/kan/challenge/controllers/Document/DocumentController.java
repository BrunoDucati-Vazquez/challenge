package com.kan.challenge.controllers.Document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kan.challenge.DTOs.DocumentDTOs.DocumentResponseDTO;
import com.kan.challenge.domains.Documents.Document;
import com.kan.challenge.services.Document.DocumentService;



@RestController
@RequestMapping("/api")
public class DocumentController {
    
    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public ResponseEntity<List<DocumentResponseDTO>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();

        List<DocumentResponseDTO> documentDTOs = documents.stream()
                .map(DocumentResponseDTO::fromDomain)
                .toList();

        return ResponseEntity.ok(documentDTOs);
    }

}
