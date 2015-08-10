package com.htcursos.sprinklesapp.models;

import java.io.Serializable;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

/**
 * Created by mac on 31/07/15.
 */
@Table("User")
public class User extends Model implements Serializable {
    @Key
    @AutoIncrement
    @Column("id")
    public long id;

    @Column("name")
    public String name;

    @Column("email")
    public String email;


}
