package com.agility.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agility.model.entity.UserEntity;

/**
 * jpa专用操作
 * @author williambai
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
