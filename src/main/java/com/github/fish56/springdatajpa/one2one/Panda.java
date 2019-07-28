package com.github.fish56.springdatajpa.one2one;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
@Entity
public class Panda {
    /**
     * 主键是必须指定的
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    /**
     * 不映射到数据库表的字段可以用下面的注解标注
     */
    @Transient
    private String fullName;

    /**
     * 映射为Date类型，而不是默认的DateTime
     */
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Wallet wallet;
}
// 对应的建表语句如下
// create table panda (id bigint generated by default as identity, birth_day date, first_name varchar(255), last_name varchar(255), wallet_id bigint, primary key (id))