package com.elfintest.authservice.repository;

import com.elfintest.authservice.model.Userdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Userdata, Long> {

}
