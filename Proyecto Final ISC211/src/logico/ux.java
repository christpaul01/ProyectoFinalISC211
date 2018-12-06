package logico;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ux extends JTable {


	public Component prepareRenderer(TableCellRenderer renderer, int Index_row, int Index_col) {
		// get the current row
		Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
		// even index, not selected

		comp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		comp.setForeground(Color.BLACK);
		
		if (Index_row % 2 == 0) {
			comp.setBackground(Color.LIGHT_GRAY);

		}

		else {
			comp.setBackground(Color.WHITE);
		}

		return comp;
	}


}
