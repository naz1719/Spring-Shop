package com.khimin.shop.models;

import com.khimin.shop.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by nazar on 4/4/17.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User extends AbstractEntity {

    private String firstname, lastname;
    private String email;
    private String password;
    private String country;

}
