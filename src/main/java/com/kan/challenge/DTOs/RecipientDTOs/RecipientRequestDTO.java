package com.kan.challenge.DTOs.RecipientDTOs;

import java.util.Date;

import com.kan.challenge.domains.Recipient.Recipient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientRequestDTO {
    
    private String name;

    private String phone;

    private Date birthDate;
    
   

    public Recipient toRecipientEntity() {
        Recipient recipient = new Recipient();

        
        recipient.setName(this.name); 
        recipient.setPhone(this.phone);
        recipient.setBirthDate(this.birthDate);

        return recipient;
    }
}
