/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderers;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Juan Manuel
 */
public class CountryRenderer extends DefaultTableCellRenderer {

    private static final int IMAGE_WIDTH = 28;
    private static final int IMAGE_HEIGHT = 19;
    private static final int REDIMENSION_TYPE = Image.SCALE_SMOOTH;
    private ImageIcon spain = loadImage("/res/spain.png");
    private ImageIcon australia = loadImage("/res/australia.png");
    private ImageIcon austria = loadImage("/res/austria.png");
    private ImageIcon canada = loadImage("/res/canada.png");
    private ImageIcon france = loadImage("/res/france.png");
    private ImageIcon norway = loadImage("/res/norway.png");
    private ImageIcon peru = loadImage("/res/peru.png");
    private ImageIcon poland = loadImage("/res/poland.png");
    private ImageIcon portugal = loadImage("/res/portugal.png");
    private ImageIcon switzerland = loadImage("/res/switzerland.png");
    private ImageIcon unitedKingdom = loadImage("/res/united_kingdom.png");
    
    
    private ImageIcon loadImage(String path) {
        ImageIcon imageIcon = new ImageIcon(CountryRenderer.class.getResource(path));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, REDIMENSION_TYPE);
        return new ImageIcon(newimg);
    }

    @Override
    protected void setValue(Object value) {
            if(value.equals("spain")) setIcon(spain);
            if(value.equals("australia")) setIcon(australia);
            if(value.equals("austria")) setIcon(austria);
            if(value.equals("canada")) setIcon(canada);
            if(value.equals("france")) setIcon(france);
            if(value.equals("norway")) setIcon(norway);
            if(value.equals("peru")) setIcon(peru);
            if(value.equals("poland")) setIcon(poland);
            if(value.equals("portugal")) setIcon(portugal);
            if(value.equals("switzerland")) setIcon(switzerland);
            if(value.equals("united kingdom")) setIcon(unitedKingdom);
    }
}
