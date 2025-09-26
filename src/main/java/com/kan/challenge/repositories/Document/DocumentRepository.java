package com.kan.challenge.repositories.Document;

import com.kan.challenge.domains.Documents.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
	
}
