//////// Exercise x2:  modularize exercise x1, and add dog to chase hero.
//////// Emmett Woytovich CST112 9/16/2015
//////// Please change these to your name and today's date.
String author=  "Emmett Woytovich 9/16/2015";
String title=  " Intense Chase Scene ";
String help=  " Click to relocate hero \n 'q' to quit; 'r' to reset. ";


//// GLOBALS:  coordinates, speed, etc.
float horizon;
float x, y;       // Position.
float dx, dy;     // Speed.
float dogX, dogY;

//// SETUP:  window size, initialization (start in middle of screen).
void setup() {
  size( 640,480);
  dogX = 0;
  dogY = 0;
  x=  width/2;
  y=  height/2;
  dx=  3;
  dy=  2;
}

//// NEXT FRAME:  scene, action, show.
void draw() {
  scene();
  hero();
  dog();
  messages();
}

//// SCENE:  sky, sun, tree, house, etc.
void scene() {  
  background( 200,255,255 );
  fill(0);
  text( "The Bupkis Returns", 100, 100 );
}

void messages() {
  fill(0);
  text( title, width/3, 20 );
  text( help, width*2/3, 30 );
  text( author, 10,height-20 );
}

//// ACTION:  move (x,y) coordinates of hero & dog; show them.
void hero() {
  fill(x%255,y%255,(x+y)%255); ellipse(x,y,50,50);
  x = (x+dx)%(width+50);
  y = (y+dy)%(height+50);
  if(x < -50){x = width + 50;}
  if(y < -50){y = height + 50;}
}
void dog() {
  
  rect(dogX-50,dogY-50,50,50);
  fill(0);
  text( "woof, woof!!!", dogX, dogY );
  dogX=  (dogX + (x-dogX)/30)%(width+50);
  dogY=  (dogY + (y-dogY)/40)%(width+50);
  if(dogX < -50){dogX = width + 50;}
  if(dogY < -50){dogY = height + 50;}
}





//////// HANDLERS:  mouse clicks, keys
void mousePressed() {
  x=  mouseX;                             // Set (x,y) to mouse
  y=  mouseY;
  //
  dx=  random( -6, +6 );                  // random speed.
  dy=  random( -4, +4 );
}

void keyPressed() {
  if (key == 'q') {
    exit();                           // press 'q' key to QUIT.
  }
  if(key == 'r'){
  setup();
  }
}

   

