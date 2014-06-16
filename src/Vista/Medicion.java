package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Medicion {
    private JPanel panelCentral;
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private final GridBagConstraints gbc;
    private JPanel statusPanel;


    public Medicion() {
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JFrame frame = new JFrame("Swing Worker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));

       
        JPanel contenedor = getPanel();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(panelCentral, BorderLayout.CENTER);
        
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        contenedor.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(contenedor.getWidth(), 24));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        
        JPanel centro = getPanel();
        centro.setLayout(new GridBagLayout());
        
        panelIzquierdo = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return (new Dimension(490, 560));
            }
        };
        panelDerecho = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return (new Dimension(200, 560));
            }
        };

        panelIzquierdo.setBorder(new BevelBorder(BevelBorder.LOWERED));
        addComp(centro, panelIzquierdo, 0, 0, 1, 1, GridBagConstraints.BOTH, 1.0, 1.0);
        addComp(centro, panelDerecho, 1, 0, 1, 1, GridBagConstraints.NONE, 0.0, 1.0);

        frame.setContentPane(centro);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);        
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

    private JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        return panel;
    }
}
