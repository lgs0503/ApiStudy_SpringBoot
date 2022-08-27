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

    private long phoneNum;

    private String address;

    private String addressDtl;

    private long imageFileNo;

    private String createUser;
    private String updateUser;

    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Builder
    public User(long idx,
                String id,
                String password,
                String name,
                String birthday,
                long phoneNum,
                String address,
                String addressDtl,
                long imageFileNo,
                String createUser,
                String updateUser,
                LocalDateTime createdDate,
                LocalDateTime updatedDate
    ) {
        this.idx = idx;
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.phoneNum = phoneNum;
        this.address = address;
        this.addressDtl = addressDtl;
        this.imageFileNo = imageFileNo;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}