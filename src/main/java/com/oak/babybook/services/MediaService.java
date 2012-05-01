package com.oak.babybook.services;

import java.util.List;

import com.oak.babybook.objects.Media;

public interface MediaService {

	public Media getMedia(Long id);

	public void insertMedia(Media media);

	public List<Media> getMedias(List<Long> ids);

	public void update(Media media);

	public void delete(Media media);
}
