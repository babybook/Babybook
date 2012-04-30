package com.oak.babybook.services.impl;

import java.util.List;

import com.oak.babybook.db.impl.PictureDaoImpl;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.objects.User;
import com.oak.babybook.services.PictureService;

public class PictureServiceImpl implements PictureService {

	private PictureDaoImpl pictureDao;

	public PictureServiceImpl(PictureDaoImpl pictureDao) {
		this.pictureDao = pictureDao;
	}

	@Override
	public Picture getPicture(Long id) {
		return this.pictureDao.getPicture(id);
	}

	@Override
	public List<Picture> getPictures(List<Long> ids) {
		return this.pictureDao.getPictures(ids);
	}

	@Override
	public void insertPicture(Picture picture) {
		this.pictureDao.insertPicture(picture);
	}

	@Override
	public void update(Picture picture) {
		this.pictureDao.update(picture);
	}

	@Override
	public void delete(Picture pict) {
		if (pict != null) {
			Picture picture = this.pictureDao.getPicture(pict.getId());

			if (picture != null) {
				this.pictureDao.delete(picture);
			}
		}
	}
}
