package com.khimin.shop.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * Created by nazar on 4/14/17.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User{

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }


    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user + super.toString()+
                '}';
    }
}
