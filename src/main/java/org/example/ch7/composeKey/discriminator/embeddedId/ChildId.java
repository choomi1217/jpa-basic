package org.example.ch7.composeKey.discriminator.embeddedId;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ChildId implements Serializable {
    @Column(name = "CHILD_ID")
    private String childId;
    private String parentId;

    public ChildId() {
    }

    public ChildId(String parentId, String childId) {
        this.parentId = parentId;
        this.childId = childId;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
