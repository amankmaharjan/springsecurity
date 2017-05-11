package com.mycompany.myapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by aman on 5/11/17.
 */
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer authId;
    String Authority;

    public Authority() {
    }

    public Authority(Integer authId, String authority) {
        this.authId = authId;
        Authority = authority;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authId=" + authId +
                ", Authority='" + Authority + '\'' +
                '}';
    }
}

