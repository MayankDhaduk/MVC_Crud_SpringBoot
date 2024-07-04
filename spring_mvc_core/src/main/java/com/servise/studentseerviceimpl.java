package com.servise;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.studentdao;
import com.model.student;

@Service
public class studentseerviceimpl implements studentservice {

	@Autowired
	studentdao dao;
	
	@Override
	public void addorupdate(student st) {
		// TODO Auto-generated method stub
		dao.addorupdate(st);

	}

	@Override
	public ArrayList<student> viewalldata() {
		// TODO Auto-generated method stub
		return dao.viewalldata();
	}

	@Override
	public void deletestd(int id) {
		// TODO Auto-generated method stub
		dao.deletestd(id);
	}

	@Override
	public student getbyid(int id) {
		// TODO Auto-generated method stub
		return dao.getbyid(id);
	}

}
