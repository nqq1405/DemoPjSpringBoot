package com.qlban.demospringboot.Controler.Request;

import lombok.Data;

@Data
public class ResetPass {
    private String token;
    private String newPass;
}
