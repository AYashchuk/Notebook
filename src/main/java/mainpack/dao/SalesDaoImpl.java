package mainpack.dao;

import mainpack.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yashchuk A.F.
 */
@Repository
@Transactional
public class SalesDaoImpl implements SalesDao {
    private static Logger log = Logger.getLogger(SalesDaoImpl.class);
    @Autowired
    SessionFactory factory;

    @Override
    public Long create(Sales store) {
        return (Long) factory.getCurrentSession().save(store);
    }

    @Override
    @Transactional(readOnly = true)
    public Sales read(Long id) {
        return (Sales) factory.getCurrentSession().get(Sales.class, id);
    }

    @Override
    public boolean update(Sales store) {
        factory.getCurrentSession().update(store);
        return true;
    }

    @Override
    public boolean delete(Sales store) {
        factory.getCurrentSession().delete(store);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sales> findAll() {
        return factory.getCurrentSession().createCriteria(Sales.class).addOrder(Order.asc("id")).list();
    }

/*    public Map<Sales, Integer> getSalesByDays() {
        List<Sales> sales = factory.getCurrentSession().createCriteria(Sales.class).list();
        Map<Sales, Integer> salesByDays = new TreeMap<>();
        for(Sales sale : sales) {
            salesByDays.put(sale, sale.getSaleQuantity().intValue());
        }
        return salesByDays;
    }*/
}
