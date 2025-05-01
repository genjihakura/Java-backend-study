package com.vti.hello_world.service.Impl;

import com.vti.hello_world.entity.Position;
import com.vti.hello_world.modal.PositionCreateDto;
import com.vti.hello_world.modal.PositionUpdateDto;
import com.vti.hello_world.repository.PositionRepository;
import com.vti.hello_world.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {

    final PositionRepository positionRepository;

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position getById(int id) {
        Optional<Position>  entity = positionRepository.findById(id);

        if(entity.isPresent()){
            return entity.get();
        }

        return null;
    }

    @Override
    public Position createPosition(PositionCreateDto dto) {
        Position position = new Position();
        position.setPositionName(dto.getPositionName());
        return positionRepository.save(position);
    }

    @Override
    public Position updatePosition(PositionUpdateDto position) {
        int id = position.getId();
        Position entity = findById(id);
        if(entity != null){
            entity.setPositionName(position.getPositionName());
            return positionRepository.save(entity);
        }
        return null;
    }

    @Override
    public Position findById(int id) {
        Optional<Position> optional = positionRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void deletedPosition(int id) {
        positionRepository.deleteById(id);
    }
}
