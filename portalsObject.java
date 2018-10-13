package com.example.roy.studentportal;

import java.io.Serializable;

public class portalsObject implements Serializable {
    private String portalName;
    private String portalURL;


    public portalsObject(String portalName, String portalURL)  {
        this.portalName = portalName;
        this.portalURL = portalURL;
    }
    public String toString() {
        String portalName = this.portalName;

        return portalName;
    }

    public String getPortalName() {
        return portalName;
    }
    public void setPortalName() {
        this.portalName = portalName;
    }
    public String getPortalURL() {
        return portalURL;
    }
    public void setPortalURL() {
        this.portalURL = portalURL;
    }
}
