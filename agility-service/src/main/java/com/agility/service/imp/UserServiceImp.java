package com.agility.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agility.dao.UserRepository;
import com.agility.model.entity.UserEntity;
import com.sx.agility.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired UserRepository mUserRepository;
	
	@Override
	public List<UserEntity> findAll() {
		return mUserRepository.findAll();
	}

}
