package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Complaint;
import com.springboot.blog.entity.MeUser;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.ComplaintDto;
import com.springboot.blog.payload.MeUserDto;
import com.springboot.blog.repository.ComplaintRepository;
import com.springboot.blog.repository.MeUserRepository;
import com.springboot.blog.service.MeUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeUserServiceImpl implements MeUserService {

    private MeUserRepository meUserRepository;

    private ModelMapper modelMapper;

    public MeUserServiceImpl(MeUserRepository meUserRepository,ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.meUserRepository =  meUserRepository;
    }

    @Override
    public MeUserDto saveMeUser(MeUserDto meUserDto) {
        MeUser meUser = modelMapper.map(meUserDto,MeUser.class);
        MeUser savedUser =  meUserRepository.save(meUser);
        return modelMapper.map(savedUser,MeUserDto.class);
    }

    @Override
    public List<MeUserDto> getAllMeUsers() {

        List<MeUser> meUsers = meUserRepository.findAll();
        return meUsers.stream().map((meUser) -> modelMapper.map(meUser, MeUserDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public MeUserDto updateMeUser(MeUserDto meUserDto) {

        MeUser meUser =  meUserRepository.findById(meUserDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id",Long.valueOf(meUserDto.getId().trim())));
        meUser = modelMapper.map(meUserDto,MeUser.class);
        MeUser savedUser =  meUserRepository.save(meUser);
        return modelMapper.map(savedUser,MeUserDto.class);
    }

    @Override
    public void saveAllMeUsers(List<MeUserDto> meUserDtoList) {

        List<MeUser> meUserList = meUserDtoList.stream().map(user->modelMapper.map(user,MeUser.class)).collect(Collectors.toList());
        meUserRepository.saveAll(meUserList);
    }
}
