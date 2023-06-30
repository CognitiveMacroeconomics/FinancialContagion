import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Vector;

/**
 * <p>Title: Limit Orderbook</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: CCFEA</p>
 *
 * @author Azeem Malik
 * @version 1.0
 */

public class JTableAlternateRowColor extends JTable {

  static final JPanel panelForColours = new JPanel();

    public JTableAlternateRowColor() {
    }

    public JTableAlternateRowColor(int i, int i1) {
        super(i, i1);
    }

    public JTableAlternateRowColor(TableModel tableModel) {
        super(tableModel);
    }

    public JTableAlternateRowColor(Object[][] objects, Object[] objects1) {
        super(objects, objects1);
    }

    public JTableAlternateRowColor(Vector vector, Vector vector1) {
        super(vector, vector1);
    }

    public JTableAlternateRowColor(TableModel tableModel, TableColumnModel tableColumnModel) {
        super(tableModel, tableColumnModel);
    }

    public JTableAlternateRowColor(TableModel tableModel, TableColumnModel tableColumnModel, ListSelectionModel listSelectionModel) {

        super(tableModel, tableColumnModel, listSelectionModel);
    }

    private Color alternativeColour = new Color(255, 240, 200);



    public Color getAlternativeColour() {
        return alternativeColour;
    }

    public void setAlternativeColour(Color alternativeColour) {
        this.alternativeColour = alternativeColour;
    }

    /**
     * Paints empty rows too, after letting the UI delegate do
     * its painting.
     */
    public void paint(Graphics g) {
        super.paint(g);
        paintEmptyRows(g);
    }

    /**
     * Paints the backgrounds of the implied empty rows when the
     * table model is insufficient to fill all the visible area
     * available to us. We don't involve cell renderers, because
     * we have no data.
     */
    protected void paintEmptyRows(Graphics g) {
        final int rowCount = getRowCount();
        final Rectangle clip = g.getClipBounds();
        if (rowCount * rowHeight < clip.height) {
            for (int i = rowCount; i <= clip.height / rowHeight; ++i) {
                g.setColor(colorForRow(i));
                g.fillRect(clip.x, i * rowHeight, clip.width, rowHeight);
            }
        }
    }

    /**
     * Changes the behavior of a table in a JScrollPane to be more like
     * the behavior of JList, which expands to fill the available space.
     * JTable normally restricts its size to just what's needed by its
     * model.
     */
    public boolean getScrollableTracksViewportHeight() {
        if (getParent() instanceof JViewport) {
            JViewport parent = (JViewport) getParent();
            return (parent.getHeight() > getPreferredSize().height);
        }
        return false;
    }

    /**
     * Returns the appropriate background color for the given row.
     */
    protected Color colorForRow(int row) {
      if (row >= this.getRowCount()) {
        return UIManager.getColor("Panel.background");
      } else {
        return (row % 2 == 0) ? alternativeColour : getBackground();
      }
    }

    /**
     * Shades alternate rows in different colors.
     */
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (isCellSelected(row, column) == false) {
            c.setBackground(colorForRow(row));
            c.setForeground(UIManager.getColor("Table.foreground"));
        } else {
            c.setBackground(UIManager.getColor("Table.selectionBackground"));
            c.setForeground(UIManager.getColor("Table.selectionForeground"));
        }
        return c;
    }
}
