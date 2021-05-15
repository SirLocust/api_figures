package com.interview.api.repository;

import java.util.List;

import com.interview.api.entity.Figure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FigureRepository extends JpaRepository<Figure, Long> {

  public List<Figure> findByIdFigureGroup(Long id);
}
