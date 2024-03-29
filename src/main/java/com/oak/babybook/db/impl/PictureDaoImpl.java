package com.oak.babybook.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oak.babybook.db.MediaDao;
import com.oak.babybook.db.PictureDao;
import com.oak.babybook.objects.Media;
import com.oak.babybook.objects.Picture;

public class PictureDaoImpl implements PictureDao {

	private SessionFactory sessionFactory;

	public PictureDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertMedia(Picture media){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(media);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public Picture getMedia(Long id) {
		Session session = sessionFactory.openSession();
		Picture media = (Picture)session.load(Picture.class, id);
		return media;
	}

	@Override
	public List<Picture> getMedias(List<Long> ids) {
		Session session = sessionFactory.openSession();
		List<Picture> medias = new ArrayList<Picture>();

		for (Long id : ids){
			Picture media = (Picture)session.load(Picture.class, id);
			medias.add(media);
		}
		return medias;
	}

	@Override
	public void update(Picture media) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(media);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public void delete(Picture media) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(media);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}
}
