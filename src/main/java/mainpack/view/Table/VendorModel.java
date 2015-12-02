package mainpack.view.Table;

import mainpack.domain.Vendor;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Yashchuk A.F.
 */
public class VendorModel extends AbstractTableModel{

  private List<Vendor> vendors ;

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public VendorModel(List<Vendor> vendors) {
        this.vendors = vendors;
    }



        @Override
        public int getRowCount() {
            return vendors.size();
        }
        @Override
        public int getColumnCount() {
            return 2;
        }
        @Override
        public Object getValueAt(int r, int c) {
            switch (c) {
                case 0:
                    return vendors.get(r).getId();
                case 1:
                    return vendors.get(r).getName();
                default:
                    return "";
            }
        }
        @Override
        public String getColumnName(int c) {
            switch (c) {
                case 0:
                    return "Vendor ID";
                case 1:
                    return "Vendor Name";
                default:
                    return null;
            }


        }
}
