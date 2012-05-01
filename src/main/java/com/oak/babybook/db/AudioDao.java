package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Audio;

public interface AudioDao {

	public void insertMedia(Audio media);

	public Audio getMedia(Long id);

	public List<Audio> getMedias(List<Long> ids);

	public void update(Audio media);

	public void delete(Audio media);
}