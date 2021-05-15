package com.interview.api.services;

import java.util.List;

import com.interview.api.entity.GroupFigure;
import com.interview.api.repository.GroupFigureRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GroupFigureServiceImpl implements GroupFigureService {

  private final GroupFigureRepository groupFigureRepository;

  @Override
  public List<GroupFigure> getAllGroupFigure() {

    return this.groupFigureRepository.findAll();
  }

  @Override
  public GroupFigure setGroupFigure(GroupFigure groupFigure) {

    return this.groupFigureRepository.save(groupFigure);
  }

}
