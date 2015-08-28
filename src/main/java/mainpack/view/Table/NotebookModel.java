package mainpack.view.Table;

import mainpack.domain.Notebook;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by admin on 15.01.2015.
 */
public class NotebookModel extends AbstractTableModel {

    private List<Notebook> notebook ;

    public NotebookModel(List<Notebook> notebook) {
        this.notebook = notebook;
    }

    @Override
    public int getRowCount() {
        return notebook.size();
    }
    @Override
    public int getColumnCount() {
        return 6;
    }
    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return notebook.get(r).getId();
            case 1:
                return notebook.get(r).getModel();
            case 2:
                return notebook.get(r).getDate();
            case 3:
                return notebook.get(r).getCpu().getId();
            case 4:
                return notebook.get(r).getMemory().getId();
            case 5:
                return notebook.get(r).getVendor().getId();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "Notebook ID";
            case 1:
                return "Notebook model";
            case 2:
                return "Notebook date of Man.";
            case 3:
                return "CPU ID";
            case 4:
                return "Memory ID";
            case 5:
                return "Vendor ID";
            default:
                return null;
        }


    }
}
