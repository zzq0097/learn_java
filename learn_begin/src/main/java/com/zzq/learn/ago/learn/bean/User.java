package com.zzq.learn.ago.learn.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    Integer id;
    String name;
    Integer age;
    Date time;
    User2 user2;
}
