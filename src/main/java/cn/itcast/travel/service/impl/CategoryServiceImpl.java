package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author:zlh
 * @ClassNameCategoryServiceImpl
 * @time:2020/6/16 17:38
 **/
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao= new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {


        return categoryDao.findAll();
    }
}
