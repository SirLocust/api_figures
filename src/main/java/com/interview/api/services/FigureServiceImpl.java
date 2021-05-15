package com.interview.api.services;

import java.util.List;
import java.util.Optional;

import com.interview.api.entity.Figure;
import com.interview.api.repository.FigureRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FigureServiceImpl implements FigureService {

  private final FigureRepository figureRepository;

  @Override
  public List<Figure> getAllFigures() {
    return this.figureRepository.findAll();
  }

  @Override
  public Figure setFigure(Figure figure) {
    return this.figureRepository.save(figure);
  }

  @Override
  public Figure deleteFigure(Long id) {
    Figure figureDb = this.findById(id);
    if (figureDb == null) {
      return null;
    }
    this.figureRepository.deleteById(id);
    return figureDb;

  }

  @Override
  public Figure findById(Long id) {
    Optional<Figure> figureDb = this.figureRepository.findById(id);

    return figureDb.orElse(null);
  }

  @Override
  public List<Figure> getAllFiguresByIdGroupFigures(Long id) {
    return this.figureRepository.findByIdFigureGroup(id);
  }

}
