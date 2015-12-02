package mainpack.dao;

import mainpack.domain.Sales;

import java.util.List;

/**
 * @author Yashchuk A.F.
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
