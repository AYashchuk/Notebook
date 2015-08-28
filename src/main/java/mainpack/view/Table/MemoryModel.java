package mainpack.view.Table;

import mainpack.domain.Memory;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by admin on 15.01.2015.
 */
public class MemoryModel extends AbstractTableModel {
    private List<Memory> memory ;

    public void setMemory(List<Memory> memory) {
        this.memory = memory;
    }

    public MemoryModel(List<Memory> memory) {
        this.memory = memory;
    }

    public List<Memory> getMemory() {

        return memory;
    }

    @Override
    public int getRowCount() {
        return memory.size();
    }
    @Override
    public int getColumnCount() {
        return 4;
    }
    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return memory.get(r).getId();
            case 1:
                return memory.get(r).getModel();
            case 2:
                return memory.get(r).getHdd();
            case 3:
                return memory.get(r).getVendor().getId();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "Memory ID";
            case 1:
                return "Memory Model";
            case 2:
                return "Memory HDD";
            case 3:
                return "Vendor ID";
            default:
                return null;
        }


    }
}
