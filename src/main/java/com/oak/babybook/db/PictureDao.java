package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Media;
import com.oak.babybook.objects.Picture;

public interface PictureDao {

	public void insertMedia(Picture media);

	public Picture getMedia(Long id);

	public List<Picture> getMedias(List<Long> ids);

	public void update(Picture media);

	public void delete(Picture media);
}