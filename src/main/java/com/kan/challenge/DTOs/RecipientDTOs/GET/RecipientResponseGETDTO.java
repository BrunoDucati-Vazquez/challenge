package com.kan.challenge.DTOs.RecipientDTOs.GET;

import com.kan.challenge.DTOs.DocumentDTOs.DocumentResponseDTO; // Importe seu DTO de Documento
import com.kan.challenge.domains.Recipient.Recipient;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class RecipientResponseGETDTO {
    
    // NOTA: O ID FOI EXCLUÍDO AQUI, conforme sua requisição.
    
    private String name;
    private String phone;
    private Date birthDate;
    
    // Lista de documentos associados (o objeto aninhado)
    private List<DocumentResponseDTO> documents; // Lista de DTOs, não Entities

    // Método de Mapeamento: Domain Model -> DTO
    public static RecipientResponseGETDTO fromRecipient(Recipient recipient) {
        RecipientResponseGETDTO dto = new RecipientResponseGETDTO();
        
        // Mapeamento dos campos de Recipient (exceto ID)
        dto.setName(recipient.getName());
        dto.setPhone(recipient.getPhone());
        dto.setBirthDate(recipient.getBirthDate());
        
        // Mapeamento ANINHADO da lista de Documents:
        if (recipient.getDocuments() != null) {
            // Converte cada Document (Entity) para DocumentResponseDTO
            List<DocumentResponseDTO> documentDTOs = recipient.getDocuments().stream()
                .map(DocumentResponseDTO::fromDocumentEntity) // Use o método estático do seu DTO de Documento
                .collect(Collectors.toList());
                
            dto.setDocuments(documentDTOs);
        } else {
            dto.setDocuments(List.of()); // Retorna lista vazia se não houver documentos
        }
        
        return dto;
    }
}