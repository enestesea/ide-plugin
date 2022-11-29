package com.enestesea.ideplugin.Gui;

import com.enestesea.ideplugin.project.DanilaService;
import com.intellij.openapi.application.ApplicationManager;

import java.awt.* ;

import javax.swing.* ;

public class Danila extends JFrame {

    public Danila() {
        super() ;
        setTitle( "Danilka" ) ;
        setContentPane( new MyPanel() ) ;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible( true ) ;
    }

    public class MyPanel extends JPanel {
        private Image img ;
        public MyPanel() {
            setLayout( new BorderLayout() ) ;
            img = ApplicationManager.getApplication().getService(DanilaService.class).getRandomDanilaImage();
            if( img == null ) {
                System.out.println( "Image is null" );
                System.exit( 1 ) ;
            }
            if( img.getHeight(this) <= 0 || img.getWidth( this ) <= 0 ) {
                System.out.println( "Image width or height must be +ve" );
                System.exit( 2 ) ;
            }
        }
        public void drawBackground( Graphics g ) {
            int w = getWidth() ;
            int h = getHeight() ;
            int iw = img.getWidth( this ) ;
            int ih = img.getHeight( this ) ;
            for( int i = 0 ; i < w ; i+=iw ) {
                for( int j = 0 ; j < h ; j+= ih ) {
                    g.drawImage( img , i , j , this ) ;
                }
            }
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBackground( g ) ;
        }
    }

    public static void main() {
        new Danila();
    }
}