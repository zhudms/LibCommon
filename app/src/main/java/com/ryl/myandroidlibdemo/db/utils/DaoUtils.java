package com.ryl.myandroidlibdemo.db.utils;

import android.content.Context;
import android.renderscript.RenderScript;

import com.ryl.myandroidlibdemo.db.ProvincesDao;
import com.ryl.myandroidlibdemo.testbean.Provinces;

import java.util.List;

/**
 */
public class DaoUtils<T> {

    private static final String TAG = "DaoUtils";

    private DaoManager manager;

    public DaoUtils(Context context) {
        manager = DaoManager.getInstance(context);
    }

    /**
     * 插入操作
     *
     * @param entity entity
     * @return boolean
     */
    public boolean insertEntity(T entity) {
        boolean flag = false;
        flag = manager.getDaoSession().insert(entity) != -1;
        return flag;
    }

    /**
     * 插入操作
     *
     * @param entity entity
     * @return boolean
     */
    public boolean insertOrReplaceEntity(T entity) {
        boolean flag = false;
        flag = manager.getDaoSession().insertOrReplace(entity) != -1;
        return flag;
    }

    /**
     * 插入多条数据
     *
     * @param entities entities
     * @return boolean
     */
    public boolean insertMulitEntity(final List<T> entities) {
        boolean flag = false;
        try {
            manager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (T e : entities) {
                        manager.getDaoSession().insertOrReplace(e);
                    }

                }
            });
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 更新操作
     *
     * @param entity entity
     * @return boolean
     */
    public boolean updateEntity(T entity) {
        boolean flag = false;
        try {
            manager.getDaoSession().update(entity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除操作
     *
     * @param entity entity
     * @return boolean
     */
    public boolean deleteEntity(T entity) {
        boolean flag = false;
        try {
            manager.getDaoSession().delete(entity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除所有记录
     *
     * @param entity entityClass
     * @return boolean
     */
    public boolean deleteAll(T entity) {
        boolean flag = false;
        try {
            manager.getDaoSession().deleteAll(entity.getClass());
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 查询所有记录
     *
     * @return List<Entity>
     */
    @SuppressWarnings("unchecked")
    public List<T> listAll(T entity) {
        return (List<T>) manager.getDaoSession().loadAll(entity.getClass());

    }

    /**
     * 查询主键
     *
     * @param key key
     * @return Entity
     */
    public T quetyOneByKey(T entity, Long key) {
        return (T) manager.getDaoSession().load(entity.getClass(), key);
    }


    public void closeDB() {

        manager.closeConnection();

    }


    public Provinces quetyByWhere(String t) {

//        ProvincesDao dao = manager.getDaoSession().getProvincesDao();
//        return dao.queryBuilder().where(ProvincesDao.Properties.Id.eq(t)).unique();

        ProvincesDao dao = manager.getDaoSession().getProvincesDao();
        return dao.queryBuilder().where(ProvincesDao.Properties.Id.eq(t)/*, ProvincesDao.Properties.Id.eq(t)*/).unique();


//        QueryBuilder builder= new QueryBuilder(t.getClass());
////        for (int i = 0; i < s.length; i++) {
////            builder.where(s[i]);
////        }
//
//        Query query = userDao.queryRawCreate(
//                ", GROUP G WHERE G.NAME=? AND T.GROUP_ID=G._ID", "admin");
//        return new ArrayList<>();
    }

    public Provinces quertyByWhereOr() {
        ProvincesDao dao = manager.getDaoSession().getProvincesDao();

        return dao.queryBuilder().whereOr(ProvincesDao.Properties.Id.eq("33"),
                ProvincesDao.Properties.Province.eq("海南")).unique();
    }


    public List<Provinces> quertyByWhereOr(String s) {
        ProvincesDao dao = manager.getDaoSession().getProvincesDao();

//        return dao.queryBuilder().where(ProvincesDao.Properties.Id.eq("33"),
//                ProvincesDao.Properties.Province.eq("海南")).list();

//where a or b between limit
        return dao.queryBuilder().where(
                        dao.queryBuilder().and(
                                dao.queryBuilder().or(
                                        ProvincesDao.Properties.Id.in("11", "22"),
                        ProvincesDao.Properties.Province.in("北京", "黑龙江"))
                                ,ProvincesDao.Properties.Id.between("12","22"))).limit(3).list();

    }


}
