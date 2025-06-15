package com.sample.demo.models;


import com.sample.demo.domain.user.db.models.User;
import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class BaseModel {
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "id"
    )
    @Id
    private Long id;
    @Column(
        name = "created_at"
    )
    private Date createdAt;
    @Column(
        name = "updated_at"
    )
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    
    @ManyToOne
    @JoinColumn(name = "updated_by"
    )
    private User updatedBy;

    @Column(
            name = "is_deleted"
    )
    private boolean isDeleted;
    
    
    
    public BaseModel() {
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public void setCreatedBy(User createdBy) {this.createdBy = createdBy;}
    public User getCreatedBy(){return this.createdBy;}
    
    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }
    public User getUpdatedBy(){return this.updatedBy;}

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    
    
    
    @PrePersist
    void createDate() {
        if (this.createdAt == null) {
            this.setCreatedAt(new Date());
        }
        
        this.setUpdatedAt(new Date());
    }
    
    @PreUpdate
    void updatedAt() {
        this.setUpdatedAt(new Date());
    }
    
    public String toString() {
        return "BaseEntity [id=" + this.id + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt +" ,createdBy=" + this.createdAt + ",updatedBy=" + this .updatedBy +" ]";
    }
}
