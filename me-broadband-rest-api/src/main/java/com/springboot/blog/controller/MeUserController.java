package com.springboot.blog.controller;

import com.springboot.blog.payload.MeUserDto;
import com.springboot.blog.service.MeUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meUser/")
public class MeUserController {

    private MeUserService meUserService;

    public MeUserController(MeUserService meUserService) {
        this.meUserService = meUserService;
    }

    @PostMapping("/saveMeUser")
    public ResponseEntity<String> saveMeUser(@RequestBody MeUserDto meUserDto){
        MeUserDto savedUser = meUserService.saveMeUser(meUserDto);
        return new ResponseEntity<String>(savedUser.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/getAllMeUsers")
    public ResponseEntity<List<MeUserDto>> getComplaints(){
        return ResponseEntity.ok(meUserService.getAllMeUsers());
    }

    @PostMapping("/updateMeUser")
    public ResponseEntity<MeUserDto> updateMeUser( @RequestBody MeUserDto meUserDto){
        MeUserDto savedMeUser = meUserService.updateMeUser(meUserDto);
        return new ResponseEntity<MeUserDto>(savedMeUser, HttpStatus.CREATED);
    }

    @PostMapping("/saveAllMeUsers")
    public ResponseEntity<String> saveAllMeUser( @RequestBody List<MeUserDto> meUserDtoList){
        meUserService.saveAllMeUsers(meUserDtoList);
        return new ResponseEntity<String>("All Users are updated Successfully", HttpStatus.CREATED);
    }
}
