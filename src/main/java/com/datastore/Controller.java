package com.datastore;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastore.service.DataStoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@RestController
@RequestMapping("/datastore")
@SwaggerDefinition(info = @Info(title = "Datastore API", version = "v1.0", description = "Datastore API Endpoints"))
@Api(value = "Datastore", tags = "API's related to Data store")
public class Controller {

	@GetMapping(value = "/ping")
	public String ping() {
		return "Controller -- pinged at " + System.currentTimeMillis();
	}

	@ApiOperation(value = "Create key value pair in data store", response = Object.class, tags = "Create key-value in datastore")
	@PostMapping("/create/{key}")
	public Object create(@ApiParam(value = "key", required = true) @PathVariable(required = true) String key,
			@ApiParam(value = "expiry in seconds", required = false, defaultValue = "-1", example = "-1") @RequestParam(required = false) int expiry,
			@ApiParam(value = "value", required = true) @RequestBody Map<String, Object> value) {
		DataStoreService service = DataStoreService.getDataStore();
		return service.createKey(key, value, expiry);
	}

	@ApiOperation(value = "Retrieve key value pair from data store", response = Object.class, tags = "Read key-value from datastore")
	@GetMapping("/read/{key}")
	public Object read(@PathVariable(required = true) String key) {
		DataStoreService service = DataStoreService.getDataStore();
		return service.retreiveKey(key);
	}

	@ApiOperation(value = "Delete key value pair from data store", response = String.class, tags = "Delete key-value from datastore")
	@PostMapping("/delete/{key}")
	public String delete(@PathVariable(required = true) String key) {
		DataStoreService service = DataStoreService.getDataStore();
		return service.deleteKey(key);
	}
}
