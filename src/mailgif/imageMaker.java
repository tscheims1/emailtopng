package mailgif;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class imageMaker{
	String mailText = "sample@gmail.com";
    File file;
    String path;
    Font font = new Font("Tahoma", Font.PLAIN, 18);
    FontRenderContext frc = new FontRenderContext(null, true, true);
     
    Rectangle2D bounds ; /*= font.getStringBounds(mailText, frc);*/
    int w = 1; // = (int) bounds.getWidth();
    int h = 1; // = (int) bounds.getHeight();
    
    //create a BufferedImage object
   BufferedImage image;
    
    //calling createGraphics() to get the Graphics2D
    Graphics2D g;
    
    
    // set new Mail Text and set bounds 
    public void setMailText(String s){
    	mailText = s;
    	bounds = font.getStringBounds(mailText, frc);
    	w = (int) bounds.getWidth();
        h = (int) bounds.getHeight();
        image = new BufferedImage(w, h,   BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();
    }
    
    // set Path
    public void setPath(String s){
    	this.path = s;
    }
    
    
    // creates the Image
    public void createImage() throws IOException{
    //set color and other parameters
    g.setBackground(Color.WHITE);
    g.fillRect(0, 0, w, h);
    g.setColor(Color.BLACK);
    g.setFont(font);
         
   g.drawString(mailText, (float) bounds.getX(), (float) -bounds.getY());
   
   file = new File(path+".png");
   
  //releasing resources
  g.dispose();
    //creating the file
  ImageIO.write(image, "png", file);
   }
}
