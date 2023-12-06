package com.zzq.learn.ago.learn.dao;

import com.zzq.learn.ago.learn.bean.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestJPA extends JpaRepository<User2, Integer> {

}
