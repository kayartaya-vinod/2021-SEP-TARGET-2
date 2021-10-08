package co.vinod.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class HelloServiceApplication {


	@GetMapping(path="/api/hello", produces = "application/json")
	public Map<String, Object> handleGetHelloMessage(
			@RequestParam(required = false, defaultValue = "friend") String name){

		Map<String, Object> map = new LinkedHashMap<>();
		map.put("success", true);
		map.put("timestamp", new Date());
		map.put("message", String.format("Hello, %s!", name));

		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}

}
