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
public class DocumentResponseDTO {
	private Integer id;
	private String documentType;
	private String description;
	private Date createdAt;
	private Date updatedAt;
	private Integer recipientId;

    public static DocumentResponseDTO fromDocumentEntity(Document document) {
        DocumentResponseDTO dto = new DocumentResponseDTO();
        dto.setId(document.getId());
        dto.setDocumentType(document.getDocumentType());
        dto.setDescription(document.getDescription());
        dto.setCreatedAt(document.getCreatedAt());
        dto.setUpdatedAt(document.getUpdatedAt());
        dto.setRecipientId(document.getRecipient() != null ? document.getRecipient().getId() : null);
        return dto;
    }
}
