package com.rogercw.dao;

import java.util.List;

/**
 * Created by 1 on 2018/5/4.
 */
public interface BaseDao<T> {
    /**
     * 根据id加载实例
     * @param id
     * @return
     */
    public T load(int id);

    /**
     * 根据id查询实例
     * @param id
     * @return
     */
    public T findById(int id);

    /**
     * 查询所有实例
     * @return
     */
    public List<T> findAll();

    /**
     * 保存实例
     * @param entity
     */
    public void save(T entity);

    /**
     * 删除实例
     * @param id
     */
    public void delete(int id);

    /**
     * 修改实例
     * @param entity
     */
    public void update(T entity);

}
