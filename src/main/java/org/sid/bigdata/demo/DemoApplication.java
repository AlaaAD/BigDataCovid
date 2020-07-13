package org.sid.bigdata.demo;

import org.sid.bigdata.demo.dao.CovidRepository;
import org.sid.bigdata.demo.entities.Covid;
import org.sid.bigdata.demo.service.CovidService;
import org.sid.bigdata.demo.service.ICovicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements  CommandLineRunner {
    @Autowired
    private CovidRepository covidRepository;

    @Autowired
    private CovidService covidService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Is Run !");
      covidService.aggregate();
    }
}
