package org.sid.bigdata.demo.service;

import org.sid.bigdata.demo.dao.CovidRepository;

import org.sid.bigdata.demo.entities.Covid;
import org.sid.bigdata.demo.entities.LocationByCases;
import org.sid.bigdata.demo.entities.LocationByDeaths;
import org.sid.bigdata.demo.entities.LocationByMoyenAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class CovidService implements ICovicService {

    @Autowired
    private  MongoTemplate mongoTemplate;


    @Override
    public List<LocationByCases> aggregationByAllCases() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("continent","location").last("location").as("location")
                        .last("continent").as("continent")
                        .sum("new_cases").as("totaleCases"),
                sort(Sort.Direction.DESC,  "totaleCases")
              );

        AggregationResults<LocationByCases> groupResults = mongoTemplate.aggregate(
                aggregation, Covid.class, LocationByCases.class);

        List<LocationByCases> locationByCases = groupResults.getMappedResults();

        return locationByCases;
    }

    @Override
    public List<LocationByDeaths> aggregationByAllDeaths() {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("continent","location").last("location").as("location")
                        .last("continent").as("continent").
                        sum("new_deaths").as("totaleDeaths"),
                        sort(Sort.Direction.DESC,  "totaleDeaths"));

        AggregationResults<LocationByDeaths> groupResults = mongoTemplate.aggregate(
                aggregation, Covid.class, LocationByDeaths.class);

        List<LocationByDeaths> locationByDeaths = groupResults.getMappedResults();

        return locationByDeaths;
    }

    @Override
    public List<LocationByMoyenAge> aggregationByAllMoyenAge() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("continent","location").last("location").as("location")
                        .last("continent").as("continent")
                        .avg("median_age").as("moyenAge"),
                sort(Sort.Direction.DESC, "moyenAge"));

        AggregationResults<LocationByMoyenAge> groupResults = mongoTemplate.aggregate(
                aggregation, Covid.class, LocationByMoyenAge.class);

        List<LocationByMoyenAge> locationByMoyenAges = groupResults.getMappedResults();

        return locationByMoyenAges;
    }
}
