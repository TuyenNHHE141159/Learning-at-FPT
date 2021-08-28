
/**
 *Title:             Move A Eye
 * Files:            MoveAEyeFrame.java
 * Semester:         LAB Desk Summer- Block 5 2021
 * Author:           TuyenNH
 * Email:            tuyennhhe141159@fpt.edu.vn
 * CS Login:         User
 * Lecturer's Name:  DuongTB
 * Lab Section:      4
 */
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author User
 */
public class MoveAEyeFrame extends javax.swing.JFrame {

    private final int x;
    private final int y;
    //coordinates x of mouse
    private int xMouse;
    //coordinates y of mouse
    private int yMouse;
    //diamater of eye (big circle)
    private final int eyeDiameter = 150;
    //diamater pupil eye (small circle)
    private final int pupilDiameter = 30;
    //distance between 2 big circle
    private final int distanceTwoEyes = 10;

    /**
     * Creates new form MoveAEyeFrame
     */
    public MoveAEyeFrame() {
        initComponents();

        x = this.getWidth() / 2;
        y = this.getHeight() / 2;
    }

    /**
     * Draw rectangle
     *
     * @param graphics type Graphics
     * @param x type int
     * @param y type int
     * @param w type int
     * @param h type int
     * @param color type Color
     */
    public void doPaintRect(Graphics graphics, int x, int y, int w, int h, Color color) {
        graphics.drawRect(x, y, w, h);
        graphics.setColor(color);
        graphics.fillRect(x, y, w, h);
    }

    /**
     * Draw Oval
     *
     * @param graphics type Graphics
     * @param x type int
     * @param y type int
     * @param w type int
     * @param h type int
     * @param color type Color
     */
    public void doPaintOval(Graphics graphics, int x, int y, int w, int h, Color color) {

        graphics.drawOval(x, y, w, h);
        graphics.setColor(color);
        graphics.fillOval(x, y, w, h);
    }

    /**
     * Draw eyes
     *
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics) {
        doPaintRect(graphics, 0, 0, this.getWidth(), this.getHeight(), Color.LIGHT_GRAY);
        doPaintOval(graphics, x - distanceTwoEyes - eyeDiameter, y, eyeDiameter, eyeDiameter, Color.white);
        doPaintOval(graphics, x, y, eyeDiameter, eyeDiameter, Color.white);
        //up postion
        if (yMouse < y) {
            //left eye
            doPaintOval(graphics, x - distanceTwoEyes - eyeDiameter / 2 - pupilDiameter / 2, y, pupilDiameter, pupilDiameter, Color.blue);
            //right eye
            doPaintOval(graphics, x + eyeDiameter / 2 - pupilDiameter / 2, y, pupilDiameter, pupilDiameter, Color.blue);
        }
        //middle postion
        if (yMouse >= y && yMouse <= y + eyeDiameter) {
            //left eye
            doPaintOval(graphics, x - eyeDiameter / 2 - distanceTwoEyes - pupilDiameter / 2, y + eyeDiameter / 2 - pupilDiameter / 2,
                    pupilDiameter, pupilDiameter, Color.blue);
            //right eye
            doPaintOval(graphics, x + eyeDiameter / 2 - pupilDiameter / 2, y + eyeDiameter / 2 - pupilDiameter / 2,
                    pupilDiameter, pupilDiameter, Color.blue);
        }
        //down postion
        if (yMouse > y + eyeDiameter) {
            //left eye
            doPaintOval(graphics, x - distanceTwoEyes - eyeDiameter / 2 - pupilDiameter / 2,
                    y + eyeDiameter - pupilDiameter, pupilDiameter, pupilDiameter, Color.blue);
            //right eye
            doPaintOval(graphics, x + eyeDiameter / 2 - pupilDiameter / 2,
                    y + eyeDiameter - pupilDiameter, pupilDiameter, pupilDiameter, Color.blue);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Event when mouse move
     *
     * @param evt
     */
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        //assign for xMouse and yMouse (coordinates of mouse)
        xMouse = evt.getX();
        yMouse = evt.getY();
        repaint();
    }//GEN-LAST:event_formMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MoveAEyeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoveAEyeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoveAEyeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoveAEyeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoveAEyeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}