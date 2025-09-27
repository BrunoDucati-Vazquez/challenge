package com.kan.challenge.services.Recipient;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kan.challenge.domains.Recipient.Recipient;

import com.kan.challenge.repositories.Recipient.RecipientRepository;

@Service
public class RecipientService {

    @Autowired
    private RecipientRepository recipientRepository;

    public Recipient getRecipientByIDWithAllDocument(Integer id) {
        
        // 1. Chama o Repository, passando o ID
        return recipientRepository.findRecipientByIDWithAllDocument(id)
            // 2. Trata o Optional: se o recipient não for encontrado, lança uma exceção
            .orElseThrow(() -> new NoSuchElementException("Recipient com ID " + id + " não encontrado."));
    }

    public List<Recipient> getAllRecipients() {
        return recipientRepository.findAll();
    }

    public Recipient updateExistingRecipient(Integer id, Recipient updatedRecipient) {
        Recipient existingRecipient = recipientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipient not found"));

        if (updatedRecipient.getName() != null)
            existingRecipient.setName(updatedRecipient.getName());
        if (updatedRecipient.getPhone() != null)
            existingRecipient.setPhone(updatedRecipient.getPhone());
        if (updatedRecipient.getBirthDate() != null)
            existingRecipient.setBirthDate(updatedRecipient.getBirthDate());

        existingRecipient.setUpdatedAt(new java.util.Date());

        return recipientRepository.save(existingRecipient);
    }

    public Recipient createRecipient(Recipient recipient) {
        return recipientRepository.save(recipient);
    }

    public Recipient deleteRecipientByID(Integer id) {
        Recipient existingRecipient = recipientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipient not found"));

        recipientRepository.delete(existingRecipient);
        return existingRecipient;
    }
}
