package com.bimurto.domain;

import javax.persistence.*;


@Entity
@Table(name = "USERS")
public class Users {

    @SequenceGenerator(name = "UserIdSeq", sequenceName = "USERS_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UserIdSeq")
    @Id
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME", nullable = false)
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
