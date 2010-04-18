import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

public class Histogram extends JPanel {
    /**
     * Count the occurence of 26 letters
     * 
     */
    private int[] count;
    
    /**
     * Set letter count and repaint component
     * 
     */
    public void showHistogram(int[] count) {
       this.count = count;
       this.repaint();
    }
    
    /**
     * Paint the histogram
     * 
     */
    protected void paintComponent(Graphics g) {
        if (count == null) {
            // nothing to display
            return;
        }
        
        super.paintComponent(g);
        
        int width = this.getWidth();
        int height = this.getHeight();
        
        int interval = (width - 40) / this.count.length;
        int individualWidth = (int)(((width - 40) / 24) * 0.6);
        
        int maxCount = 0;
        for(int i = 0; i < this.count.length; i++) {
            if(maxCount < this.count[i]) {
                maxCount = this.count[i];
            }
        }
        
        int x = 30;
        
        g.drawLine(10, height - 45, width - 10, height - 45);
        for(int i = 0; i < this.count.length; i++) {
            int barHeight =
                (int)(((double)count[i] / maxCount) * (height - 55));
            
            g.drawRect(x, height - 45 - barHeight,
                       individualWidth, barHeight);
            
            g.drawString((char)(65 + i) + "", x, height - 30);
            
            x = x + interval;
        }
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(300,300);
    }   
}
