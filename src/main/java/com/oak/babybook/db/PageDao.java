package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Page;

public interface PageDao {

	public void insertPage(Page evepagent);

	public Page getPage(Long id);

	public List<Page> getPages(List<Long> ids);

	public void update(Page page);

	public void delete(Page page);

}