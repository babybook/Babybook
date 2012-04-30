package com.oak.babybook.services.impl;

import java.util.List;

import com.oak.babybook.db.impl.PageDaoImpl;
import com.oak.babybook.objects.Page;
import com.oak.babybook.services.PageService;

public class PageServiceImpl implements PageService{

	private PageDaoImpl dao;

	public PageServiceImpl(PageDaoImpl pageDao){
		this.dao = pageDao;
	}

	@Override
	public void delete(Page page) {
		dao.delete(page);
	}

	@Override
	public Page getPage(Long id) {
		return dao.getPage(id);
	}

	@Override
	public List<Page> getPages(List<Long> ids) {
		return dao.getPages(ids);
	}

	@Override
	public void insertPage(Page page) {
		dao.insertPage(page);
	}

	@Override
	public void update(Page page) {
		dao.update(page);
	}


}
