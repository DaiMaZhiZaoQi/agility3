package com.agility.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.agility.service.UserService;
import com.sx.dao.UserRepository;
import com.sx.model.entity.UserEntity;

@Service
public class UserServiceImp implements UserService{

	@Autowired UserRepository mUserRepository;
	
	@Override
	public List<UserEntity> findAll() {
		return mUserRepository.findAll();
	}

}
