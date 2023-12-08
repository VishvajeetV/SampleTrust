package com.sample.demo.domain.user.api.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sample.demo.utils.Status;
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
public class AddressDto implements Serializable {
        
        private Long id;
        
        private String addressLine1;
        
        private String addressLine2;
        
        private String city;
        
        private String pinCode;
        
        private String country;
        
        private String state;
        
        private String status;
        
        private Date createdAt;
        
        private Date updatedAt;
        
        private UserDto user;
        
        public AddressDto(Long id, String addressLine1, String addressLine2, String city, String pinCode, String country,
                          String state, Status status, Date createdAt, Date updatedAt, Long userId) {
                this.id = id;
                this.addressLine1 = addressLine1;
                this.addressLine2 = addressLine2;
                this.city = city;
                this.pinCode = pinCode;
                this.country = country;
                this.state = state;
                this.status = status.name();
                this.createdAt = createdAt;
                this.updatedAt = updatedAt;
                if(userId != null){
                        user = new UserDto();
                        user.setId(userId);
                }
        }
}

