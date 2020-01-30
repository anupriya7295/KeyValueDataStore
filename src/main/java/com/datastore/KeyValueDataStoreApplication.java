package com.datastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.datastore.service.DataStoreService;

@SpringBootApplication
public class KeyValueDataStoreApplication {
	
	public static void main(String[] args) {
		DataStoreService.getDataStore();
		SpringApplication.run(KeyValueDataStoreApplication.class, args);
	}

}
