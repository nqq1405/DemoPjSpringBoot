package com.qlban.demospringboot.Service.Valid;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CheckedService {

    final String email_regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    final String pass_regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
    final String numberPhone_regex = "(?=.*[0-9].{9,10})";
    final String numberPhone_regex2 = "(03|05|07|08|09|01[1|2|3|4|5|6|7|8|9])+([0-9]{9,10})\\b";

    public boolean validEmail(String email){
        Pattern pattern =
                Pattern.compile(email_regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).find();
    }

    public boolean validPassWord(String pass){
        Pattern pattern =
                Pattern.compile(pass_regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(pass).find();
    }

    public boolean validNumberPhone(String numberPhone){
        Pattern pattern =
                Pattern.compile(numberPhone_regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(numberPhone).find();
    }

    public static void main(String[] args) {

         if (new CheckedService().validNumberPhone("0382334693")) {
             System.out.println("ok");
        }else System.out.println("ko ok");

        if (new CheckedService().validPassWord("Quang1450$@")) {
            System.out.println("ok");
        }else System.out.println("ko ok");

    }
}
