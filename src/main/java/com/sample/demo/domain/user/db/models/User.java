package com.sample.demo.domain.user.db.models;


import com.sample.demo.models.BaseModel;
import com.sample.demo.utils.Status;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseModel {

    @Column(name = "username")
    private String username;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role_type")
    private Integer roleType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "activation_token")
    private String activationToken;

    @Column(name = "password")
    private String password;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "is_crm_user")
    private Integer isCrmUser;

    @Column(name = "is_sales_user")
    private Integer isSalesUser;

    @Column(name = "is_external_user")
    private Integer isExternalUser;

    @Column(name = "external_user_type")
    private String externalUserType;
}
