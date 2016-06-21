package poo.gui.myframes;

import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.JFrame;

import poo.excecoes.EmentaNaoExisteException;




import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;
import com.sun.prism.Image;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * An example of using the PagePanel class to show PDFs. For more advanced
 * usage including navigation and zooming, look ad the
 * com.sun.pdfview.PDFViewer class.
 *
 * @author joshua.marinacci@sun.com
 */
public class PdfView {
	int tamanho = 0;
	int paginaAutal = 0;
	PDFPage page1 = null;
	PDFFile pdffile = null;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	PagePanel panel;
	JFrame frame;
	JPanel panel_1;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("unused")
	public void setup(String codigo) throws IOException{
		initComponents(codigo);
		System.out.println("TAMANHO DESTA PORRA: "+tamanho);
		//set up the frame and panel
		frame = new JFrame("PDF Viewer");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Thiago Gomes\\Desktop\\IMAGENS DIVERSAS\\pdf_icon_32.png"));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new PagePanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);

		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnActionAnt(e);
			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnActionPrimeira(e);
			}
		});
		panel_1.add(btnNewButton_3);
		panel_1.add(btnNewButton_1);

		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnActionProx(e);
			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnActionUltima(e);

			}
		});
		panel_1.add(btnNewButton_2);
		frame.pack();
		frame.setVisible(true);

		//load a pdf from a byte buffer

//		File file = new File("EMENTAS\\" + codigo+".pdf");
//		if(file != null){
//			RandomAccessFile raf = new RandomAccessFile(file, "r");
//			FileChannel channel = raf.getChannel();
//			ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,
//					0, channel.size());
//			pdffile = new PDFFile(buf);
//			page1 = pdffile.getPage(0);
//			tamanho = pdffile.getNumPages();
//			panel.showPage(page1);
//		}

	}
	
	public void initComponents(String codigo) throws IOException{
		File file = new File("EMENTAS\\" + codigo+".pdf");
		if(file != null){
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			FileChannel channel = raf.getChannel();
			ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,
					0, channel.size());
			pdffile = new PDFFile(buf);
			tamanho = pdffile.getNumPages();
			btnNewButton = new JButton("Proxima");
			btnNewButton_1 = new JButton("Anterior");
			btnNewButton_2 = new JButton("Ultima");
			btnNewButton_3 = new JButton("Primeira");
		}
	}

	
	private void jbtnActionPrimeira(ActionEvent evt){
		page1 =  pdffile.getPage(0);
		panel.showPage(page1);		
	}
	
	private void jbtnActionUltima(ActionEvent evt){
		page1 =  pdffile.getPage(tamanho -1);
		System.out.println("Pagina atual: "+(tamanho-1));
		panel.showPage(page1);		
	}
	
	private void jbtnActionProx(ActionEvent evt){
		if(paginaAutal != (tamanho-1)){
			page1 =  pdffile.getPage(paginaAutal+1);
			System.out.println("Pagina atual: "+paginaAutal+1);
			panel.showPage(page1);
			paginaAutal++;
		}		
	}
	
	private void jbtnActionAnt(ActionEvent evt){
		if(paginaAutal != (0)){
			page1 =  pdffile.getPage(paginaAutal-1);
			System.out.println("Pagina atual: "+(paginaAutal-1));
			panel.showPage(page1);
			paginaAutal--;
		}	
	}

	public void  pagedelay(int delay){
		int showtime = delay;
		/*Thread viewThread = new Thread();
        viewThread = Thread.currentThread();
        /*synchronized(viewThread){*/
		try {Thread.sleep(delay*100);}
		catch(InterruptedException e){
			System.out.println("thrown");      

		}

	}
}

