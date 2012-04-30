package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.Picture;

public interface PictureDao {

	public void insertPicture(Picture picture);
	
	public Picture getPicture(Long id);
	
	public List<Picture> getPictures(List<Long> ids);
	
	public void update(Picture picture);
	
	public void delete(Picture picture);
}