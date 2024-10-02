package com.ms.user.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;//avoid conflicts with sequential ids
                        //with uuids, we have universal identifiers

    private String name;
    private String email;

}
