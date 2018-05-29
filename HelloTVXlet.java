package hellotvxlet ;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Toolkit.*;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.tv.xlet.* ;
import org.dvb.ui.* ;
import org.havi.ui.* ;
import org.havi.ui.event.HActionListener;
public class HelloTVXlet implements Xlet, HActionListener{
private XletContext actueleXletContext ;
private HScene scene ;
private int comp =0;
private int count=0;
Toolkit tl = Toolkit.getDefaultToolkit();
Image achterkant = tl.getImage("achterkant.png");
//Image hart =  .getToolkit().getImage("hart.JPEG");
Image ruit = tl.getImage("ruit.png");
Image schoppe = tl.getImage("schoppe.png");
Image hart = tl.getImage("hart.png");
Image[] randomArray = {hart,ruit, schoppe};
int totClick=0;
int cardNumber=0;
int fill = 0;
int hartCheck = 0;
int ruitCheck = 0;
int schoppeCheck = 0;
int clickNow = 0;
boolean clkt = false;


private boolean debug=true ;
private HTextButton knop1,knop2;
HGraphicButton[] kaart = new HGraphicButton[6];
private HStaticText tekstLabel,time,trys;

public void initXlet(XletContext context ) throws XletStateChangeException
{

if (debug) System.out.println ( " Xlet Initialiseren " ) ;
this . actueleXletContext = context ;
// Template aanmaken
HSceneTemplate sceneTemplate = new HSceneTemplate( ) ;
// Grootte en positie aangeven
sceneTemplate . setPreference ( HSceneTemplate.SCENE_SCREEN_DIMENSION,
new HScreenDimension(1.0f , 1.0f ),HSceneTemplate.REQUIRED) ;

sceneTemplate.setPreference( HSceneTemplate.SCENE_SCREEN_LOCATION,
new HScreenPoint(0.0f,0.0f ), HSceneTemplate.REQUIRED) ;
// Een instantie van de Scene aanvragen aan de factory .
comp=0;
count=0;
fill = 0;
hartCheck = 0;
ruitCheck = 0;
schoppeCheck = 0;
scene = HSceneFactory.getInstance( ).getBestScene( sceneTemplate ) ;
tekstLabel = new HStaticText ( "Welcome bij memory" ) ;
time = new HStaticText ("time: 00:00");
trys = new HStaticText ("trys:0");
trys.setLocation(575,75) ;
trys.setSize (125,75) ;
trys.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
trys.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
time.setLocation(575,0) ;
time.setSize (125,75) ;
time.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
time.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
tekstLabel.setLocation(75,75) ;
tekstLabel.setSize(450,400) ;
tekstLabel.setBackground(new DVBColor(100,255,60,179) ) ;
tekstLabel.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
knop1 = new HTextButton ( "start" ) ;
knop1.setLocation(300,500) ;
knop1.setSize (100,50) ;
knop1.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
knop1.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
knop2 = new HTextButton("exit" ) ;
knop2.setLocation(200,500) ;
knop2.setSize (100,50) ;
knop2.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
knop2.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart[0] = new HGraphicButton () ;
kaart[0].setLocation(100,75) ;
kaart[0].setSize (100,150) ;
kaart[0].setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart[0].setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart[1] = new HGraphicButton () ;
kaart[1].setLocation(220,75) ;
kaart[1].setSize (100,150) ;
kaart[1].setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart[1].setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart[2] = new HGraphicButton () ;
kaart[2].setLocation(340,75) ;
kaart[2].setSize (100,150) ;
kaart[2].setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart[2].setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart[3] = new HGraphicButton () ;
kaart[3].setLocation(100,300) ;
kaart[3].setSize (100,150) ;
kaart[3].setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart[3].setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart[4] = new HGraphicButton () ;
kaart[4].setLocation(220,300) ;
kaart[4].setSize (100,150) ;
kaart[4].setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart[4].setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart[5] = new HGraphicButton () ;
kaart[5].setLocation(340,300) ;
kaart[5].setSize (100,150) ;
kaart[5].setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart[5].setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart[0].setGraphicContent(achterkant,kaart[0].NORMAL_STATE);
kaart[1].setGraphicContent(achterkant,kaart[1].NORMAL_STATE);
kaart[2].setGraphicContent(achterkant,kaart[2].NORMAL_STATE);
kaart[3].setGraphicContent(achterkant,kaart[3].NORMAL_STATE);
kaart[4].setGraphicContent(achterkant,kaart[4].NORMAL_STATE);
kaart[5].setGraphicContent(achterkant,kaart[5].NORMAL_STATE);
kaart[0].setFocusTraversal( knop1, kaart[3], kaart[2] , kaart[1] ) ; 
kaart[1].setFocusTraversal( knop1, kaart[4], kaart[0] , kaart[2] ) ; 
kaart[2].setFocusTraversal( knop1 , kaart[5], kaart[1] , kaart[0] ) ;
kaart[3].setFocusTraversal( kaart[0] , knop2, kaart[5], kaart[4]) ;
kaart[4].setFocusTraversal( kaart[1], knop2, kaart[3], kaart[5]) ; 
kaart[5].setFocusTraversal( kaart[2], knop2, kaart[4] , kaart[3]) ;
knop1.setFocusTraversal(kaart[3], kaart[0], knop2 , kaart[0] ) ;
knop2.setFocusTraversal(kaart[3], kaart[0], knop1, knop1) ; 

do {
        
        int result = shuffleArray();
        Image kaartFill = randomArray[result];
        
        
        
        if ( kaartFill == hart && hartCheck < 2)
        {
            kaart[fill].setGraphicContent( randomArray[result], kaart[fill].ACTIONED_STATE);
            
             System.out.println(kaart[fill]);
            
            hartCheck++;
            fill++;
            
        }
        if (kaartFill == ruit && ruitCheck < 2)
        {
            kaart[fill].setGraphicContent( randomArray[result], kaart[fill].ACTIONED_STATE);
            
             System.out.println(kaart[fill]);
            
            ruitCheck++;
            fill++;
        }
        if (kaartFill == schoppe && schoppeCheck < 2)
        {
            kaart[fill].setGraphicContent( randomArray[result], kaart[fill].ACTIONED_STATE);
            
             System.out.println(kaart[fill]);
            
            schoppeCheck++;
            fill++;
        }
        
 
        } while (fill < 6);
        
    

scene.add(knop2) ;

//scene.add(tekstLabel ) ;
scene.add(kaart[0]) ;
scene.add(kaart[1]) ;
scene.add(kaart[2]) ;
scene.add(kaart[3]) ;
scene.add(kaart[4]) ;
scene.add(kaart[5]) ;




kaart[0].requestFocus( );
}
  public static int shuffleArray()
  {
      
   Random rand = new Random(); 
   int value = rand.nextInt(3); 
   
  System.out.println(value);
   
   return value;

    }
  public void actionPerformed(ActionEvent e)
  {
      
    
      System.out.println(e.getActionCommand());
         
         System.out.println( clickNow);
      Image compIm = null;
      int active = 0;
      
    int beest = Integer.parseInt(e.getActionCommand());
    if (beest == 6){
        Runtime.getRuntime().exit(1);
    }
    if( clickNow == 0 ){
    if(beest < 6){ 
        clickNow=0;
       cardNumber=beest;
       
    kaart[beest].setGraphicContent(kaart[beest].getGraphicContent(kaart[beest].ACTIONED_STATE),kaart[beest].NORMAL_STATE);
    compIm = kaart[beest].getGraphicContent(kaart[beest].ACTIONED_STATE);
    
 
    System.out.println(clickNow);
    clickNow++;
    return;
    
  }}else if(clickNow == 1){
    if(beest < 6){ 
        
     totClick++;
     
     kaart[beest].setGraphicContent(kaart[beest].getGraphicContent(kaart[beest].ACTIONED_STATE),kaart[beest].NORMAL_STATE);
     if(kaart[beest].getGraphicContent(kaart[beest].ACTIONED_STATE) == kaart[cardNumber].getGraphicContent(kaart[cardNumber].ACTIONED_STATE) && beest != cardNumber){
     kaart[beest].repaint();
         System.out.println("toot2");
     
     clickNow = 0;
     return ;
     } else{
         System.out.println("toot1"); 
         kaart[beest].setGraphicContent(kaart[beest].getGraphicContent(kaart[beest].ACTIONED_STATE),kaart[beest].NORMAL_STATE);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
         try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
         try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
         try {
                        Thread.sleep(400);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
         try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
         try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
        kaart[beest].setGraphicContent(achterkant,kaart[beest].NORMAL_STATE );
        kaart[cardNumber].setGraphicContent(achterkant,kaart[cardNumber].NORMAL_STATE );
        clickNow =0;
        cardNumber=0;
        return;
        
     }
     
     
    } 
  }
    
  }
public void startXlet( ) throws XletStateChangeException
{
if(debug)System.out.println( " Xlet Starten " ) ;
//Scene zichtbaar maken
scene.validate( ) ;
scene.setVisible(true) ;
knop2.setActionCommand("6");
knop2.addHActionListener(this);

    kaart[0].setActionCommand("0");
    kaart[0].addHActionListener(this);
    kaart[1].setActionCommand("1");
    kaart[1].addHActionListener(this);
    kaart[2].setActionCommand("2");
    kaart[2].addHActionListener(this);
    kaart[3].setActionCommand("3");
    kaart[3].addHActionListener(this);
     kaart[4].setActionCommand("4");
    kaart[4].addHActionListener(this);
     kaart[5].setActionCommand("5");
    kaart[5].addHActionListener(this);


}
public void pauseXlet ( )
{
}
public void destroyXlet ( boolean unconditional ) throws
XletStateChangeException
{
}

    
}
