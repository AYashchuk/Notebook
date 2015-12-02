package mainpack.dao;

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
public class VendorDaoImpl implements VendorDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    @Autowired
    SessionFactory factory;

    @Override
    public Long create(Vendor vendor) {
        return  (Long) factory.getCurrentSession().save(vendor);
    }

    @Override
    @Transactional(readOnly = true)
    public Vendor read(Long id) {
        return (Vendor) factory.getCurrentSession().get(Vendor.class, id);
    }

    @Override
    public Vendor findByName(String vendorName) {
            return (Vendor) factory.getCurrentSession().createCriteria(Vendor.class).add(Restrictions.eq("vendorName", vendorName)).uniqueResult();
    }

    @Override
    public boolean update(Vendor vendor) {
        factory.getCurrentSession().update("VENDORS", vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        factory.getCurrentSession().delete(vendor);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vendor> findAll() {
        return factory.getCurrentSession().createCriteria(Vendor.class).addOrder(Order.asc("id")).list();
    }
}
