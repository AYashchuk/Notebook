package mainpack.dao;

import mainpack.domain.Notebook;
import mainpack.domain.Vendor;
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
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    @Autowired
    SessionFactory factory;

    @Override
    public Long create(Notebook notebook) {
        return (Long) factory.getCurrentSession().save(notebook);
    }

    @Override
    @Transactional(readOnly = true)
    public Notebook read(Long id) {
        return (Notebook) factory.getCurrentSession().get(Notebook.class, id);
    }

    @Override
    public boolean update(Notebook notebook) {
        factory.getCurrentSession().update("NOTEBOOKS", notebook);
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        factory.getCurrentSession().delete(notebook);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> findAll() {
        return factory.getCurrentSession().createCriteria(Notebook.class).addOrder(Order.asc("id")).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> findAll(int start, int portion) {
        return factory.getCurrentSession()
                .createCriteria(Notebook.class)
                .setFirstResult(start)
                .setMaxResults(portion).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> findLeft(int amount) {
        return factory.getCurrentSession().createCriteria(Notebook.class)
                .createAlias("stores", "store")
                .add(Restrictions.ge("store.storeQuantity", (long) amount))
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> findByCPUVendor(Vendor cpuVendor) {
        return factory.getCurrentSession().createCriteria(Notebook.class)
                .createAlias("noteCpu", "noteCpu")
                .add(Restrictions.eq("noteCpu.cpuVendor", cpuVendor))
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> findSold() {
        return factory.getCurrentSession().createCriteria(Notebook.class)
                .createAlias("stores", "store")
                .createAlias("store.sales", "sale")
                .list();
    }
}
