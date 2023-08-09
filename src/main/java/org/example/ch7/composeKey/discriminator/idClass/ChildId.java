package org.example.ch7.composeKey.discriminator.idClass;

import java.io.Serializable;

public class ChildId implements Serializable {
    private Long parent;
    private Long childId;

    public ChildId() {
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }
}
