package org.sid.bigdata.demo.service;

import org.sid.bigdata.demo.entities.LocationByCases;
import org.sid.bigdata.demo.entities.LocationByDeaths;
import org.sid.bigdata.demo.entities.LocationByMoyenAge;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICovicService {
    public List<LocationByCases> aggregationByAllCases();
    public List<LocationByDeaths> aggregationByAllDeaths();
    public List<LocationByMoyenAge> aggregationByAllMoyenAge();


}
