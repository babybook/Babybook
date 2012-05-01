package com.oak.babybook.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oak.babybook.db.MediaDao;
import com.oak.babybook.objects.Media;

public class MediaDaoImpl implements MediaDao {

	private SessionFactory sessionFactory;

	public MediaDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertMedia(Media media){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(media);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public Media getMedia(Long id) {
		Session session = sessionFactory.openSession();
		Media media = (Media)session.load(Media.class, id);
		return media;
	}

	@Override
	public List<Media> getMedias(List<Long> ids) {
		Session session = sessionFactory.openSession();
		List<Media> medias = new ArrayList<Media>();

		for (Long id : ids){
			Media media = (Media)session.load(Media.class, id);
			medias.add(media);
		}
		return medias;
	}

	@Override
	public void update(Media media) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(media);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public void delete(Media media) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(media);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}
}
