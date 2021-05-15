package com.interview.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interview.api.entity.Figure;
import com.interview.api.services.FigureService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController

@RequestMapping(value = "/figure")
@AllArgsConstructor
public class FigureController {

  private final FigureService figureService;

  @GetMapping
  public ResponseEntity<Map<String, Object>> listFigures() {
    List<Figure> figuresDb = this.figureService.getAllFigures();
    Map<String, Object> body = new HashMap<>();
    body.put("data", figuresDb);
    body.put("message", "Lista generada con exito");
    body.put("errors", null);
    return ResponseEntity.ok(body);
  }

  @GetMapping(value = "/group/{id}")
  public ResponseEntity<Map<String, Object>> listFiguresByIdGroup(@PathVariable("id") Long id) {
    List<Figure> figuresDb = this.figureService.getAllFiguresByIdGroupFigures(id);
    Map<String, Object> body = new HashMap<>();
    body.put("data", figuresDb);
    body.put("message", "Lista generada con exito");
    body.put("errors", null);
    return ResponseEntity.ok(body);
  }

  @PostMapping()
  public ResponseEntity<Map<String, Object>> createFigure(@RequestBody Figure figure) {
    Figure figureCreate = this.figureService.setFigure(figure);
    Map<String, Object> body = new HashMap<>();
    body.put("data", figureCreate.getId());
    body.put("message", "Figura creado con exito");
    body.put("errors", null);
    return ResponseEntity.status(HttpStatus.CREATED).body(body);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Object>> deleteFigure(@PathVariable("id") Long id) {
    Figure figureDb = this.figureService.deleteFigure(id);
    Map<String, Object> body = new HashMap<>();
    body.put("data", figureDb);
    if (figureDb == null) {
      body.put("message", "Figura No Eliminada");
      body.put("errors", "Figura no existe");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    body.put("message", "Figura Eliminada con exito");
    body.put("errors", null);
    return ResponseEntity.status(HttpStatus.OK).body(body);

  }
}
