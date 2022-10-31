package com.lgs.user.entitiy;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="USERINFO")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idx;

    private String id;

    private String password;

    private String name;

    private String birthday;

    private String address;
    private String addressDtl;

    private long fileIdx;

    private String email;
    private String phoneNum;

    private String createUser;
    private String updateUser;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime updateDate = LocalDateTime.now();

    @Builder
    public User(
        long idx,
        String id,
        String password,
        String name,
        String birthday,
        String address,
        String addressDtl,
        long fileIdx,
        String email,
        String phoneNum,
        String updateUser,
        LocalDateTime updateDate
    ) {
        this.idx = idx;
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.addressDtl = addressDtl;
        this.fileIdx = fileIdx;
        this.email = email;
        this.phoneNum = phoneNum;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }
}