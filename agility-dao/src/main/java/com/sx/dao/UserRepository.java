package com.sx.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sx.model.entity.UserEntity;

/**
 * jpa专用操作
 * @author williambai
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
