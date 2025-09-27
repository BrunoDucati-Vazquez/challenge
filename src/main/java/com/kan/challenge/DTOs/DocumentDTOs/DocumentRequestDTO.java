package com.kan.challenge.DTOs.DocumentDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

import com.kan.challenge.domains.Documents.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequestDTO {
	private String documentType;
	private String description;
	private Date createdAt;
	private Date updatedAt;
	private Integer recipientId;

	public Document toDocumentEntity() {
		Document document = new Document();
		document.setDocumentType(this.documentType);
		document.setDescription(this.description);
		return document;
	}
}
