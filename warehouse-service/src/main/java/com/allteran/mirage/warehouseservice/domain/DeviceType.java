package com.allteran.mirage.warehouseservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "device_type")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
