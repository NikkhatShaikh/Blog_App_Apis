package com.example.blogg_api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name =" Users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column (name="user_name",nullable=false,length=150)
    private String name;
    private String emailId;
    private String password;
    private String about;

}
