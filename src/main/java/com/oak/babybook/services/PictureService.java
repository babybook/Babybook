package com.oak.babybook.services;

import java.util.List;

import com.oak.babybook.objects.Picture;

public interface PictureService {

	public Picture getPicture(Long id);

	public void insertPicture(Picture picture);

	public List<Picture> getPictures(List<Long> ids);

	public void update(Picture picture);

	public void delete(Picture picture);
}
