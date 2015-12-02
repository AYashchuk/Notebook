package mainpack.view.Table;

import mainpack.domain.CPU;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Yashchuk A.F.
 */
public class CpuModel extends AbstractTableModel {
    private List<CPU> cpu ;

    public CpuModel(List<CPU> cpu) {
        this.cpu = cpu;
    }

    @Override
    public int getRowCount() {
        return cpu.size();
    }
    @Override
    public int getColumnCount() {
        return 4;
    }
    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return cpu.get(r).getId();
            case 1:
                return cpu.get(r).getModel();
            case 2:
                return cpu.get(r).getFrequency();
            case 3:
                return cpu.get(r).getVendor().getId();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "CPU ID";
            case 1:
                return "CPU Model";
            case 2:
                return "CPU freq.";
            case 3:
                return "Vendor ID";
            default:
                return null;
        }


    }
}
