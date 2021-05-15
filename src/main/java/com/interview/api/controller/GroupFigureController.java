package com.interview.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interview.api.entity.GroupFigure;
import com.interview.api.services.GroupFigureService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController

@RequestMapping(value = "/groupfigure")
@AllArgsConstructor
public class GroupFigureController {

  private final GroupFigureService groupFigureService;

  @GetMapping
  public ResponseEntity<Map<String, Object>> listGroupsFigures() {
    List<GroupFigure> groupFiguresDb = this.groupFigureService.getAllGroupFigure();
    Map<String, Object> body = new HashMap<>();
    body.put("data", groupFiguresDb);
    body.put("message", "Lista generada con exito");
    body.put("errors", null);
    return ResponseEntity.ok(body);
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> createGroupFigure(@RequestBody GroupFigure groupFigure) {

    GroupFigure groupFigureCreate = this.groupFigureService.setGroupFigure(groupFigure);
    Map<String, Object> body = new HashMap<>();
    body.put("data", groupFigureCreate);
    body.put("message", "Modalidad creado con exito");
    body.put("errors", null);
    return ResponseEntity.status(HttpStatus.CREATED).body(body);

  }

}
