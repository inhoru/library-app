package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    반환타입 User 없다면 null반환 함수이름중요 find작성하면 1개의데이터만가져옴
//    By뒤에 붙는 필드 이름으로 select 쿼리 뒤에 where문이 작성된다.
//            select * from user where name = ?
    Optional<User> findByName(String name);


}
