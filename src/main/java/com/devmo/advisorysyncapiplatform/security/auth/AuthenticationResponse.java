package com.devmo.advisorysyncapiplatform.security.auth;

import com.devmo.advisorysyncapiplatform.security.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private  String token;
    private User user;
}
