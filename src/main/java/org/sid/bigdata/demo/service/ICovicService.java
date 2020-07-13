package org.sid.bigdata.demo.service;

import org.sid.bigdata.demo.entities.Location;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICovicService {

    public List<Location> aggregate();
}
