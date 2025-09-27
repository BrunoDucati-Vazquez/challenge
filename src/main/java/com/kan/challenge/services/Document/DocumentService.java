package com.kan.challenge.services.Document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kan.challenge.domains.Documents.Document;
import com.kan.challenge.repositories.Document.DocumentRepository;

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
}
