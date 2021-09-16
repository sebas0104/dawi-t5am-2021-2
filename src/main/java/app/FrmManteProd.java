package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Categoria;
import modelo.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtC�digo;
	JComboBox<Categoria> cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtC�digo = new JTextField();
		txtC�digo.setBounds(122, 8, 86, 20);
		contentPane.add(txtC�digo);
		txtC�digo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 11, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox<Categoria>();
		cboCategorias.setBounds(122, 61, 128, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 65, 86, 14);
		contentPane.add(lblCategora);

		JLabel lblDescripcion = new JLabel("Nom.Producto :");
		lblDescripcion.setBounds(10, 36, 102, 14);
		contentPane.add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 33, 128, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock.Producto :");
		lblStock.setBounds(10, 97, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 94, 128, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio.Producto :");
		lblPrecio.setBounds(10, 125, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 122, 128, 20);
		contentPane.add(txtPrecio);

		llenacombo();
	}

	void llenacombo() {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		String sql = "select c from Categoria c";

		List<Categoria> almacena = em.createQuery(sql, Categoria.class).getResultList();

		for (Categoria categoria : almacena) {

			cboCategorias.addItem(categoria);
		}

	}

	void registrar() {
		String codigo = txtC�digo.getText();
		String descripcion = txtDescripcion.getText();
		Categoria categoria = (Categoria) cboCategorias.getSelectedItem();
		int almacenaId = categoria.getIdcategoria();
		int stock = Integer.parseInt(txtStock.getText());
		double precio = Double.parseDouble(txtPrecio.getText());
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();
		Producto p= new Producto(codigo, descripcion, stock, precio, almacenaId, stock);
		em.persist(p);
		em.getTransaction().commit();
		JOptionPane.showMessageDialog(this,"registro ok ");
	}

	void listado() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		String sql = "select p from Producto p";

		List<Producto> lstProducto = em.createQuery(sql, Producto.class).getResultList();
		
		for (Producto p : lstProducto) {
			
			txtSalida.append(p + "\n");
		}

	}

}
