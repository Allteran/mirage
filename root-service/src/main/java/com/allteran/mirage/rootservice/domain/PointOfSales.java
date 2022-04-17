package com.allteran.mirage.rootservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "point_of_sales")
public class PointOfSales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonDeserialize(using = POSTypeDeserializer.class)
    @JoinColumn(name = "type_id")
    private POSType type;
}
