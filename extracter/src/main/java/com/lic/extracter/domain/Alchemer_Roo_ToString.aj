// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.lic.extracter.domain;

import java.lang.String;

privileged aspect Alchemer_Roo_ToString {
    
    public String Alchemer.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("InquiryDate: ").append(getInquiryDate()).append(", ");
        sb.append("Keywords: ").append(getKeywords()).append(", ");
        sb.append("Url: ").append(getUrl()).append(", ");
        sb.append("UrlContent: ").append(getUrlContent());
        return sb.toString();
    }
    
}
