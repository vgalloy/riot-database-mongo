package vgalloy.riot.database.mongo.dao.commondao.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.api.entity.Entity;
import vgalloy.riot.database.mongo.dao.commondao.CommonDao;
import vgalloy.riot.database.mongo.dao.commondao.GenericDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.dataobject.DataObject;
import vgalloy.riot.database.mongo.entity.mapper.DataObjectMapper;
import vgalloy.riot.database.mongo.exception.MongoDaoException;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 07/07/16.
 */
public abstract class AbstractCommonDao<DTO, DATA_OBJECT extends DataObject<DTO>> implements CommonDao<DTO> {

    private final GenericDao<DTO, DATA_OBJECT> genericDao;

    /**
     * Constructor.
     *
     * @param genericDao the generic service
     */
    /*package protected*/ AbstractCommonDao(GenericDao<DTO, DATA_OBJECT> genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public void save(Region region, Long id, DTO dto) {
        Class<DATA_OBJECT> clazz = (Class<DATA_OBJECT>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        try {
            Constructor<DATA_OBJECT> constructor = clazz.getConstructor(Region.class, Long.class, dto.getClass());
            DATA_OBJECT dataObject = constructor.newInstance(region, id, dto);
            genericDao.update(dataObject);
        } catch (Exception e) {
            throw new MongoDaoException(MongoDaoException.UNABLE_TO_SAVE_THE_DTO, e);
        }
    }

    @Override
    public Entity<DTO> get(Region region, Long summonerId) {
        Key key = new Key(region, summonerId);
        Optional<DATA_OBJECT> dataObject = genericDao.getById(key.normalizeString());
        if (dataObject.isPresent()) {
            return DataObjectMapper.map(dataObject.get());
        }
        return null;
    }

    @Override
    public Entity<DTO> getRandom(Region region) {
        Optional<DATA_OBJECT> dataObject = genericDao.getRandom(region);
        if (dataObject.isPresent()) {
            return DataObjectMapper.map(dataObject.get());
        }
        return null;
    }
}
