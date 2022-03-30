package com.termii.visitorslogapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class NewVisitRequest {
    private Long visitorId;
    private Long staffId;
    private Date dateOfVisit;
    private String reasonForVisit;
}
