package org.sid.bigdata.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationByDeaths {
    private String continent;
    private String location;
    private long totaleDeaths;

}
