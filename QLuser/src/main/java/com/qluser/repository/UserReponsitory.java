package com.qluser.repository;

import com.qluser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserReponsitory extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

}
