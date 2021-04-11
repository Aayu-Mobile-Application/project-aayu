package com.project.aayu;

import com.project.aayu.database.EnglishPlantDatabaseLoad;
import com.project.aayu.database.MapDatabaseLoad;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AayuApplication {

	public static void main(String[] args) {
		SpringApplication.run(AayuApplication.class, args);
	}

}
