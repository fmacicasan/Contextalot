// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.lic.extracter.domain;

import java.lang.String;

privileged aspect Sourcer_Roo_ToString {
    
    public String Sourcer.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Processed: ").append(getProcessed()).append(", ");
        sb.append("UrlSource: ").append(getUrlSource());
        return sb.toString();
    }
    
}
