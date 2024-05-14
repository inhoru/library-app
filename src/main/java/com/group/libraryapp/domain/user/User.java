package com.group.libraryapp.domain.user;

import jakarta.persistence.*;

@Entity
public class User {
    @Id // 이필드를 primary key로 간주한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment와 동일 primary key는 자동생성되는 값
    private Long id = null;
    private Integer age; //필드와 컬럼이 완전히똑같으면 Column을 안해줘도된다.
    @Column(nullable = false, length = 20, name = "name") // name varchar = 20 필드명과 테이블 컬럼명이같을경우name생략가능
    private String name;

    //JPA를 사용하기위해서는 기본생성자가 필수
    protected User() {
    }

    public Long getId() {
        return id;
    }

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void updateName(String name){
        this.name = name;
    }
}

