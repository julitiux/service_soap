package com.service_soap.controller;

import com.service_soap.service.SoapClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/soap")
public class SoapController {

  private final SoapClient soapClient;

  public SoapController(SoapClient soapClient) {
    this.soapClient = soapClient;
  }

  @GetMapping("/add")
  public String sumar(@RequestParam int a, @RequestParam int b) {
    return soapClient.add(a, b);
  }
}
