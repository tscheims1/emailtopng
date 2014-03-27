package mailgif;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame implements ActionListener{
	JButton saveImage;
	JTextField input;
	JLabel info;
	imageMaker imageMaker;
	
	public Gui() {
		imageMaker = new imageMaker();
		
		JFrame frame = new JFrame();
		frame.setTitle("Mail to Gif");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		saveImage = new JButton("Bild Speichern");
		info = new JLabel("Hier Mail eingeben");
		input = new JTextField(10);
		
		saveImage.addActionListener(this);
		input.addActionListener(this);
		
		panel.add(input);
		panel.add(saveImage);
		panel.add(info);

		frame.setSize(300, 200);
		frame.setLocation(50, 50);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == saveImage){
			imageMaker.setMailText(input.getText());
			info.setText("Button 1 wurde jetzt betätigt");
			JFileChooser f = new JFileChooser();    
			f.showSaveDialog(f);
			try{
				imageMaker.setPath(f.getSelectedFile().getAbsolutePath());
				imageMaker.createImage();
				System.out.print(f.getSelectedFile().getAbsolutePath()+"__sdfsdfs");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		else{
			System.out.print("Nichts gefunden");
		}
	}

}
