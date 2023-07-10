package com.springboot.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintDto {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String description;
    private String status;
    private String category;
}
