
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author leonardo
 */
public class View extends JPanel {
    
    private Vec2 mousePosition = new Vec2(0, 0);    
    private Eye leftEye = new Eye(450 - 50, 300, 50, 20);
    private Eye rightEye = new Eye(450 + 58, 300, 50, 20);
    public View() {
        setPreferredSize(new Dimension(800, 600));
        addMouseMotionListener(new MouseHandler());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        leftEye.draw(g, mousePosition);
        rightEye.draw(g, mousePosition);
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            mousePosition.setX(e.getX());
            mousePosition.setY(e.getY());
            repaint();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                JFrame frame = new JFrame();           
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(view);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
                view.requestFocus();
            }

        });
    }
    
}
