package com.vti.bep3.controller;

import com.vti.bep3.entity.Staff;
import com.vti.bep3.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class StaffController {
    final StaffService staffService;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> saveFileData(@RequestParam("file") MultipartFile file) throws IOException {
        staffService.saveFileData(file.getInputStream());
        return ResponseEntity.ok("Excel File Data Saved into Database");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Staff>> findAll(){
        return ResponseEntity.ok(staffService.findAll());
    }
}
