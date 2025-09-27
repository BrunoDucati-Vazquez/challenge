package com.kan.challenge.services.Document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kan.challenge.domains.Documents.Document;
import com.kan.challenge.domains.Recipient.Recipient;
import com.kan.challenge.repositories.Document.DocumentRepository;
import com.kan.challenge.repositories.Recipient.RecipientRepository;

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document createDocument(Document document, Integer recipientId) {
        Recipient recipient = recipientRepository.findById(recipientId)
            .orElseThrow(() -> new RuntimeException("Recipient not found"));

        document.setCreatedAt(new java.util.Date());
        document.setUpdatedAt(new java.util.Date()); // Garante que updatedAt não seja preenchido na criação
        document.setRecipient(recipient);
        return documentRepository.save(document);
    }

    public Document updateDocument(Integer id, Document updatedDocument) {
        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        if (updatedDocument.getDocumentType() != null)
            existingDocument.setDocumentType(updatedDocument.getDocumentType());
        if (updatedDocument.getDescription() != null)
            existingDocument.setDescription(updatedDocument.getDescription());

        existingDocument.setUpdatedAt(new java.util.Date());

        return documentRepository.save(existingDocument);
    }

    public Document deleteDocumentByID(Integer id) {
        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        documentRepository.delete(existingDocument);
        return existingDocument;
    }
}
