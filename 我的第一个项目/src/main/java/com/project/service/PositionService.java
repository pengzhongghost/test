package com.project.service;

import com.project.pojo.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAllPosition();

    Position check(Position position);

    void positionAdd(Position position);

    void positionDelete(Position position);

    void positionUpdate(Position position);
}
