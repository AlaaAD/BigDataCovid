package org.sid.bigdata.demo.web;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.sid.bigdata.demo.dao.CovidRepository;
import org.sid.bigdata.demo.entities.Covid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UploadController {
    @Autowired
    private CovidRepository covidRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<Covid> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Covid.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<Covid> covids = csvToBean.parse();

                // TODO: save users in DB?
                covidRepository.deleteAll();
                    covidRepository.saveAll(covids);
                // save Covid list on model
                model.addAttribute("covids", covids);
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }
        return "file-upload-status";
    }
    @GetMapping("/nbrCasesPerLocation")
    public String nombresCasesParPays(Model model){
        Map<String,Integer> map = new HashMap<>();
        covidRepository.findAll().forEach(covid -> {
            map.put(covid.getLocation(),Integer.parseInt(covid.getNew_cases()));
        });
       // select pays,count pays from table groupe by pays

     //   model.addAttribute("cinemas",cinemas);

        return "nbrCasesPerLocation";
    }
    @GetMapping("/nbrDeathsPerLocation")
    public String nombresMortsParPays(Model model){

    //    model.addAttribute("cinemas",cinemas);

        return "nbrDeathsPerLocation";
    }
    @GetMapping("/moyenAgePerLocation")
    public String moyenAgeParPays(Model model){

    //    model.addAttribute("cinemas",cinemas);

        return "moyenAgePerLocation";
    }
}
