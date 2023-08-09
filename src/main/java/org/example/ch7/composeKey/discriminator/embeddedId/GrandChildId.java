package org.example.ch7.composeKey.discriminator.embeddedId;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class GrandChildId implements Serializable {

    @Column(name = "GRANDCHILD_ID")
    private String grandChildId;
    private ChildId childId;

    public GrandChildId() {
    }

    public GrandChildId(ChildId childId) {
        this.childId = childId;
    }

    public GrandChildId(ChildId childId, String grandChildId) {
        this.childId = childId;
        this.grandChildId = grandChildId;
    }

    public String getGrandChildId() {
        return grandChildId;
    }

    public void setGrandChildId(String id) {
        this.grandChildId = id;
    }

    public ChildId getChildId() {
        return childId;
    }

    public void setChildId(ChildId childId) {
        this.childId = childId;
    }
}
