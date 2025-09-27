package com.kan.challenge.controllers.Recipient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kan.challenge.DTOs.RecipientDTOs.RecipientRequestDTO;
import com.kan.challenge.DTOs.RecipientDTOs.RecipientResponseDTO;
import com.kan.challenge.DTOs.RecipientDTOs.GET.RecipientResponseGETDTO;
import com.kan.challenge.domains.Recipient.Recipient;
import com.kan.challenge.services.Recipient.RecipientService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    @GetMapping("/recipients/{id}")
    // O retorno agora é o DTO de Resposta (GET)
    public ResponseEntity<RecipientResponseGETDTO> getRecipientDetails(@PathVariable Integer id) {
        
        try {
            // 1. Busca o Domain Model completo
            Recipient recipient = recipientService.getRecipientByIDWithAllDocument(id);
            
            // 2. Converte o Domain Model para o DTO de Resposta
            RecipientResponseGETDTO responseDTO = RecipientResponseGETDTO.fromRecipient(recipient);
            
            // 3. Retorna 200 OK
            return ResponseEntity.ok(responseDTO);
            
        } catch (NoSuchElementException e) {
            // 4. Se o Service lançar a exceção, retorna 404 Not Found
            // Em projetos maiores, você usaria um @ControllerAdvice para isso
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/recipients")
    // O retorno agora é o DTO de Resposta (GET)
    public ResponseEntity<List<RecipientResponseGETDTO>> getAllRecipients() {
        
        // 1. O retorno do Service DEVE ser armazenado em uma LISTA.
        List<Recipient> recipients = recipientService.getAllRecipients();
        
        // 2. Converte CADA Recipient da lista para o DTO de Resposta usando Stream e Map
        List<RecipientResponseGETDTO> responseDTOs = recipients.stream()
            // Mapeia cada objeto
            .map(RecipientResponseGETDTO::fromRecipient) 
            .collect(Collectors.toList());

        // 3. Retorna a lista de DTOs
        return ResponseEntity.ok(responseDTOs);
    }
    
    @PostMapping("/recipients")
    public ResponseEntity<RecipientResponseDTO> createRecipient(@RequestBody RecipientRequestDTO requestDTO) {
        
        Recipient recipientToCreate = requestDTO.toRecipientEntity();

        Recipient createdRecipient = recipientService.createRecipient(recipientToCreate);

        RecipientResponseDTO responseDTO = RecipientResponseDTO.fromRecipientEntity(createdRecipient);

        return ResponseEntity.ok(responseDTO);
    }
    
    @PutMapping("recipients/{id}")
    public ResponseEntity<RecipientResponseDTO> updateRecipient(@PathVariable Integer id, @RequestBody RecipientRequestDTO requestDTO) {
        
        Recipient recipientToUpdate = requestDTO.toRecipientEntity();

        Recipient updatedRecipient = recipientService.updateExistingRecipient(id, recipientToUpdate);

        RecipientResponseDTO responseDTO = RecipientResponseDTO.fromRecipientEntity(updatedRecipient);

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("recipients/{id}")
    public ResponseEntity<RecipientResponseDTO> deleteRecipient(@PathVariable Integer id) {
        
        Recipient deletedRecipient = recipientService.deleteRecipientByID(id);

        RecipientResponseDTO responseDTO = RecipientResponseDTO.fromRecipientEntity(deletedRecipient);

        return ResponseEntity.ok(responseDTO);
    }
}