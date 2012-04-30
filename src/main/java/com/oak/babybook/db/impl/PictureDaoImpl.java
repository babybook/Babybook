package com.oak.babybook.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oak.babybook.db.PictureDao;
import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.Picture;

public class PictureDaoImpl implements PictureDao {

	private SessionFactory sessionFactory;

	public PictureDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertPicture(Picture picture){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(picture);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public Picture getPicture(Long id) {
		Session session = sessionFactory.openSession();
		Picture picture = (Picture)session.load(Picture.class, id);
		return picture;
	}

	@Override
	public List<Picture> getPictures(List<Long> ids) {
		Session session = sessionFactory.openSession();
		List<Picture> pictures = new ArrayList<Picture>();

		for (Long id : ids){
			Picture picture = (Picture)session.load(Picture.class, id);
			pictures.add(picture);
		}
		return pictures;
	}

	@Override
	public void update(Picture picture) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(picture);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public void delete(Picture picture) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(picture);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}


}
