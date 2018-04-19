package hellotvxlet ;
import javax.tv.xlet.* ;
import org.dvb.ui.* ;
import java.awt.* ;
import org.havi.ui.* ;
public class HelloTVXlet implements Xlet {
private XletContext actueleXletContext ;
private HScene scene ;
private HScene scene1 ;
// debuggen activeren of niet ?
private boolean debug=true ;
private HTextButton knop1,knop2,kaart1,kaart2,kaart3,kaart4,kaart5,kaart6;
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
scene = HSceneFactory.getInstance( ).getBestScene( sceneTemplate ) ;
scene1 = HSceneFactory.getInstance( ).getBestScene( sceneTemplate ) ;
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
knop1. setFocusTraversal(kaart4, kaart1, knop2 , null ) ; // op , neer , links ,
knop2.setFocusTraversal(kaart4, kaart1, null, knop1) ; // op , neer , links ,
kaart1 = new HTextButton("kaart" ) ;
kaart1.setLocation(100,75) ;
kaart1.setSize (100,50) ;
kaart1.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart1.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart1. setFocusTraversal( null , null, knop2 , null ) ; // op , neer , links ,
kaart2 = new HTextButton("kaart" ) ;
kaart2.setLocation(220,75) ;
kaart2.setSize (100,50) ;
kaart2.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart2.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart2. setFocusTraversal( null , null, knop2 , null ) ; // op , neer , links ,
kaart3 = new HTextButton("kaart" ) ;
kaart3.setLocation(340,75) ;
kaart3.setSize (100,50) ;
kaart3.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart3.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart3. setFocusTraversal( null , null, knop2 , null ) ; // op , neer , links ,
kaart4 = new HTextButton("kaart" ) ;
kaart4.setLocation(100,150) ;
kaart4.setSize (100,50) ;
kaart4.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart4.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart4. setFocusTraversal( null , null, knop2 , null ) ; // op , neer , links ,
kaart5 = new HTextButton("kaart" ) ;
kaart5.setLocation(220,150) ;
kaart5.setSize (100,50) ;
kaart5.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart5.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart5. setFocusTraversal( null , null, knop2 , null ) ; // op , neer , links ,
kaart6 = new HTextButton("kaart" ) ;
kaart6.setLocation(340,150) ;
kaart6.setSize (100,50) ;
kaart6.setBackground (new DVBColor(0 ,0 ,0 ,179) ) ;
kaart6.setBackgroundMode( HVisible .BACKGROUND_FILL) ;
kaart6. setFocusTraversal( null , null, knop2 , null ) ; // op , neer , links ,

scene.add(knop1) ;
scene.add(knop2) ;
scene.add(time) ;
scene.add(trys) ;
//scene.add(tekstLabel ) ;
scene.add(kaart1) ;
scene.add(kaart2) ;
scene.add(kaart3) ;
scene.add(kaart4) ;
scene.add(kaart5) ;
scene.add(kaart6) ;
scene1.add(knop1) ;
scene1.add(knop2) ;
scene1.add(time) ;
scene1.add(trys) ;



knop1.requestFocus( );
}
public void startXlet( ) throws XletStateChangeException
{
if(debug)System.out.println( " Xlet Starten " ) ;
//Scene zichtbaar maken
//scene.validate( ) ;
//scene.setVisible(true) ;
scene1.validate( ) ;
scene1.setVisible(true) ;
scene1.invalidate();
}
public void pauseXlet ( )
{
}
public void destroyXlet ( boolean unconditional ) throws
XletStateChangeException
{
}
}
