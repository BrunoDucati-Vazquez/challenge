package com.kan.challenge.repositories.Recipient;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kan.challenge.domains.Recipient.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Integer> {

    // Query para buscar um Recipient por ID, carregando a coleção de documentos
    @Query("SELECT r FROM Recipient r JOIN FETCH r.documents WHERE r.id = :recipientId")
    Optional<Recipient> findRecipientByIDWithAllDocument(@Param("recipientId") Integer id);
}