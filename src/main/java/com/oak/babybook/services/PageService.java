package com.oak.babybook.services;

import java.util.List;

import com.oak.babybook.objects.Page;

public interface PageService {

	public Page getPage(Long id);

	public void insertPage(Page page);

	public List<Page> getPages(List<Long> ids);

	public void update(Page page);

	public void delete(Page page);
}
