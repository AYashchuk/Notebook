package mainpack.dao;

import mainpack.domain.Sales;

import java.util.List;

/**
 * Created by Pavlo Kozhukhar on 11.12.2014.
 */
public interface SalesDao {
    Long create(Sales store);
    Sales read(Long id);
    boolean update(Sales store);
    boolean delete(Sales store);
    List<Sales> findAll();
 /*   Map<Sales, Integer> getSalesByDays();
*/
}
