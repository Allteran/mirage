package com.allteran.mirage.workshopservice.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("status")
@Data
@ToString
public class Status {
    @Id
    private String id;
    private String name;

}
