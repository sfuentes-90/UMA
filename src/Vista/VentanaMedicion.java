package Vista;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;




public class VentanaMedicion extends JFrame{
    private JPanel contenedorCentral;
    private JPanel statusPanel;
    private PanelIzquierdo panelIzquierdo;
    private final PanelDerecho panelDerecho;
    private final GridBagConstraints gbc;
    
    public VentanaMedicion(){
        Image icono = null;
        try {
            icono = ImageIO.read(getClass().getResource("/imagenes/icon_64x64.png"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(icono);  
        
        this.setMinimumSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        /* Paneles del JFrame */
        contenedorCentral = new JPanel();
        statusPanel = new JPanel();  
        panelIzquierdo = new PanelIzquierdo();
        panelDerecho = new PanelDerecho();
        
        /* Paneles centrales */
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5, 5, 5, 5);
        contenedorCentral.setLayout(new GridBagLayout());
        panelIzquierdo.setMinimumSize(new Dimension(395,560));
        panelDerecho.setMinimumSize(new Dimension(195,560));
        panelIzquierdo.setBorder(new BevelBorder(BevelBorder.LOWERED));
        addComp(contenedorCentral, panelIzquierdo, 0, 0, 1, 1, GridBagConstraints.BOTH, 1.0, 1.0);
        addComp(contenedorCentral, panelDerecho, 1, 0, 1, 1, GridBagConstraints.VERTICAL, 0.0, 1.0);
        
        
        /* Barra de estado */       
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));        
        statusPanel.setPreferredSize(new Dimension(this.getWidth(), 24));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        
        /* Agregamos los paneles al JFrame */
        this.add(contenedorCentral, BorderLayout.CENTER);
        this.add(statusPanel, BorderLayout.SOUTH);
        
        this.setTitle("Medición");
        this.setVisible(true);
    }
    
    private void addComp(JPanel panel, JComponent comp, int gridx, int gridy, int gridwidth, int gridheight, int fill, double weightx, double weighty) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        panel.add(comp, gbc);
    }
}
