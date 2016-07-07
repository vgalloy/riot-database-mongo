package vgalloy.riot.database.mongo.dao.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.mongo.dao.CommonDao;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.exception.DaoException;
import vgalloy.riot.database.mongo.entity.Datable;
import vgalloy.riot.database.mongo.entity.Identifiable;
import vgalloy.riot.database.mongo.entity.Key;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 07/07/16.
 */
public abstract class AbstractCommonDao<DTO, ENTITY extends Datable<DTO> & Identifiable> implements CommonDao<DTO, ENTITY> {

    private final GenericDao<ENTITY> genericDao;

    /**
     *
     * Constructor.
     *
     * @param genericDao the generic dao
     */
    public AbstractCommonDao(GenericDao<ENTITY> genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public void save(Region region, DTO dto) {
        Class<ENTITY> clazz = (Class<ENTITY>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        try {
            Constructor<ENTITY> constructor = clazz.getConstructor(Region.class, dto.getClass());
            ENTITY entity = constructor.newInstance(region, dto);
            genericDao.update(entity);
        } catch (Exception e) {
            throw new DaoException(DaoException.UNABLE_TO_SAVE_THE_DTO, e);
        }
    }

    @Override
    public Optional<ENTITY> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }

    @Override
    public Optional<ENTITY> getRandom(Region region) {
        return genericDao.getRandom(region);
    }
}
