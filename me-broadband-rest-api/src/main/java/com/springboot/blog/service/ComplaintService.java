package com.springboot.blog.service;

import com.springboot.blog.payload.ComplaintDto;

import java.util.List;

public interface ComplaintService {

    public ComplaintDto registerComplaint(ComplaintDto complaintDto);
    public List<ComplaintDto> getAllComplaints();
    public ComplaintDto updateComplaint(ComplaintDto complaintDto);
}
