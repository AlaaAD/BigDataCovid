package org.sid.bigdata.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Covid {
    @Id
     String idData;
     String iso_code;
     String continent; // 9arrat
   String location;
    String date;
    double
             total_cases,
             new_cases,
             total_deaths,
             new_deaths;
     String
             total_cases_per_million,
             new_cases_per_million,
             total_deaths_per_million,
             new_deaths_per_million,
             total_tests,
             new_tests,
             total_tests_per_thousand, // total des test bl alaaf des personnes
             new_tests_per_thousand,
             new_tests_smoothed, //
             new_tests_smoothed_per_thousand,
             tests_units,
             stringency_index, //
             population, // nasama
             population_density;
     double
             median_age;// moyen d'age
    String
             aged_65_older,
             aged_70_older,
             gdp_per_capita, //
             extreme_poverty, // fa9r mod9ii3
             cvd_death_rate, // nisma mi2awida dyal lmawt
             diabetes_prevalence, // li fihom diabetes
             female_smokers,
             male_smokers,
             handwashing_facilities, // kayn fin kayghaslo l iddin
             hospital_beds_per_thousand, // les lit dyal les hopiteaux bl alaaf
             life_expectancy; // motawasit l3omr
}
