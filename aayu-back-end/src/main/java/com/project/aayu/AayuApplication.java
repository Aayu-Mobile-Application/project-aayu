package com.project.aayu;

import com.project.aayu.Repository.LocationRepository;
import com.project.aayu.database.EnglishPlantDatabaseLoad;
import com.project.aayu.database.MapDatabaseLoad;
import com.project.aayu.model.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AayuApplication {


//	private final LocationRepository locationRepository;
//
//	@Autowired
//	public AayuApplication(LocationRepository locationRepository){
//		this.locationRepository = locationRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(AayuApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		if(locationRepository.findAll().isEmpty()){
//			System.out.println("adding items to the database");
//		}
//
//		Map mapl = new Map(5,"banana",58.225,45.225,"minura");
//		locationRepository.save(mapl);
//
//		for (Map map : locationRepository.findAll()){
//			System.out.println(map);
//		}
//	}
}
