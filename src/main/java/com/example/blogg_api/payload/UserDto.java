package com.example.blogg_api.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Getter
@Setter
public class UserDto{
    private int id;
    private String name;
    private String email;
    private String password;
    private String about;
}
