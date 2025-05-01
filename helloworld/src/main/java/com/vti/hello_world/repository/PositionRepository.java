package com.vti.hello_world.repository;

import com.vti.hello_world.entity.Department;
import com.vti.hello_world.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,Integer> {

}
