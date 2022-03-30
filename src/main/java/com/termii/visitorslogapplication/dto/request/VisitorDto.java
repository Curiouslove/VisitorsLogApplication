package com.termii.visitorslogapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDto {
    private String visitorName;

    private String phoneNumber;

    @Email
    private String emailAddress;

    private String address;
}
