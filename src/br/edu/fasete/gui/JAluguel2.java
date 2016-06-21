package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;
import br.edu.fasete.dao.ClienteDaoJdbc;
import br.edu.fasete.dao.RoupaDaoJdbc;
import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Lista;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Funcionario;
import br.edu.fasete.principais.Roupa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JAluguel2 extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClienteDaoJdbc cli = new ClienteDaoJdbc();
	RoupaDaoJdbc rou = new RoupaDaoJdbc();
	int srow;
	String svalueCpf;
	int svaluecoder;
	String svalueName;
	String vazio;
	Lista l = new Lista();
	Cliente c = new Cliente();
	Roupa r = new Roupa();
	Aluguel a = new Aluguel();
	Funcionario f = new Funcionario();
	int pesq2;
	String pesq;
	JCalendar calevenc1 = new JCalendar();
	JCalendar calepagef1 = new JCalendar();
	JCalendar calevenc2 = new JCalendar();
	JCalendar calepag2 = new JCalendar();
	private  JTextField precoField2;
	private JTextField nomeField;
	private JTextField enderecoField;
	private JTextField bairroField;
	private JTextField cidadeField;
	private JTextField estadoField;
	private JTextField numeroField;
	private JTabbedPane tabbedPane;
	private JTable tabelaCategoria;
	private JTable tabelaRoupa;
	private JTable tabelaRoupa_1;
	private JTable tabelaRoupasele;
	private JTable tabelaRoupaAluguel;
	private JTextField nomeField2;
	private JFormattedTextField telefoneField;
	private JFormattedTextField cpfField;
	private JTextField tamanhoField;
	private JTextField corField;
	private JTextField tipoField;
	private JTextField modeloField;
	private JTextField generoField;
	private JFormattedTextField dataLoca;
	private JFormattedTextField DataDevo;
	private JTextField precoFieldal;
	private JTextField precoFieldFim;
	java.util.Date x;
	JTextField funcField;
	private JTextField funcioField;
	private JTextField textField;
	private JTextField pesqField;
	private JTextField precopagField;
	private JTextField valor1Field;
	private JTextField precofimpagField;
	private JTextField datadevenc1Field;
	private JTextField pagefe1Field;
	private JTextField valor2Field;
	private JTextField datavenc2Field;
	private JTextField pagef2Field;
	private JTextField valoref1Field;
	private JTextField valoref2Field;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAluguel2 frame = new JAluguel2();
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
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JAluguel2() {
		setTitle("Aluguel");
		setFrameIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/iconcloset.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1280, 720);

		
		
		
		
	
		Fachada.getInstancia().limparTabela();
		Fachada.getInstancia().limparLista();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		@SuppressWarnings("unused")
		JTabbedPane PanelCadastro = new JTabbedPane(JTabbedPane.TOP);
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			
		
		} catch (ParseException e1) {
		
			e1.printStackTrace();
		}
		 
		
		
		try {
			MaskFormatter mascara = new MaskFormatter("(##)####-#####");
			mascara.setPlaceholderCharacter('_');
			
		
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
				
				
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				 
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				
				try {
					MaskFormatter mascara = new MaskFormatter("(##)####-####");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					
					e1.printStackTrace();
					}
		
		////
				
		tabelaRoupa = new JTable(new RoupaTableModel());
		tabelaRoupa.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				srow = tabelaRoupa.getSelectedRow();
				
				svaluecoder = (int) tabelaRoupa.getValueAt(srow, 0);
				
			}
			
		});
					
					tabbedPane = new JTabbedPane(JTabbedPane.TOP);
					tabbedPane.setForeground(Color.WHITE);
					tabbedPane.setBackground(Color.DARK_GRAY);
					
					tabbedPane.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							
							
							//Carregar tabela sempre que alternar para aba de relatórios
							if(tabbedPane.getSelectedIndex() == 1) {
								carregarTabelaRoupa();
								//Fachada.getInstancia().limparTabela();
								//Fachada.getInstancia().limparLista();
								carregarTabelaRoupasele();	
							}
							
							if(tabbedPane.getSelectedIndex() == 2) {
								carregarTabelaRoupa();
								//Fachada.getInstancia().limparTabela();
								carregarTabelaRoupaLista();
							}
							if(tabbedPane.isShowing()) {	
								//Fachada.getInstancia().limparTabela();	
								carregarTabela();	
							}	
						}
					});
					getContentPane().add(tabbedPane, BorderLayout.CENTER);
					getContentPane().add(tabbedPane);
					
					JPanel cadast = new JPanel();
					cadast.setBackground(Color.DARK_GRAY);
					
					tabbedPane.addTab("Cadastrar Aluguel", null, cadast, null);
					tabbedPane.setEnabledAt(0, true);
					cadast.setLayout(new MigLayout("", "[101.00px,grow][31px,grow][407px][31px][13px][28px][181px][34px][373px,grow]", "[30][253px][35.00px][47.00px][25px][51.00px][25px][54.00px][25px][58.00px][25px][61.00px]"));
					
					JLabel lblClientesDiponiveis = new JLabel("Clientes Dipon\u00EDveis");
					lblClientesDiponiveis.setForeground(Color.WHITE);
					lblClientesDiponiveis.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblClientesDiponiveis, "cell 0 0 2 1");
								
								pesqField = new JTextField();
								pesqField.setFont(new Font("Dialog", Font.PLAIN, 15));
								pesqField.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent e) {
										pesq =pesqField.getText();
										carregarTabelanome();
									}
								});
								cadast.add(pesqField, "cell 0 2 2 1,grow");
								pesqField.setColumns(10);
								
								JLabel lblPesquisar = new JLabel("Pesquisar");
								lblPesquisar.setForeground(Color.WHITE);
								lblPesquisar.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblPesquisar, "cell 2 2");
								
								JLabel labelnome = new JLabel("Nome");
								labelnome.setForeground(Color.WHITE);
								labelnome.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(labelnome, "cell 0 3,alignx left,aligny bottom");
								JLabel lblCpf = new JLabel("CPF");
								lblCpf.setForeground(Color.WHITE);
								lblCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblCpf, "cell 6 3,alignx left,aligny bottom");
								nomeField = new JTextField();
								nomeField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(nomeField, "cell 0 4 5 1,grow");
								nomeField.setColumns(10);
								cpfField = new JFormattedTextField();
								cpfField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(cpfField, "cell 6 4 3 1,grow");
								
								JLabel lblNumero = new JLabel("numero");
								lblNumero.setForeground(Color.WHITE);
								lblNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblNumero, "cell 6 7,alignx left,aligny bottom");
							
								telefoneField = new JFormattedTextField();
								telefoneField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(telefoneField, "cell 6 10 3 1,grow");
								
								 precoField2 = new JTextField();
								
								JLabel lblTelefone = new JLabel("Telefone");
								lblTelefone.setForeground(Color.WHITE);
								lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblTelefone, "cell 6 9,alignx left,aligny bottom");
								
								JLabel lblEndereo = new JLabel("Endere\u00E7o");
								lblEndereo.setForeground(Color.WHITE);
								lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblEndereo, "cell 0 7,alignx left,aligny bottom");
								
								enderecoField = new JTextField();
								enderecoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(enderecoField, "cell 0 8 5 1,grow");
								enderecoField.setColumns(10);
								
								JLabel lblBairro = new JLabel("Bairro");
								lblBairro.setForeground(Color.WHITE);
								lblBairro.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblBairro, "cell 0 9,alignx left,aligny bottom");
								
								bairroField = new JTextField();
								bairroField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(bairroField, "cell 0 10 5 1,grow");
								bairroField.setColumns(10);
								
								JLabel lblCidade = new JLabel("Cidade");
								lblCidade.setForeground(Color.WHITE);
								lblCidade.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblCidade, "cell 0 5,alignx left,aligny bottom");
								
								JLabel lblEstado = new JLabel("Estado");
								lblEstado.setForeground(Color.WHITE);
								lblEstado.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblEstado, "cell 6 5,alignx left,aligny bottom");
								
								cidadeField = new JTextField();
								cidadeField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(cidadeField, "cell 0 6 5 1,grow");
								cidadeField.setColumns(10);
								
								estadoField = new JTextField();
								estadoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(estadoField, "cell 6 6 3 1,grow");
								estadoField.setColumns(10);
								
								
								cadast.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent arg0) {

										
									}
									@Override
									public void keyReleased(KeyEvent arg0) {

									}
								});
								
								numeroField = new JTextField();
								numeroField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(numeroField, "cell 6 8 3 1,grow");
								numeroField.setColumns(10);
								tabelaCategoria = new JTable(new ClienteTableModel());
								tabelaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
								tabelaCategoria.addMouseListener(new MouseAdapter() {
									public void mouseReleased(MouseEvent arg0) {
										srow = tabelaCategoria.getSelectedRow();
										svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
										svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
										
										
									}
									
								});
								
								
								tabelaCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								JScrollPane scrollPane = new JScrollPane(tabelaCategoria);
								cadast.add(scrollPane, "cell 0 1 9 1,grow");
								
								JLabel btnlblAvancar = new JLabel("");
								btnlblAvancar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										if(nomeField.getText().isEmpty()){
											JOptionPane.showMessageDialog(null, "Selecione um Cliente.");
										}else{
										Fachada.getInstancia().limparTabela();
										Fachada.getInstancia().BuscarRoupaEd(r);
										Fachada.getInstancia().ListarRoupaEdi(r,c);
										carregarTabelaRoupasele();
										
										btnlblAvancar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar3.png")));
										String pesq = c.getCPF();
										Fachada.getInstancia().BuscarClienteCPF(c, pesq);
										
										tabbedPane.setSelectedIndex(1);
										
										}
									}
									@Override
									public void mouseEntered(MouseEvent arg0) {
										btnlblAvancar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										btnlblAvancar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										btnlblAvancar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar1.png")));
									}
								});
								
								funcField = new JTextField();
								funcField.setVisible(false);
								cadast.add(funcField, "cell 1 11,alignx center");
								funcField.setColumns(10);
								btnlblAvancar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar1.png")));
								cadast.add(btnlblAvancar, "cell 8 11,alignx right");
								
								JPanel pagamento = new JPanel();
								
								pagamento.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										calevenc1.setVisible(false);
										calevenc2.setVisible(false);
										calepag2.setVisible(false);
										calepagef1.setVisible(false);
										
										
									}
								});
								pagamento.setBackground(Color.DARK_GRAY);
								tabbedPane.addTab("Pagamento", null, pagamento, null);
								pagamento.setLayout(new MigLayout("", "[200][30][300.00px][50][89.00px][30][200,grow][30][300,grow][]", "[68.00px][68.00,grow][30px][][160px][20px][][160px][23px]"));
								
								JPanel panel = new JPanel();
								pagamento.add(panel, "cell 0 0 10 2,grow");
								panel.setLayout(null);
								
								JLabel lblPreo_2 = new JLabel("Pre\u00E7o");
								lblPreo_2.setBounds(67, 11, 39, 20);
								panel.add(lblPreo_2);
								lblPreo_2.setForeground(Color.WHITE);
								lblPreo_2.setFont(new Font("Dialog", Font.PLAIN, 15));
								JLabel lblStatus_1 = new JLabel("Status");
								lblStatus_1.setForeground(Color.WHITE);
								lblStatus_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblStatus_1, "cell 4 5,alignx left,aligny bottom");
								
								JLabel lblValorPago_1 = new JLabel("Valor pago");
								lblValorPago_1.setForeground(Color.WHITE);
								lblValorPago_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblValorPago_1, "cell 6 5,alignx left,aligny bottom");
								precopagField = new JTextField();
								precopagField.setBounds(20, 39, 209, 26);
								panel.add(precopagField);
								precopagField.setForeground(Color.WHITE);
								precopagField.setFont(new Font("Dialog", Font.PLAIN, 15));
								precopagField.setColumns(10);
								
								precofimpagField = new JTextField();
								precofimpagField.setBounds(317, 39, 214, 26);
								panel.add(precofimpagField);
								precofimpagField.setForeground(Color.WHITE);
								precofimpagField.setFont(new Font("Dialog", Font.PLAIN, 15));
								precofimpagField.setColumns(10);
								JLabel lblDataDeVencimento = new JLabel("Data de vencimento");
								lblDataDeVencimento.setForeground(Color.WHITE);
								lblDataDeVencimento.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblDataDeVencimento, "cell 2 2,alignx left,aligny bottom");
								
								JLabel lblPagamentoEfetuado = new JLabel("Data em que o pagamento foi efetuado");
								lblPagamentoEfetuado.setForeground(Color.WHITE);
								lblPagamentoEfetuado.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblPagamentoEfetuado, "cell 8 2,grow");
								JLabel lblPreoFinal_1 = new JLabel("Pre\u00E7o final");
								lblPreoFinal_1.setBounds(377, 11, 69, 20);
								panel.add(lblPreoFinal_1);
								lblPreoFinal_1.setForeground(Color.WHITE);
								lblPreoFinal_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								JComboBox status2box = new JComboBox();
								status2box.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent e) {
										if(status2box.getSelectedItem()=="Pendente"){
											pagef2Field.setEnabled(false);
											valoref2Field.setEnabled(false);	
										}else{
											pagef2Field.setEnabled(true);
											valoref2Field.setEnabled(true);
										}
									}
								});
								JLabel lblSegundaParcela = new JLabel("Segunda parcela");
								JLabel lblPagementoEfetuado2 = new JLabel("Data em que o pagamento foi efetuado");
								JLabel lblDataDeVencimento_1 = new JLabel("Data de vencimento");
								JComboBox comboBox = new JComboBox();
								comboBox.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent arg0) {
										String escolha = (String) comboBox.getSelectedItem();
										
										
									if(escolha=="2 vezes"){
										
										pagef2Field.setVisible(true);
										
										datavenc2Field.setVisible(true);
										pagef2Field.setVisible(true);
										valor2Field.setVisible(true);
										valoref2Field.setVisible(true);
										lblPreoFinal_1.setVisible(true);
										lblDataDeVencimento_1.setVisible(true);
										lblStatus_1.setVisible(true);
										lblValorPago_1.setVisible(true);
										status2box.setVisible(true);
										lblSegundaParcela.setVisible(true);
										lblPagementoEfetuado2.setVisible(true);
										
									}else{
										calevenc1.setVisible(false);
										pagef2Field.setVisible(false);
										calepag2.setVisible(false);
										datavenc2Field.setVisible(false);
										pagef2Field.setVisible(false);
										valor2Field.setVisible(false);
										valoref2Field.setVisible(false);
										
										lblPreoFinal_1.setVisible(false);
										lblDataDeVencimento_1.setVisible(false);
										lblStatus_1.setVisible(false);
										lblValorPago_1.setVisible(false);
										status2box.setVisible(false);
										lblSegundaParcela.setVisible(false);
										lblPagementoEfetuado2.setVisible(false);
										
									}
									}
								});
							
								comboBox.addPropertyChangeListener(new PropertyChangeListener() {
									public void propertyChange(PropertyChangeEvent evt) {
									
									
									}
								});
								comboBox.setBounds(705, 39, 82, 26);
								panel.add(comboBox);
								comboBox.setFont(new Font("Dialog", Font.PLAIN, 15));
								comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u00C0 vista", "2 vezes"}));
								
								JLabel lblStatus = new JLabel("Status");
								lblStatus.setForeground(Color.WHITE);
								lblStatus.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblStatus, "cell 4 2,alignx left,aligny bottom");
								
								JLabel lblValorPago = new JLabel("Valor pago");
								lblValorPago.setForeground(Color.WHITE);
								lblValorPago.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblValorPago, "cell 6 2,alignx left,aligny bottom");
								
								valor1Field = new JTextField();
								valor1Field.setForeground(Color.WHITE);
								valor1Field.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(valor1Field, "cell 0 3,growx,aligny top");
								valor1Field.setColumns(10);
								
								JLabel lblPrimeiraParcela = new JLabel("Valor da primeira parcela");
								lblPrimeiraParcela.setHorizontalAlignment(SwingConstants.TRAILING);
								lblPrimeiraParcela.setForeground(Color.WHITE);
								lblPrimeiraParcela.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblPrimeiraParcela, "cell 0 2,alignx left,aligny bottom");
								
								
								calevenc1.addPropertyChangeListener(new PropertyChangeListener() {
									public void propertyChange(PropertyChangeEvent arg0) {
										if(calevenc1.isVisible()==true|datadevenc1Field.isFocusOwner()==true){
										SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
										String data = spd.format(calevenc1.getDate());
										datadevenc1Field.setText(data);
										}
									}
								});
								
								datadevenc1Field = new JTextField();
								datadevenc1Field.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										calevenc1.setVisible(true);
										SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
										String data = spd.format(calevenc1.getDate());
										datadevenc1Field.setText(data);
										
										
									}
								});
								datadevenc1Field.setHorizontalAlignment(SwingConstants.CENTER);
								datadevenc1Field.setForeground(Color.WHITE);
								datadevenc1Field.setFont(new Font("Dialog", Font.PLAIN, 15));
								datadevenc1Field.addFocusListener(new FocusAdapter() {
									@Override
									public void focusGained(FocusEvent arg0) {
										
										
										
									}
								});
								pagamento.add(datadevenc1Field, "cell 2 3,growx,aligny top");
								datadevenc1Field.setColumns(10);
								
								pagefe1Field = new JTextField();
								pagefe1Field.setHorizontalAlignment(SwingConstants.CENTER);
								pagefe1Field.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										calepagef1.setVisible(true);
										SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
										String data = spd.format(calepagef1.getDate());
										pagefe1Field.setText(data);
									}
								});
								
								JComboBox status1box = new JComboBox();
								status1box.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent e) {
										if(status1box.getSelectedItem()=="Pendente"){
										pagefe1Field.setEnabled(false);
										valoref1Field.setEnabled(false);										
									
										
									}else{
										pagefe1Field.setEnabled(true);
										valoref1Field.setEnabled(true);										
									
									}
									}
								});
								status1box.setForeground(Color.WHITE);
								status1box.setFont(new Font("Dialog", Font.PLAIN, 15));
								status1box.setModel(new DefaultComboBoxModel(new String[] {"Pendente", "Pago"}));
								pagamento.add(status1box, "cell 4 3,grow");
								
								valoref1Field = new JTextField();
								valoref1Field.setForeground(Color.WHITE);
								valoref1Field.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(valoref1Field, "cell 6 3,grow");
								valoref1Field.setColumns(10);
								pagefe1Field.setForeground(Color.WHITE);
								pagefe1Field.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(pagefe1Field, "cell 8 3,growx,aligny top");
								pagefe1Field.setColumns(10);
								pagamento.add(calevenc1, "cell 2 4,grow");
								
								
								calepagef1.addPropertyChangeListener(new PropertyChangeListener() {
									public void propertyChange(PropertyChangeEvent arg0) {
										if(pagefe1Field.isFocusOwner()==true||calepagef1.isVisible()==true){
										SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
										String data = spd.format(calepagef1.getDate());
										pagefe1Field.setText(data);
										}
									}
								});
								
								
								pagamento.add(calepagef1, "cell 8 4,grow");
								
								
								
								valor2Field = new JTextField();
								valor2Field.setForeground(Color.WHITE);
								valor2Field.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(valor2Field, "cell 0 6,growx,aligny top");
								valor2Field.setColumns(10);
								
								datavenc2Field = new JTextField();
								datavenc2Field.setHorizontalAlignment(SwingConstants.CENTER);
								datavenc2Field.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										calevenc2.setVisible(true);
										SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
										String data = spd.format(calevenc2.getDate());
										datavenc2Field.setText(data);
									}
								});
								datavenc2Field.setForeground(Color.WHITE);
								datavenc2Field.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(datavenc2Field, "cell 2 6,growx,aligny top");
								datavenc2Field.setColumns(10);
								
								pagef2Field = new JTextField();
								pagef2Field.setHorizontalAlignment(SwingConstants.CENTER);
								pagef2Field.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										calepag2.setVisible(true);
										SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
										String data = spd.format(calepag2.getDate());
										pagef2Field.setText(data);
									}
								});
								
								status2box.setForeground(Color.WHITE);
								status2box.setFont(new Font("Dialog", Font.PLAIN, 15));
								status2box.setModel(new DefaultComboBoxModel(new String[] {"Pendente", "Pago"}));
								pagamento.add(status2box, "cell 4 6,grow");
								
								valoref2Field = new JTextField();
								valoref2Field.setForeground(Color.WHITE);
								valoref2Field.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(valoref2Field, "cell 6 6,growx,aligny center");
								valoref2Field.setColumns(10);
								pagef2Field.setForeground(Color.WHITE);
								pagef2Field.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(pagef2Field, "cell 8 6,growx,aligny top");
								pagef2Field.setColumns(10);
								calevenc2.addPropertyChangeListener(new PropertyChangeListener() {
									public void propertyChange(PropertyChangeEvent arg0) {
										if(datavenc2Field.isFocusOwner()==true||calevenc2.isVisible()==true){
										SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
										String data = spd.format(calevenc2.getDate());
										datavenc2Field.setText(data);
										}
									}
								});
								
								pagamento.add(calevenc2, "cell 2 7,grow");
								calevenc2.setVisible(false);
								calepagef1.setVisible(false);
								calepag2.addPropertyChangeListener(new PropertyChangeListener() {
									public void propertyChange(PropertyChangeEvent evt) {
										if(pagefe1Field.isFocusOwner()==true||calepag2.isVisible()==true){
											SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
											String data = spd.format(calepag2.getDate());
											pagefe1Field.setText(data);
											}
									}
								});
								calepag2.setVisible(false);
								
								pagamento.add(calepag2, "cell 8 7,grow");
								
							
								lblSegundaParcela.setForeground(Color.WHITE);
								lblSegundaParcela.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblSegundaParcela, "cell 0 5,alignx left,aligny bottom");
								
								JButton btnNewButton_1 = new JButton("New button");
								pagamento.add(btnNewButton_1, "flowx,cell 8 8,alignx left,aligny top");
								
								
								lblDataDeVencimento_1.setForeground(Color.WHITE);
								lblDataDeVencimento_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblDataDeVencimento_1, "cell 2 5,growx,aligny top");
								
								
								lblPagementoEfetuado2.setForeground(Color.WHITE);
								lblPagementoEfetuado2.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamento.add(lblPagementoEfetuado2, "cell 8 5,growx,aligny top");
								
								JButton btnNewButton_2 = new JButton("New button");
								pagamento.add(btnNewButton_2, "cell 8 8,alignx right,aligny top");
								
								JButton btnNewButton = new JButton("New button");
								btnNewButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
									}
								});
								pagamento.add(btnNewButton, "cell 8 8,alignx right,aligny top");
								calevenc1.setVisible(false);
								pagef2Field.setVisible(false);
								calepag2.setVisible(false);
								datavenc2Field.setVisible(false);
								pagef2Field.setVisible(false);
								valor2Field.setVisible(false);
								valoref2Field.setVisible(false);
								lblPreoFinal_1.setVisible(false);
								lblDataDeVencimento_1.setVisible(false);
								lblStatus_1.setVisible(false);
								lblValorPago_1.setVisible(false);
								status2box.setVisible(false);
								lblSegundaParcela.setVisible(false);
								lblPagementoEfetuado2.setVisible(false);
								pagefe1Field.setEnabled(false);
								valoref1Field.setEnabled(false);	
								pagef2Field.setEnabled(false);
								valoref2Field.setEnabled(false);	
								JPanel exibirpanel = new JPanel();
								exibirpanel.setBackground(Color.DARK_GRAY);
								tabbedPane.addTab("Selecionar Roupas", null, exibirpanel, null);
								exibirpanel.setLayout(new MigLayout("", "[128px,grow][42px][124px][168px][133.00px,grow][16.00][623px,grow]", "[][311px][23px][47.00px][25px][42.00px][25px][42.00px][25px][55.00px]"));
								
								JLabel lblbtnRemover = new JLabel("");
								lblbtnRemover.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										lblbtnRemover.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/remover3.png")));
										int linha = tabelaRoupasele.getSelectedRow();
									    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
									    Fachada.getInstancia().ExcluirRoupaSeleEdi(r);
									    carregarTabelaRoupasele();
									    carregarTabelaRoupa();
									}
									public void mouseEntered(MouseEvent arg0) {
										lblbtnRemover.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/remover2.png")));
										
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnRemover.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/remover1.png")));
									}
									public void mouseReleased(MouseEvent e) {
										lblbtnRemover.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/remover1.png")));
									}
								});
								
								JLabel lblbtnAdicionar = new JLabel("");
								lblbtnAdicionar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										lblbtnAdicionar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/adicionar3.png")));
										   int linha = tabelaRoupa_1.getSelectedRow();
										  //  r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
										    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
											   Fachada.getInstancia().InserirRoupaEdi(r, c);
											   carregarTabelaRoupasele();
											   carregarTabelaRoupa();
										  
									}
									@Override
									public void mouseEntered(MouseEvent arg0) {
										lblbtnAdicionar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/adicionar2.png")));
										
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnAdicionar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/Adicionar1.png")));
									}
									public void mouseReleased(MouseEvent e) {
										lblbtnAdicionar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/Adicionar1.png")));
									}
								});
								
								JLabel lblRoupasDisponiveis = new JLabel("Roupas dispon\u00EDveis");
								lblRoupasDisponiveis.setForeground(Color.WHITE);
								lblRoupasDisponiveis.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblRoupasDisponiveis, "cell 0 0 2 1");
								
								JLabel lblRoupasSelecionadas = new JLabel("Roupas selecionadas");
								lblRoupasSelecionadas.setForeground(Color.WHITE);
								lblRoupasSelecionadas.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblRoupasSelecionadas, "cell 6 0");
								
								textField = new JTextField();
								textField.setFont(new Font("Dialog", Font.PLAIN, 15));
								textField.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent arg0) {
									if(textField.getText().isEmpty()){
										carregarTabelaRoupa();
									}
									}
								});
								exibirpanel.add(textField, "cell 0 2 2 1,grow");
								textField.setColumns(10);
								
								JLabel lblbtnPesquisar = new JLabel("");
								lblbtnPesquisar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar3.png")));
										pesq2 =Integer.parseInt(textField.getText());
										carregarTabelaRoupaListacod();
									}
									
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
									}
								
								
																	
								});
								lblbtnPesquisar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/pesquisar1.png")));
								exibirpanel.add(lblbtnPesquisar, "cell 2 2");
								
								JLabel lblbtnlista = new JLabel("");
								lblbtnlista.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										lblbtnlista.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/lista3.png")));
										carregarTabelaRoupa();
									}
									
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnlista.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/lista2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnlista.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/lista1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnlista.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/lista1.png")));
									}
								
								});
								lblbtnlista.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/lista1.png")));
								exibirpanel.add(lblbtnlista, "cell 3 2,alignx center");
								lblbtnAdicionar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/Adicionar1.png")));
								exibirpanel.add(lblbtnAdicionar, "cell 4 2");
								lblbtnRemover.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/remover1.png")));
								exibirpanel.add(lblbtnRemover, "cell 6 2,alignx right,aligny center");
								
								
								precoField2.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(precoField2, "cell 6 8,grow");
								
								JLabel lbltipo = new JLabel("Tipo");
								lbltipo.setForeground(Color.WHITE);
								lbltipo.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										 int linha = tabelaRoupa_1.getSelectedRow();
										    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
										   Fachada.getInstancia().InserirRoupaSele(r);
										   carregarTabelaRoupasele();
									}
								});
								lbltipo.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lbltipo, "flowx,cell 0 3,grow");
								
								JLabel lblModelo = new JLabel("Modelo");
								lblModelo.setForeground(Color.WHITE);
								lblModelo.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblModelo, "cell 6 3,grow");
								
								JLabel lblCor = new JLabel("Cor");
								lblCor.setForeground(Color.WHITE);
								lblCor.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblCor, "cell 0 7 5 1,grow");
								
								tamanhoField = new JTextField();
								tamanhoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								tamanhoField.setColumns(10);
								exibirpanel.add(tamanhoField, "cell 0 6 5 1,grow");
								
								corField = new JTextField();
								corField.setFont(new Font("Dialog", Font.PLAIN, 15));
								corField.setColumns(10);
								exibirpanel.add(corField, "cell 0 8 5 1,grow");
								
								JLabel lblTamanho = new JLabel("Tamanho");
								lblTamanho.setForeground(Color.WHITE);
								lblTamanho.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblTamanho, "flowy,cell 0 5 5 1,growx,aligny top");
								
								JLabel lblGenero = new JLabel("Genero");
								lblGenero.setForeground(Color.WHITE);
								lblGenero.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblGenero, "cell 6 5,growx,aligny top");
								
								tipoField = new JTextField();
								tipoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								tipoField.setColumns(10);
								exibirpanel.add(tipoField, "cell 0 4 5 1,grow");
								
								modeloField = new JTextField();
								modeloField.setFont(new Font("Dialog", Font.PLAIN, 15));
								modeloField.setColumns(10);
								exibirpanel.add(modeloField, "cell 6 4,grow");
								
								JLabel lblPreo = new JLabel("Pre\u00E7o");
								lblPreo.setForeground(Color.WHITE);
								lblPreo.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblPreo, "cell 6 7,grow");
								
								generoField = new JTextField();
								generoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								generoField.setColumns(10);
								exibirpanel.add(generoField, "cell 6 6,grow");
								
								
								///
								
								tabelaRoupasele = new JTable(new RoupaTableModel());
								tabelaRoupasele.setFont(new Font("Dialog", Font.PLAIN, 15));
								tabelaRoupasele.addMouseListener(new MouseAdapter() {
									@SuppressWarnings("unused")
									public void tabelaRoupasele(MouseEvent arg0) {
										srow = tabelaRoupaAluguel.getSelectedRow();
										
										svaluecoder = (int) tabelaRoupasele.getValueAt(srow, 0);
										
									}
									
								});
								
								tabelaRoupasele.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								JScrollPane scrollPaneRoupaAluguel = new JScrollPane(tabelaRoupasele);
								exibirpanel.add(scrollPaneRoupaAluguel, "cell 6 1,grow");
								scrollPaneRoupaAluguel.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										if(e.getClickCount() == 2) {
											int linha = tabelaRoupasele.getSelectedRow();
										    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
										    Fachada.getInstancia().ExcluirRoupaSeleEdi(r);
										    carregarTabelaRoupasele();
										    carregarTabelaRoupa();
										}
									}
									
								});
							
								////
								
								tabelaRoupa_1 = new JTable(new RoupaTableModel());
								tabelaRoupa_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								tabelaRoupa_1.addMouseListener(new MouseAdapter() {
									public void mouseReleased(MouseEvent arg0) {
										srow = tabelaRoupa_1.getSelectedRow();
										
										svaluecoder = (int) tabelaRoupa_1.getValueAt(srow, 0);
										Fachada.getInstancia().BuscarRoupa(r);
										tipoField.setText(r.getTipo());
										modeloField.setText(r.getModelo());
										tamanhoField.setText(r.getTamanho());
										corField.setText(r.getCor());
										generoField.setText(r.getGenero());
										
										
									}
									
								});
								
								tabelaRoupa_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								JScrollPane scrollPaneRoupa = new JScrollPane(tabelaRoupa_1);
								exibirpanel.add(scrollPaneRoupa, "cell 0 1 5 1,grow");
								
								JLabel btnlblAvancar2 = new JLabel("");
								btnlblAvancar2.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
									/*	int linha = 0;
										 
										int linhat = tabelaRoupasele.getRowCount();
										
										while(linha < linhat){
										r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));
										r.setTipo( (String) tabelaRoupasele.getValueAt(linha, 1));
										r.setModelo( (String) tabelaRoupasele.getValueAt(linha, 2));
										r.setTamanho( (String) tabelaRoupasele.getValueAt(linha, 3));
										r.setGenero( (String) tabelaRoupasele.getValueAt(linha, 4));
										r.setCor( (String) tabelaRoupasele.getValueAt(linha, 5));
										r.setPreco( (float) tabelaRoupasele.getValueAt(linha, 6));
								
										linha++;
									
										Fachada.getInstancia().InserirLista(r, c);
										
										}
										*/
										if(tabelaRoupasele.getRowCount()==0){
											JOptionPane.showMessageDialog(null, "Selecione alguma roupa.");
										}else{
										funcioField.setText(funcField.getText());
										nomeField2.setText(c.getNome());
										carregarTabelaRoupaLista();
										Fachada.getInstancia().SomaPreco(a);
										precoFieldal.setText(""+a.getPreco());
										tabbedPane.setSelectedIndex(2);
										}
										
										
									}
									@Override
									public void mouseEntered(MouseEvent arg0) {
										btnlblAvancar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										btnlblAvancar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										btnlblAvancar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar1.png")));
									}
								});
								
								JLabel lblbtnVoltar = new JLabel("");
								lblbtnVoltar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										lblbtnVoltar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR3.png")));
										tabbedPane.setSelectedIndex(0);
										Fachada.getInstancia().limparLista();
									}
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnVoltar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnVoltar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnVoltar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR1.png")));
									}
								});
								lblbtnVoltar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR1.png")));
								exibirpanel.add(lblbtnVoltar, "flowx,cell 6 9,alignx right");
								btnlblAvancar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar1.png")));
								exibirpanel.add(btnlblAvancar2, "cell 6 9,alignx right");
								scrollPaneRoupa.addMouseListener(new MouseAdapter() {
								});
								
								
								tabelaRoupa_1.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent e) {
										if(e.getClickCount() == 2) {											 
										
											   int linha = tabelaRoupa_1.getSelectedRow();
											    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
											    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
												   Fachada.getInstancia().InserirRoupaEdi(r, c);
												   carregarTabelaRoupasele();
												   carregarTabelaRoupa();
										
									} else {
										   
									}
								}
									
								});
								tabelaRoupasele.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent e) {
										if(e.getClickCount()==2){
											int linha = tabelaRoupasele.getSelectedRow();
										    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
										    Fachada.getInstancia().ExcluirRoupaSeleEdi(r);
										    carregarTabelaRoupasele();
										    carregarTabelaRoupa();
										}
									}
								});
								
								
								tabelaRoupa_1.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
	srow = tabelaRoupa_1.getSelectedRow();
	
	//r.setCodRoupa( (int) tabelaRoupa_1.getValueAt(srow, 0));
	Fachada.getInstancia().BuscarRoupa(r);
	tipoField.setText(r.getTipo());
	modeloField.setText(r.getModelo());
	tamanhoField.setText(r.getTamanho());
	corField.setText(r.getCor());
	generoField.setText(r.getGenero());
	precoField2.setText(""+r.getPreco());
								if(e.getClickCount() == 2) {
								

}
}
});
								
			JPanel editPanel = new JPanel();
			editPanel.setBackground(Color.DARK_GRAY);
								tabbedPane.addTab("Concluir Aluguel", null, editPanel, null);
								
								///
								tabelaRoupaAluguel = new JTable(new RoupaTableModel());
								tabelaRoupaAluguel.addMouseListener(new MouseAdapter() {
									public void mouseReleased(MouseEvent arg0) {
										srow = tabelaRoupaAluguel.getSelectedRow();
										
										svaluecoder = (int) tabelaRoupaAluguel.getValueAt(srow, 0);
										
									}
									
								});
								editPanel.setLayout(new MigLayout("", "[115px][30px][115px][30px][115px][30px][115px][30px][115,grow][30][115,grow][652px,grow]", "[14px][30.00px][][465.00px][54.00px][20px][grow]"));
								
								JLabel lblRoupasSelecionadas_1 = new JLabel("Roupas Selecionadas");
								lblRoupasSelecionadas_1.setForeground(Color.WHITE);
								lblRoupasSelecionadas_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								editPanel.add(lblRoupasSelecionadas_1, "cell 0 2");
								
								
								
								
								tabelaRoupaAluguel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								JScrollPane scrollPaneRoupasele = new JScrollPane(tabelaRoupaAluguel);
								editPanel.add(scrollPaneRoupasele, "cell 0 3 12 1,grow");
								scrollPaneRoupasele.addMouseListener(new MouseAdapter() {
								});
								
								
								
								
								JLabel nomelabel2 = new JLabel("Nome");
								nomelabel2.setForeground(Color.WHITE);
								editPanel.add(nomelabel2, "cell 0 0,alignx left,aligny top");
								
								nomeField2 = new JTextField();
								nomeField2.setEditable(false);
								nomeField2.setColumns(10);
								editPanel.add(nomeField2, "cell 0 1 12 1,grow");
								
								JLabel lblDataDeLocao = new JLabel("Data de loca\u00E7\u00E3o");
								lblDataDeLocao.setFont(new Font("Dialog", Font.PLAIN, 15));
								lblDataDeLocao.setForeground(Color.WHITE);
								editPanel.add(lblDataDeLocao, "cell 0 4,growx,aligny bottom");
								
								JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
								lblFuncionrio.setForeground(Color.WHITE);
								lblFuncionrio.setFont(new Font("Dialog", Font.PLAIN, 15));
								editPanel.add(lblFuncionrio, "cell 8 4,aligny bottom");
								
								try {
									MaskFormatter mascara = new MaskFormatter("##/##/####");
									mascara.setPlaceholderCharacter('_');
									dataLoca = new JFormattedTextField(mascara);
									dataLoca.setFont(new Font("Dialog", Font.PLAIN, 15));
									editPanel.add(dataLoca, "cell 0 5,grow");
									dataLoca.setColumns(10);
									
									
									
									
								
								} catch (ParseException e1) {
									
									e1.printStackTrace();
								}
							
								
								JLabel lblDataDeDevoluo = new JLabel("Data de Devolu\u00E7\u00E3o");
								lblDataDeDevoluo.setFont(new Font("Dialog", Font.PLAIN, 15));
								lblDataDeDevoluo.setForeground(Color.WHITE);
								editPanel.add(lblDataDeDevoluo, "cell 2 4,alignx left,aligny bottom");
								
								try {
									MaskFormatter mascara = new MaskFormatter("##/##/####");
									mascara.setPlaceholderCharacter('_');
									DataDevo = new JFormattedTextField(mascara);
									DataDevo.setFont(new Font("Dialog", Font.PLAIN, 15));
									editPanel.add(DataDevo, "cell 2 5,grow");
									DataDevo.setColumns(10);
									
									
									
									
								
								} catch (ParseException e1) {
									
									e1.printStackTrace();
								}
								
								
								precoFieldal = new JTextField();
								precoFieldal.setFont(new Font("Dialog", Font.PLAIN, 15));
								precoFieldal.setEditable(false);
								editPanel.add(precoFieldal, "cell 4 5,grow");
								precoFieldal.setColumns(10);
								
								precoFieldFim = new JTextField();
								precoFieldFim.setFont(new Font("Dialog", Font.PLAIN, 15));
								editPanel.add(precoFieldFim, "cell 6 5,grow");
								precoFieldFim.setColumns(10);
								
							
								
								JLabel lblbtnVoltar2 = new JLabel("");
								lblbtnVoltar2.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										lblbtnVoltar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR3.png")));
										tabbedPane.setSelectedIndex(1);
									}
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnVoltar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnVoltar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnVoltar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR1.png")));
									}
								});
								
								funcioField = new JTextField();
								funcioField.setFont(new Font("Dialog", Font.PLAIN, 15));
								funcioField.setEditable(false);
								editPanel.add(funcioField, "cell 8 5,grow");
								funcioField.setColumns(10);
								
								JComboBox pagamentoBox = new JComboBox();
								pagamentoBox.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamentoBox.setModel(new DefaultComboBoxModel(new String[] {"\u00C0 vista", "2 vezes"}));
								editPanel.add(pagamentoBox, "cell 10 5,grow");
								lblbtnVoltar2.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/VOLTAR1.png")));
								editPanel.add(lblbtnVoltar2, "flowx,cell 11 5,alignx right");
								
								JLabel lblbtnsalvar = new JLabel("");
								lblbtnsalvar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										if(dataLoca.getText().isEmpty()||DataDevo.getText().isEmpty()||precoFieldFim.getText().isEmpty()){
											JOptionPane.showMessageDialog(null, "Erro. H� campos em branco.");
										}else{
										int i= 0;	
										int tamanho = tabelaRoupaAluguel.getModel().getRowCount();
										while(i<tamanho){
										
											lblbtnsalvar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/salvar3.png")));
											r.setCodRoupa((int) tabelaRoupaAluguel.getValueAt(i, 0));
											r.setTipo((String) tabelaRoupaAluguel.getValueAt(i, 1));
											r.setModelo((String) tabelaRoupaAluguel.getValueAt(i, 2));
											r.setTamanho((String) tabelaRoupaAluguel.getValueAt(i, 3));
											r.setGenero((String) tabelaRoupaAluguel.getValueAt(i, 4));
											r.setCor((String) tabelaRoupaAluguel.getValueAt(i, 5));
											r.setPreco((float) tabelaRoupaAluguel.getValueAt(i, 6));
											
											
											Fachada.getInstancia().InserirListaFinal(r, c);
											Fachada.getInstancia().dispinibilidade(r);
											
											i++;
											}
										}
										
										a.setPagamento(pagamentoBox.getSelectedItem().toString());
										a.setCodCliente(c.getCodCliente());
										a.setDataLoca(dataLoca.getText());
										a.setDataEntre(DataDevo.getText());
										a.setPreco(Float.parseFloat((precoFieldal.getText())));
										a.setPrecoTotal(Float.parseFloat((precoFieldFim.getText())));
										
									    f.setLogin(funcioField.getText());
										Fachada.getInstancia().InserirRegistro(a,f);
										Fachada.getInstancia().limparLista();
										tabbedPane.setSelectedIndex(0);
										
									}
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnsalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar2.png")));
										
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnsalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
										
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnsalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
									}
								});
								lblbtnsalvar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/salvar1.png")));
								editPanel.add(lblbtnsalvar, "cell 11 5,alignx right");
					tabelaCategoria.addMouseListener(new MouseAdapter() {
						
						
					});
					
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			
			
			public void mouseClicked(MouseEvent e) {
				srow = tabelaCategoria.getSelectedRow();
				svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
				svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
				c.setNome(svalueName);
				
				String pesq = "";
				pesq = svalueName;
				
				Fachada.getInstancia().BuscarClientenome(c,pesq);
				nomeField.setText(c.getNome());
				cpfField.setText(""+c.getCPF());
				
				cidadeField.setText(c.getCidade());
				estadoField.setText(c.getEstado());
				enderecoField.setText(c.getEndereco());
				numeroField.setText(""+c.getNumero());
				bairroField.setText(c.getBairro());
				telefoneField.setText(""+c.getTelefone());
				
				
					if(e.getClickCount() == 2) {
						 pesq = c.getCPF();
						 int opcao = JOptionPane.showConfirmDialog(null, "Deseja selecionar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
							
							if (opcao == 0){
						Fachada.getInstancia().BuscarClienteCPF(c, pesq);
						
						Fachada.getInstancia().limparTabela();
						Fachada.getInstancia().BuscarRoupaEd(r);
						Fachada.getInstancia().ListarRoupaEdi(r,c);
						carregarTabelaRoupasele();
						
						btnlblAvancar.setIcon(new ImageIcon(JAluguel2.class.getResource("/imagens/avan\u00E7ar3.png")));
						 pesq = c.getCPF();
						Fachada.getInstancia().BuscarClienteCPF(c, pesq);
						
						tabbedPane.setSelectedIndex(1);
							}
			
			}
			}
		});
		
		
			
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
			
				
			}
			});
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			
		
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		 
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			
		
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
	

	//carregarTabela();

	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClientes()) {
			tableModel.adicionarCategoria(cat);
		}
	}
	public void carregarTabelanome() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listartodosClientespesq(pesq)) {
			tableModel.adicionarCategoria(cat);
		}
	}
	
	public void carregarTabelaRoupa() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa_1.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupasSeleEdi()) {
			tableModel.adicionarCategoria(rou);
		}
	}
	
	public void carregarTabelaRoupasele() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupasele.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupaLista()) {
			tableModel.adicionarCategoria(rou);
		}
	}
	
	public void carregarTabelaRoupaLista() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupaAluguel.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupaLista()) {
			tableModel.adicionarCategoria(rou);
		}
	}
		public void carregarTabelaRoupaListacod() {
			RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa_1.getModel();
			tableModel.setRowCount(0);
			for(Roupa rou : Fachada.getInstancia().listartodasRoupascod(pesq2)) {
				tableModel.adicionarCategoria(rou);
			}
	}
	
	public void limparFields(){
		nomeField.setText("");
		cpfField.setText("");
		cidadeField.setText("");
		estadoField.setText("");
		enderecoField.setText("");
		numeroField.setText("");
		bairroField.setText("");
		telefoneField.setText("");
		nomeField2.setText("");
		tipoField.setText("");
		modeloField.setText("");
		precoField2.setText("");
		precoFieldFim.setText("");
		generoField.setText("");
		dataLoca.setText("");
		DataDevo.setText("");
		tamanhoField.setText("");
		corField.setText("");
		precoFieldal.setText("");
		tabbedPane.setSelectedIndex(0);
		funcioField.setText("");
		
	}
}
