package com.springboot.blog.service.impl;


import com.springboot.blog.entity.Complaint;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.ComplaintDto;
import com.springboot.blog.repository.ComplaintRepository;
import com.springboot.blog.service.ComplaintService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl implements ComplaintService {

   private ComplaintRepository complaintRepository;

   private ModelMapper modelMapper;

   public ComplaintServiceImpl(ComplaintRepository complaintRepository,ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
      this.complaintRepository =  complaintRepository;
   }

   @Override
   public ComplaintDto registerComplaint(ComplaintDto complaintDto) {
      Complaint complaint = modelMapper.map(complaintDto,Complaint.class);
      Complaint complaint1 =  complaintRepository.save(complaint);
      return modelMapper.map(complaint1,ComplaintDto.class);
   }

   @Override
   public List<ComplaintDto> getAllComplaints() {

      List<Complaint> complaints = complaintRepository.findAll();

      return complaints.stream().map((complaint) -> modelMapper.map(complaint, ComplaintDto.class))
              .collect(Collectors.toList());
   }

   @Override
   public ComplaintDto updateComplaint(ComplaintDto complaintDto) {

      Complaint complaint =  complaintRepository.findById(Long.valueOf(complaintDto.getId().trim()))
              .orElseThrow(() -> new ResourceNotFoundException("Category", "id",Long.valueOf(complaintDto.getId().trim())));
      complaint.setName(complaintDto.getName().trim());
      complaint.setEmail(complaintDto.getEmail().trim());
      complaint.setPhoneNumber(complaintDto.getPhoneNumber());
      complaint.setCategory(complaintDto.getCategory().trim());
      complaint.setStatus(complaintDto.getStatus());
      complaint.setDescription(complaintDto.getDescription().trim());
      Complaint complaint1 =  complaintRepository.save(complaint);
      return modelMapper.map(complaint1,ComplaintDto.class);
   }
}
