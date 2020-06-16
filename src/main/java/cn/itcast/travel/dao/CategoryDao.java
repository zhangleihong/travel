package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @author:zlh
 * @ClassNameCategoryDao
 * @time:2020/6/16 17:32
 **/
public interface CategoryDao {
    public List<Category> findAll();
}
