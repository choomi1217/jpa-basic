package org.example.ch9.embeddedValue.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PhoneServiceProvider {
    @Id @GeneratedValue
    @Column(name = "PHONE_SERVICE_PROVIDER_ID")
    Long id;
    @Column(name = "PHONE_SERVICE_PROVIDER_NAME")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
