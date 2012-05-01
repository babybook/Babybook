package com.oak.babybook.services.impl;

import java.util.List;

import com.oak.babybook.db.impl.MediaDaoImpl;
import com.oak.babybook.db.impl.PictureDaoImpl;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.services.PictureService;

public class PictureServiceImpl implements PictureService {

	private PictureDaoImpl pictureDao;

	public PictureServiceImpl(PictureDaoImpl pictureDao) {
		this.pictureDao = pictureDao;
	}

	@Override
	public Picture getPicture(Long id) {
		return this.pictureDao.getMedia(id);
	}

	@Override
	public List<Picture> getPictures(List<Long> ids) {
		return this.pictureDao.getMedias(ids);
	}

	@Override
	public void insertPicture(Picture picture) {
		this.pictureDao.insertMedia(picture);
	}

	@Override
	public void update(Picture picture) {
		this.pictureDao.update(picture);
	}

	@Override
	public void delete(Picture pict) {
		if (pict != null) {
			Picture picture = this.pictureDao.getMedia(pict.getId());

			if (picture != null) {
				this.pictureDao.delete(picture);
			}
		}
	}
}
