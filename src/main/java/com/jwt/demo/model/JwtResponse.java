package com.jwt.demo.model;
import lombok.*;
import lombok.Data;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class JwtResponse {
    private  String jwtToken;
    private String userName;
}
