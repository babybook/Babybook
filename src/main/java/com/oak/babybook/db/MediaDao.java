package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Media;
import com.oak.babybook.objects.Picture;

public interface MediaDao {

	public void insertMedia(Media media);

	public Media getMedia(Long id);

	public List<Media> getMedias(List<Long> ids);

	public void update(Media media);

	public void delete(Media media);
}