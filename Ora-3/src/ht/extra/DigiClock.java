package ht.extra;

// Runnable implementacioja
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.Date;

public class DigiClock extends java.applet.Applet implements Runnable {
  Thread timer;                                  // a szal, ami fut
  Point mp_koord[];                              // masodpercek koordinatai
  Image szamjegyek[],                            // 7-szegmenses szamjegyek
        colon,                                   // kettospont
        background,                              // hatterkep (oralap)
        ora1,                                    // ora tizes helyertek
        ora2,                                    // ora egyes helyertek
        perc1,                                   // perc tizes helyertek
        perc2;                                   // perc egyes helyertek

  int mp;                                        // akt. masodperc

  public void init() {
    initImages();                                // kepek feltoltese
    initPositions();                             // masodperc koord. beallitasa
  }

  private void initImages() {
    szamjegyek = new Image[10];                  // tiz szamjegy
    for (int i=0; i<10; i++) 
      szamjegyek[i] = getImage( getCodeBase(),  i + ".gif" );
    colon = getImage( getCodeBase(), "points.gif" );
    background = getImage( getCodeBase(), "clock.gif" );
  }

  private void initPositions() {                 // masodpercek helyei
    double p = Math.PI / 30;

    mp_koord = new Point[61];
    for (int i = 0; i < 61; i++)
      mp_koord[i] = new Point( (int)(50 + 38 * Math.sin(i*p)),
                               (int)(50 - 38 * Math.cos(i*p)) );
  }

  public void start() {                          // A szal max. prioritison
    if (timer == null) {                         // fut, hiszen pontosnak kell 
      timer = new Thread(this);                  // lennie
      timer.setPriority(Thread.MAX_PRIORITY);
      timer.start();
    }
  }

  public void stop() {
      timer = null;
  }

  public void run() {
    long now,                                    // ciklus belepesi pillanat
         waiting,                                // mennyit kell varni (korrig)
         updateTime = 0;                         // "a kov. masodperc"
    Date time;                                   // a datum, ido lekerese
    int ora, perc;                               // segedvaltozok

    while (timer != null) {
      if ( (updateTime += 1000) < (now = System.currentTimeMillis()) )
	updateTime = now;

      time = new Date(); 
      ora  = Integer.parseInt( time.toString().substring(11,13) );
      perc = Integer.parseInt( time.toString().substring(14,16) );
      mp   = Integer.parseInt( time.toString().substring(17,19) );
                                                 // Szamjegyekre bontas
      ora1  = szamjegyek[ora / 10];
      ora2  = szamjegyek[ora % 10];
      perc1 = szamjegyek[perc / 10];
      perc2 = szamjegyek[perc % 10];

      repaint();                                 // kiiras es korrigalas
      if ((waiting = updateTime - System.currentTimeMillis()) > 0) {
        try {
          timer.sleep( waiting );
        } catch (InterruptedException e) {}
      }
    }
  }

  public void paint(Graphics g) {
    g.setColor(Color.black);
    g.fillRect(0, 0, 100, 100);                  // oralap felhelyezes
    g.drawImage(background, 0, 0, Color.black, this);
                                                 // szamjegyek+kettospont
    g.drawImage(ora1, 17, 38, this);  g.drawImage(ora2, 32, 38, this);
    g.drawImage(colon, 46, 38, this);
    g.drawImage(perc1, 53, 38, this); g.drawImage(perc2, 68, 38, this);

    g.setColor(Color.white);
    int vege = (mp == 0 ? 60 : mp);              // hogy mind a 60 pont
    for (int temp=vege; temp>0; temp--)          // latszodjok
	g.drawLine(mp_koord[temp].x, mp_koord[temp].y, 
                   mp_koord[temp].x, mp_koord[temp].y);
  }

  public void update (Graphics g) {
    paint(g);
  }
}

