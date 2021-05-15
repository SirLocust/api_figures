package com.interview.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/myprofile")
public class ProfileController {

  @GetMapping
  public ResponseEntity<Map<String, String>> getProfile() {
    Map<String, String> body = new HashMap<>();
    body.put("firstName", "SuperAdmin");
    body.put("lastName", "Michael");
    body.put("username", "superAdmin");
    body.put("rol", "SuperAdmin");
    body.put("createdDate", "9 jul. 2019");

    return ResponseEntity.ok(body);

  }
}
