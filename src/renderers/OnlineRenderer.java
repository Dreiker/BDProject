/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderers;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import java.lang.Boolean;

/**
 *
 * @author Juan Manuel
 */
public class OnlineRenderer extends DefaultTableCellRenderer {

    @Override
    protected void setValue(Object value) {
        if (!(value instanceof Boolean)) return;
        else if (((boolean)value)) setBackground(Color.GREEN);
        else setBackground(Color.RED);
    }
}
