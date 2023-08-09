package org.example.ch7.composeKey.discriminator.idClass;

import java.io.Serializable;

public class GrandChildId implements Serializable {
    private ChildId child;
    private Long grandChildId;

    public GrandChildId() {
    }

    public ChildId getChild() {
        return child;
    }

    public void setChild(ChildId child) {
        this.child = child;
    }

    public Long getGrandChildId() {
        return grandChildId;
    }

    public void setGrandChildId(Long grandChildId) {
        this.grandChildId = grandChildId;
    }
}
