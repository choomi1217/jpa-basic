package org.example.ch7.commonProperty.override;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @javax.persistence.Column(name = "MEMBER_ID")),
        @AttributeOverride(name = "name", column = @javax.persistence.Column(name = "MEMBER_NAME"))
})
public class Member extends BaseEntity {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
