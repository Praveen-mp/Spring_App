package com.iamneo.response;

import com.iamneo.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String userName;
    private Role role;
}
