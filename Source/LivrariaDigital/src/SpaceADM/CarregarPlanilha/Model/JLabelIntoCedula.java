package SpaceADM.CarregarPlanilha.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class JLabelIntoCedula extends JLabel implements TableCellRenderer {
    private static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    public  Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        ((JLabel) renderer).setOpaque(true);
        ((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) renderer).setForeground(Color.BLACK);

        return renderer;
    }
}

