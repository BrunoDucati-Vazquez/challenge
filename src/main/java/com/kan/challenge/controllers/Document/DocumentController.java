package com.kan.challenge.controllers.Document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kan.challenge.DTOs.DocumentDTOs.DocumentRequestDTO;
import com.kan.challenge.DTOs.DocumentDTOs.DocumentResponseDTO;
import com.kan.challenge.domains.Documents.Document;
import com.kan.challenge.services.Document.DocumentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api")
public class DocumentController {
    
    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public ResponseEntity<List<DocumentResponseDTO>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();

        List<DocumentResponseDTO> documentDTOs = documents.stream()
                .map(DocumentResponseDTO::fromDocumentEntity)
                .toList();

        return ResponseEntity.ok(documentDTOs);
    }


    @PostMapping("/documents")
    public ResponseEntity<DocumentResponseDTO> createDocument(@RequestBody DocumentRequestDTO requestDTO) {
        Document documentToCreate = requestDTO.toDocumentEntity();
        Integer recipientId = requestDTO.getRecipientId();
        Document createdDocument = documentService.createDocument(documentToCreate, recipientId);
        DocumentResponseDTO responseDTO = DocumentResponseDTO.fromDocumentEntity(createdDocument);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/documents/{id}")
    public ResponseEntity<DocumentResponseDTO> updateDocument(@PathVariable Integer id, @RequestBody DocumentRequestDTO requestDTO) {
        Document documentToUpdate = requestDTO.toDocumentEntity();
        Document updatedDocument = documentService.updateDocument(id, documentToUpdate);
        DocumentResponseDTO responseDTO = DocumentResponseDTO.fromDocumentEntity(updatedDocument);
        return ResponseEntity.ok(responseDTO);
    }
    
    @DeleteMapping("/documents/{id}")
    public ResponseEntity<DocumentResponseDTO> deleteDocument(@PathVariable Integer id) {
        Document deletedDocument = documentService.deleteDocumentByID(id);
        DocumentResponseDTO responseDTO = DocumentResponseDTO.fromDocumentEntity(deletedDocument);
        return ResponseEntity.ok(responseDTO);
    }
}
