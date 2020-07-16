package org.sid.bigdata.demo;

import org.sid.bigdata.demo.dao.CovidRepository;
import org.sid.bigdata.demo.entities.Covid;
import org.sid.bigdata.demo.entities.LocationByDeaths;
import org.sid.bigdata.demo.service.CovidService;
import org.sid.bigdata.demo.service.ICovicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements  CommandLineRunner {


    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private CovidService covidService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Is Run !");
        /*
        Covid covid = new Covid();
        covid.setContinent("Volkswagen");
        covid.setLocation("Polo");
        covid.setNew_deaths(59600);
        this.mongoTemplate.insert(covid, "covid");

*/
        /*
        System.out.println("--------------Resultats ---------------------------");

    List<LocationByDeaths> all = covidService.aggregationByAllDeaths();

        for (LocationByDeaths locationByDeaths : all) {
        System.out.println(locationByDeaths);
    }

         */



}
}
