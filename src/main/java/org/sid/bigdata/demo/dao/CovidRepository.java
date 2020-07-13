package org.sid.bigdata.demo.dao;

import com.mongodb.client.MongoDatabase;
import org.sid.bigdata.demo.entities.Covid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Map;

@RepositoryRestResource
public interface CovidRepository extends MongoRepository<Covid,String> {

}
