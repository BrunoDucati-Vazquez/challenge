package com.kan.challenge.repositories.Recipient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kan.challenge.domains.Recipient.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Integer> {
	
}
