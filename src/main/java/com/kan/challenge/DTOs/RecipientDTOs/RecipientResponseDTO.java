package com.kan.challenge.DTOs.RecipientDTOs;



import java.util.Date;


import com.kan.challenge.domains.Recipient.Recipient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipientResponseDTO {

    private Integer id;

    private String name; 

    private String phone;

    private Date birthDate;

    public static RecipientResponseDTO fromRecipientEntity(Recipient recipient) {
        RecipientResponseDTO dto = new RecipientResponseDTO();
        
        dto.setId(recipient.getId());
        dto.setName(recipient.getName()); 
        dto.setPhone(recipient.getPhone());
        dto.setBirthDate(recipient.getBirthDate());

        return dto;
    }
}
