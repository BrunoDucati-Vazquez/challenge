package com.kan.challenge.domains.Recipient;

import java.util.Date;
import java.util.List;

import com.kan.challenge.domains.Documents.Document;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Name;

    private String phone;

    private Date birthDate;

    private Date CreatedAt;

    private Date UpdatedAt;

    @OneToMany(mappedBy = "recipient", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Document> documents;
}
