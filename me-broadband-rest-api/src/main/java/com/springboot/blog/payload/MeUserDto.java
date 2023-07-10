package com.springboot.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MeUserDto {
    private String id;
    private String username;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private String connectionStatus;
    private String servicePlan;
    private String startDate;
    private String endDate;
}
