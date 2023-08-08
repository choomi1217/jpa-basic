package org.example.ch7.commonProperty.noOverride;

import javax.persistence.Entity;

@Entity
public class Member extends BaseEntity{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
