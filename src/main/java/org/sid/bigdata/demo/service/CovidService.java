package org.sid.bigdata.demo.service;

import org.sid.bigdata.demo.dao.CovidRepository;

import org.sid.bigdata.demo.entities.Covid;
import org.sid.bigdata.demo.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@Service
public class CovidService implements ICovicService {

    @Autowired
    private CovidRepository covidRepository;
    private final MongoTemplate mongoTemplate;
    @Autowired
    public CovidService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Location> aggregate() {
        GroupOperation groupOperation = getGroupOperation();
        ProjectionOperation projectionOperation = getProjectOperation();

        return mongoTemplate.aggregate(Aggregation.newAggregation(
                groupOperation,
                projectionOperation
        ), Covid.class, Location.class).getMappedResults();
    }

    private GroupOperation getGroupOperation() {
        return group("location")
                .last("location").as("location")
               // .avg("price").as("averagePrice")
                .sum("new_cases").as("totaleCases")
                .sum("new_deaths").as("totalDeaths");
    }
    private ProjectionOperation getProjectOperation() {
        return Aggregation.project("totaleCases", "totalDeaths")
                .and("location").previousOperation();
    }

}
