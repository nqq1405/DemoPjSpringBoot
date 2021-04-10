package com.qlban.demospringboot.Controler.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ResetPassRequest {
    private String token;
    private String email;
}
