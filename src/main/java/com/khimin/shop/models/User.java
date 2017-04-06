package com.khimin.shop.models;

import com.khimin.shop.core.AbstractDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by nazar on 4/4/17.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User extends AbstractDocument {

    private String firstname, lastname;
    private String email;
    private String password;
    private String country;

}
