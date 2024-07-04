package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.student;

@Repository
@Transactional
public class studentdaoimpl implements studentdao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addorupdate(student st) {

		Session session = sessionFactory.openSession();

		Transaction tx = null;

		tx = session.beginTransaction();
		session.saveOrUpdate(st);
		tx.commit();

	}

	@Override
	public ArrayList<student> viewalldata() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		return (ArrayList<student>) session.createQuery("from student").list();
	}

	@Override
	public void deletestd(int id) {

		Session session = sessionFactory.openSession();

		Transaction tx = null;
		tx = session.beginTransaction();
		student st = session.load(student.class, id);
		session.delete(st);
		tx.commit();

	}

	@Override
	public student getbyid(int id) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx=session.beginTransaction();
		student st = session.load(student.class, id);
		return st;
	}

}
