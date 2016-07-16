package vgalloy.riot.database.daemon.service;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.api.entity.Entity;
import vgalloy.riot.database.api.service.CommonService;
import vgalloy.riot.database.mongo.dao.commondao.CommonDao;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 15/07/16.
 */
public abstract class AbstractCommonService<DTO> implements CommonService<DTO> {

    private final CommonDao<DTO> commonDao;

    /**
     * Constructor.
     *
     * @param commonDao the common dao
     */
    protected AbstractCommonService(CommonDao<DTO> commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public void save(Region region, Long id, DTO dto) {
        commonDao.save(region, id, dto);
    }

    @Override
    public Entity<DTO> get(Region region, Long itemId) {
        return commonDao.get(region, itemId); // TODO
    }

    @Override
    public Entity<DTO> getRandom(Region region) {
        return commonDao.getRandom(region);
    }
}
