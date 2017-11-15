package com.boot.portal.service.user.impl;/**
 * @description
 * @autor xbwu on 2017/11/14.
 */

import com.boot.portal.dao.base.BaseRepository;
import com.boot.portal.entity.base.BaseEntity;
import com.boot.portal.service.user.BaseJPAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;

import java.util.List;

/**
 * 基础服务实现
 * @author xbwu
 * @create 2017-11-14 
 **/
public abstract class BaseJPAServiceImpl<ENTITY extends BaseEntity> implements BaseJPAService<ENTITY>{

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    public abstract BaseRepository<ENTITY,Long> getRepository();

    @Override
    public List<ENTITY> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<ENTITY> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public List<ENTITY> findAllById(Iterable<Long> ids) {
        return getRepository().findAllById(ids);
    }

    @Override
    public <S extends ENTITY> List<S> saveAll(Iterable<S> entities) {
        return getRepository().saveAll(entities);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public <S extends ENTITY> S saveOrUpdateAndFlush(S entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public <S extends ENTITY> S saveOrUpdate(S entity) {
        return getRepository().save(entity);
    }

    @Override
    public void deleteInBatch(Iterable<ENTITY> baseEntities) {
        getRepository().deleteInBatch(baseEntities);
    }

    @Override
    public void deleteAllInBatch() {
        getRepository().deleteAllInBatch();
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public void delete(ENTITY entity) {
        getRepository().delete(entity);
    }

    @Override
    public ENTITY getOne(Long id) {
        return getRepository().getOne(id);
    }

    @Override
    public boolean existsById(Long id) {
        return getRepository().existsById(id);
    }

    @Override
    public <S extends ENTITY> List<S> findAll(Example<S> example) {
        return getRepository().findAll(example);
    }

    @Override
    public <S extends ENTITY> List<S> findAll(Example<S> example, Sort sort) {
        return getRepository().findAll(example,sort);
    }

    @Override
    public Page<ENTITY> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public PageRequest buildPageRequest(int pageNumber, int pagzSize,Sort sort) {
        return PageRequest.of(pageNumber - 1, pagzSize, sort);
    }
}
