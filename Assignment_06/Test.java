import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            JFrame frame = new JFrame();
            frame.setSize(50*i+50, 50*i+50);
            frame.setTitle(""+i);
            frame.setVisible(true);
        }
    }
}
