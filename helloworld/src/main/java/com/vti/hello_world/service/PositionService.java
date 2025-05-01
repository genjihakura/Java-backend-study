package com.vti.hello_world.service;

import com.vti.hello_world.entity.Position;
import com.vti.hello_world.modal.PositionCreateDto;
import com.vti.hello_world.modal.PositionUpdateDto;
import com.vti.hello_world.repository.PositionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public interface PositionService {
        public List<Position> getAll();
        public Position getById(int id);
        public Position createPosition(PositionCreateDto position);
        public Position updatePosition(PositionUpdateDto position);
        public Position findById(int id);
        public void deletedPosition(int id);
}
