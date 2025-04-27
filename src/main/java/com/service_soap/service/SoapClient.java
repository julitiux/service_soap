package com.service_soap.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SoapClient {

  private final RestTemplate restTemplate;

  public SoapClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String add(int a, int b) {
    String soapXml =
      """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
           <soapenv:Header/>
           <soapenv:Body>
              <tem:Add>
                 <tem:intA>%d</tem:intA>
                 <tem:intB>%d</tem:intB>
              </tem:Add>
           </soapenv:Body>
        </soapenv:Envelope>
        """.formatted(a, b);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_HTML);
    headers.add("SOAPAction", "http://tempuri.org/Add");

    HttpEntity<String> request = new HttpEntity<>(soapXml, headers);
    ResponseEntity<String> response = restTemplate.postForEntity("http://www.dneonline.com/calculator.asmx", request, String.class);

    return response.getBody();
  }
}
