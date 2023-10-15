package com.iamneo.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserDto {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String age;
}
