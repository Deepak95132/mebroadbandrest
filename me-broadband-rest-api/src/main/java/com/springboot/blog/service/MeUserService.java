package com.springboot.blog.service;

import com.springboot.blog.payload.MeUserDto;

import java.util.List;

public interface MeUserService {

    public MeUserDto saveMeUser(MeUserDto meUserDto);
    public List<MeUserDto> getAllMeUsers();

    public MeUserDto updateMeUser(MeUserDto meUserDto);

    public void saveAllMeUsers(List<MeUserDto> meUserDtoList);
}
