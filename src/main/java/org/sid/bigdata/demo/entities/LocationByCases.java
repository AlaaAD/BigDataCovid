package org.sid.bigdata.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocationByCases {
    private String continent;
    private String location;
    private double totaleCases;

}
