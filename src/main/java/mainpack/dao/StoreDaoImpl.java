package mainpack.dao;

import mainpack.domain.Notebook;
import mainpack.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yashchuk A.F.
 */
@Repository
@Transactional
public class StoreDaoImpl implements StoreDao {
    private static Logger log = Logger.getLogger(StoreDaoImpl.class);
    @Autowired
    SessionFactory factory;

    @Override
    public Long create(Store store) {
        return (Long) factory.getCurrentSession().save(store);
    }

    @Override
    @Transactional(readOnly = true)
    public Store read(Long id) {
        return (Store) factory.getCurrentSession().get(Store.class, id);
    }

    @Override
    public boolean update(Store store) {
        factory.getCurrentSession().update("STORES", store);
        return true;
    }

    @Override
    public boolean delete(Store store) {
        factory.getCurrentSession().delete(store);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> findAll() {
        return factory.getCurrentSession().createCriteria(Store.class).addOrder(Order.asc("id")).list();
    }

    @Override
    @Transactional(readOnly = true)
    public Store findByNote(Notebook notebook) {
        return (Store) factory.getCurrentSession()
                .createCriteria(Store.class)
                .add(Restrictions.eq("storeNote", notebook))
                .uniqueResult();
    }
}
