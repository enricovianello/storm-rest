package it.grid.storm.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"it.grid.storm.rest.controller"})
@EnableAutoConfiguration
public class StormRest {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(StormRest.class, args);
  }

}
