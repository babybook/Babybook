package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Media;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.objects.Video;

public interface VideoDao {

	public void insertMedia(Video media);

	public Video getMedia(Long id);

	public List<Video> getMedias(List<Long> ids);

	public void update(Video media);

	public void delete(Video media);
}