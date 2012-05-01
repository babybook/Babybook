package com.oak.babybook.services.impl;

import java.util.List;

import com.oak.babybook.db.impl.MediaDaoImpl;
import com.oak.babybook.objects.Media;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.services.MediaService;

public class MediaServiceImpl implements MediaService {

	private MediaDaoImpl mediaDao;

	public MediaServiceImpl(MediaDaoImpl pictureDao) {
		this.mediaDao = pictureDao;
	}

	@Override
	public Media getMedia(Long id) {
		return this.mediaDao.getMedia(id);
	}

	@Override
	public List<Media> getMedias(List<Long> ids) {
		return this.mediaDao.getMedias(ids);
	}

	@Override
	public void insertMedia(Media media) {
		this.mediaDao.insertMedia(media);
	}

	@Override
	public void update(Media media) {
		this.mediaDao.update(media);
	}

	@Override
	public void delete(Media media) {
		if (media != null) {
			Media newMedia = this.mediaDao.getMedia(media.getId());

			if (newMedia != null) {
				this.mediaDao.delete(media);
			}
		}
	}
}
