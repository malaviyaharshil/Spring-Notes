package com.mhm.Springboot_Rest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users") //table name in database if different
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
}
