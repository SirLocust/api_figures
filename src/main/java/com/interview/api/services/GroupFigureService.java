package com.interview.api.services;

import java.util.List;

import com.interview.api.entity.GroupFigure;

public interface GroupFigureService {

  public List<GroupFigure> getAllGroupFigure();

  public GroupFigure setGroupFigure(GroupFigure groupFigure);
}
