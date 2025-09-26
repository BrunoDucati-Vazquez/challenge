package com.kan.challenge.domains.Documents;

import java.util.Date;

import com.kan.challenge.domains.Recipient.Recipient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "documents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String DocumentType;

    private String Description;

    private Date CreatedAt;

    private Date UpdatedAt;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;
}
