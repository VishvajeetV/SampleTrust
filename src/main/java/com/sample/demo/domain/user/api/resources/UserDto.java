package com.sample.demo.domain.user.api.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sample.demo.domain.user.db.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements Serializable {

    private Long id;

    private String username;

    private String phoneNumber;

    private Integer roleType;

    private String status;

    private String name;

    private String email;

    private String activationToken;

    private String password;

    private String rememberToken;

    private Integer isCrmUser;

    private Integer isSalesUser;

    private Integer isExternalUser;

    private String externalUserType;

    private Date createdAt;

    private Date updatedAt;

    private User createdBy;

    private User updatedBy;


    public UserDto(Long userId, String username) {
        this.id = userId;
        this.username = username;
    }

}

