package com.sample.demo.domain.user.db.models;


import com.sample.demo.models.BaseModel;
import com.sample.demo.utils.Status;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseModel {
        
        @Column(name = "address_line_1")
        private String addressLine1;
        
        @Column(name = "address_line_2")
        private String addressLine2;
        
        @Column(name = "city")
        private String city;
        
        @Column(name = "pin_code")
        private String pinCode;
    
        @Column(name = "state")
        private String state;
        
        @Column(name = "country")
        private String country;
        
        @Column(name = "status")
        @Enumerated(EnumType.STRING)
        private Status status;
        
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
        
    }
    

