package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarOrden extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RealizarOrden dialog = new RealizarOrden();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RealizarOrden() {
		setBounds(100, 100, 359, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		ArrayList<String> ordenes = new ArrayList<>();
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 39, 335, 266);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			ArrayList<String> values = new ArrayList<>();
			
			
			for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
				if (Tienda.getInstance().getComponentes().get(i).getCantidad()<100) {
					values.add(Tienda.getInstance().getComponentes().get(i).toStringInventario());
					ordenes.add(Tienda.getInstance().getComponentes().get(i).getNumeroSerie());
				}
			}
			JList list = new JList();
			list.setModel(new AbstractListModel() {
				
			
				public int getSize() {
					return values.size();
				}
				public Object getElementAt(int index) {
					return values.get(index);
				}
			});
			list.setBounds(12, 12, 311, 242);
			panel.add(list);
		}
		
		JLabel lblComponentes = new JLabel("Componentes:");
		lblComponentes.setBounds(12, 12, 103, 15);
		contentPanel.add(lblComponentes);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ordenar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
							if (Tienda.getInstance().getComponentes().get(i).getNumeroSerie().equals(ordenes.get(i))) {
								Tienda.getInstance().getComponentes().get(i).setCantidad(Tienda.getInstance().getComponentes().get(i).getCantidad()+100);
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}