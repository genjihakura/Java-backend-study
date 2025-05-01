package com.vti.hello_world.controller;

import com.vti.hello_world.entity.Position;
import com.vti.hello_world.modal.PositionCreateDto;
import com.vti.hello_world.modal.PositionUpdateDto;
import com.vti.hello_world.service.Impl.PositionServiceImpl;
import com.vti.hello_world.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping()
    public List<Position> getALl(){
        return positionService.getAll();
    }

    @GetMapping("/{id}")
    public Position getById(@PathVariable int id){
        return positionService.getById(id);
    }

    @PostMapping("/create")
    public Position createPosition(@RequestBody PositionCreateDto dto){
        return positionService.createPosition(dto);
    }

    @PutMapping("/update")
    public Position updatePosition(@RequestBody PositionUpdateDto dto){
        return positionService.updatePosition(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePosition(@PathVariable int id){
        positionService.deletedPosition(id);
    }

}
