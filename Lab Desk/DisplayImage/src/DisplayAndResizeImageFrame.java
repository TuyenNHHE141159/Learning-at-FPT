// Main Class File:  DisplayAndResizeImageFrame.java
// File:             DisplayImage.java
// Semester:         Summer-Block 5 2021
// Author:           FPT University Copyright (2021). All rights reserved.
// CS Login:         User
// Author:          TuyenNH
// Bugs: none known
// Credits:          none

/**
 * Description:
 * When it comes to images, users could have images with differences size, to
 * have better look, we need to resize these images before displaying.
 *
 * @author TuyenNH
 */
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class DisplayAndResizeImageFrame extends javax.swing.JFrame {

    /**
     * Creates new form MyFrame
     */
    public DisplayAndResizeImageFrame() {
        initComponents();
        //call function to load image
        loadFileImages();
        this.setTitle("Display resize image");
    }
    private final ArrayList<JButton> buttons = new ArrayList<>();
    private final int size = 5;

    /**
     * Load image from file, create button contains image
     * No parameters
     * No return
     */
    private void loadFileImages() {
        try {

            File folder = new File("images");
            File[] files = folder.listFiles();//get array images
            jPanelButton.setPreferredSize(new Dimension(jToolBarButton.getWidth() - 15, 300));//set size for panel
            jPanelButton.setLayout(new FlowLayout());//set type of layout  
            //the first time, display the first image in array
            setImagesforLabel(jLabelImage, new ImageIcon("images" + "\\" + files[0].getName()));
            for (File file : files) {
                System.out.println(file.getName());
                //set size for panel
                JButton button = new JButton();
                button.setSize(100, 100);//set size for button
                String path = "images" + "\\" + file.getName();//path image
                ImageIcon icon = new ImageIcon(path);
                setImagesforButton(button, icon);
                buttons.add(button);
                jPanelButton.add(button);//add button into panel          
                //add event for button            
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //call function to set image for label
                        setImagesforLabel(jLabelImage, icon);
                    }
                });
            }
            displayImage();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid path", " ", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * display and undisplay image in panel 2 case: button has index = size and
     * button has index =size -1 (in this program size=5) when click button has:
     * arr=0 display from 0 to 4 , arr=4 display from 4 to 9 undisplay button
     * has arr<=4 ,.... arr=5 display button has
     * arr<5 undisplay button has arr>=5,...
     * No parameters
     * No return
     */
    private void displayImage() {
        //set visible is false for all of buttons
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setVisible(false);
        }
        //display the 5 first button
        for (int i = 0; i < size; i++) {
            buttons.get(i).setVisible(true);
        }
        //iterate over the buttons in array
        for (int i = 0; i < buttons.size(); i++) {
            //if button have arr %5=0, add event
            //examples:0,5,10
            if (i % size == 0) {
                int count = i;//assign variable
                buttons.get(i).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(count);
                        try {
                            //display button has arr from count-5 to count
                            for (int j = count - size; j < count; j++) {
                                buttons.get(j).setVisible(true);
                            }
                            //undisplay button has arr >count 
                            for (int j = count; j < buttons.size(); j++) {
                                if (count == 0) {
                                    return;
                                }
                                buttons.get(j).setVisible(false);
                            }
                        } catch (Exception ee) {

                        }

                    }
                });
            }
            //if button have (arr+1) %5=0, add event
            //examples:4,9,14
            if ((i + 1) % size == 0) {
                int temp = i;//assign variable
                buttons.get(i).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(temp);
                        try {
                            if (temp == buttons.size() - 1) {
                                return;
                            }
                            //display button has arr from count+1 to count+5
                            //example count=4 display from 5 to 9
                            for (int j = temp + 1; j <= temp + size; j++) {
                                try {
                                    buttons.get(j).setVisible(true);
                                } catch (Exception ex) {
                                }
                            }
                            //undisplay button has arr <= count 
                            for (int j = 0; j <= temp; j++) {
                                buttons.get(j).setVisible(false);
                            }
                        } catch (Exception er) {
                        }

                    }
                });
            }
        }
    }

    /**
     * set image for button
     *
     * @param jb an button is set the image
     * @param ic an object imageIcon
     */
    private void setImagesforButton(JButton jb, ImageIcon ic) {
        //This fuction set image for a button.      
        Image im = ic.getImage().getScaledInstance(jb.getWidth() - 10,
                jb.getHeight() - 10, java.awt.Image.SCALE_SMOOTH);
        jb.setIcon(new ImageIcon(im));
    }

    /**
     * set image for label
     *
     * @param jl an label is set the image
     * @param ic an object imageIcon
     */
    private void setImagesforLabel(JLabel jl, ImageIcon ic) {
        //This fuction set image for a label. 
        Image im = ic.getImage().getScaledInstance(jl.getWidth(),
                jl.getHeight(), java.awt.Image.SCALE_SMOOTH);
        jl.setIcon(new ImageIcon(im));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImage = new javax.swing.JLabel();
        jToolBarButton = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelButton = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanelButtonLayout = new javax.swing.GroupLayout(jPanelButton);
        jPanelButton.setLayout(jPanelButtonLayout);
        jPanelButtonLayout.setHorizontalGroup(
            jPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanelButtonLayout.setVerticalGroup(
            jPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelButton);

        jToolBarButton.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DisplayAndResizeImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayAndResizeImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayAndResizeImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayAndResizeImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayAndResizeImageFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBarButton;
    // End of variables declaration//GEN-END:variables
}
