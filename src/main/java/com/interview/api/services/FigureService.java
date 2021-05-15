package com.interview.api.services;

import java.util.List;

import com.interview.api.entity.Figure;

public interface FigureService {

  public List<Figure> getAllFigures();

  public Figure setFigure(Figure figure);

  public Figure deleteFigure(Long id);

  public Figure findById(Long id);

  public List<Figure> getAllFiguresByIdGroupFigures(Long id);

}
