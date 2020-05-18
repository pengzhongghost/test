package com.project.service.impl;

import com.project.mapper.PositionMapper;
import com.project.pojo.Position;
import com.project.pojo.PositionExample;
import com.project.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionMapper positionMapper;
    @Override
    public List<Position> findAllPosition() {
        PositionExample positionExample=new PositionExample();
        return positionMapper.selectByExample(positionExample);
    }

    @Override
    public Position check(Position position) {
        return positionMapper.check(position);
    }

    @Override
    @Transactional
    public void positionAdd(Position position) {
        positionMapper.insert(position);
    }

    @Override
    @Transactional
    public void positionDelete(Position position) {
        positionMapper.deleteByPrimaryKey(position.getPosid());
    }

    @Override
    @Transactional
    public void positionUpdate(Position position) {
        positionMapper.updateByPrimaryKey(position);
    }
}
