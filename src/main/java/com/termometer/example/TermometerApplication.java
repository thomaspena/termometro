package com.termometer.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TermometerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TermometerApplication.class, args);
    }

    @GetMapping("/convert/farenheit/celsius/{farenheit}")
    public ResponseEntity<Double> convertFarenheitCelsius(@PathVariable double farenheit){
        double value = (farenheit - 32) * 5/9;
        return new ResponseEntity<Double>(value, HttpStatus.OK);
    }

    @GetMapping("/convert/celsius/farenheit/{celsius}")
    public ResponseEntity<Double> convertCelsiusFarenheit(@PathVariable double celsius){
        double value = (celsius * 9/5) + 32;
        return new ResponseEntity<Double>(value, HttpStatus.OK);
    }

}
