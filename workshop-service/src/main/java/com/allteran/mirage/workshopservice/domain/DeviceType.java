package com.allteran.mirage.workshopservice.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document("device_type")
public class DeviceType {
    @Id
    private String id;
    private String name;
}
