package org.sid.bigdata.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LocationByMoyenAge {
   private String continent;
   private String location;
   private double moyenAge;
}
