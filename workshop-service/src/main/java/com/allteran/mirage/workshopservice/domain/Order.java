package com.allteran.mirage.workshopservice.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@ToString
@Document("order")
public class Order {
    @Id
    private String id;
    private String deviceName;

    private String typeId;

    private String serialNumber;
    private String defect;
    private String equipSet;
    private String appearance;
    private String warranty;

    private String statusId;

    private String performedActions;

    private LocalDate creationDate;
    private LocalDate issueDate;

    private int preliminaryPrice;
    private int servicePrice;
    private int componentPrice;
    private int marginPrice;
    private int totalPrice;

    private double engineerRate;

    private double directorProfit;
    private double engineerProfit;
    private double managerProfit;

    private String customerName;
    private String customerPhone;

    private String authorId;
    private String engineerId;
}
