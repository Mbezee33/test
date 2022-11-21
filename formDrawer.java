import java.util.Scanner;
public class formDrawer{
  //main method that prints the header and calls the menu
  public static void main(String[]args){
    Scanner scnr = new Scanner(System.in);
  
    System.out.println("Fall 2022 - CS1083 - Section 002 - Project 2 - FormDrawer - written by Marshall Blanchard");
    getMenuSelection(scnr);
  }
  
  //establishes a forever loop that will continually reprint the menu and calls each method
  //calls the menu method to print and checks the selection inputed
  public static void getMenuSelection(Scanner scnr){
    int i = 0;
    while (i==0){
    showMenu();
    int temp;
    temp = scnr.nextInt();
    if (temp == 0){
      System.out.println("Thank you for using the formDrawer program, Good bye!");
      break;
    }
    else if (temp ==1){
      diamond(scnr);
    }
    else if (temp ==2){
      rectangle(scnr);
    }
    else if (temp ==3){
      triangle(scnr);
    }
    else {
      System.out.print("Incorrect option, please try again");
    }
    } 
  }
  
  //Simple menu printout 
  public static void showMenu(){
    System.out.println("Please, select one of the following options");
    System.out.println("0. Exit");
    System.out.println("1. Draw a Diamond");
    System.out.println("2. Draw a Rectangle");
    System.out.println("3. Draw a Triangle");
    
  }
  
  //primary method for the diamond, runs a forever loop to validate the size 
  public static void diamond(Scanner scnr){
    System.out.println("Please write the char that you would like to be used to fill the diamond");
    char fillChar = scnr.next().charAt(0);
    System.out.println("Please write the char that you would like to be used as the edge of the diamond");
    char edgeChar = scnr.next().charAt(0);
    int i = 0;
    while (i ==0){
      System.out.println("What size do you want the diamond to be drawn?");
      System.out.println("Please insert an even number between 0 and 60");
      int size = scnr.nextInt();
      if ((size % 2 ==0) && (size > 0) && (size <= 60)){
        drawDiamond(scnr, fillChar, edgeChar, size);
        break;
    }
    else {
      System.out.println("Incorrect option, please try again");
    }
    }
  }
  
  //method that establishes two for loops based on the size of the diamond
  public static void drawDiamond(Scanner scnr, char fillChar, char edgeChar, int size){
   int i; 
   int s = size;
   //top half that calls showCharNTimes to print out the five sections of each row
   for (i=0; i < (size/2); i++){
     
     //variables that correspond with each section of each row, the edge, the border, the fill, the border, the edge
     char a = '/';
     char b = '\\';
     char space = 'W';
     int n = ((size/2)-1)-i;
     int m = 1;
     int o = size -s;
     int p = 0;
     
     showCharNTimes(edgeChar, n);
     showCharNTimes(a, m);
     showCharNTimes(fillChar, o);
     showCharNTimes(b, m);
     showCharNTimes(edgeChar, n);
     showCharNTimes(space, p);
     s = s -2;
   }
   int q = 0;
   int t = size;
   
   //bottom half of the diamond that follows the same structure as the top half, switches formula for edge and fill
   for (i= 0; i < (size/2); i++){
     
     char a = '/';
     char b = '\\';
     char space = 'W';
     int m = 1;
     int p = 0;
     int r = t-2;
     
     showCharNTimes(edgeChar, q);
     showCharNTimes(b, m);
     showCharNTimes(fillChar, r);
     showCharNTimes(a, m);
     showCharNTimes(edgeChar, q);
     showCharNTimes(space, p);
     q++;
     t = t-2;
   }
  }
  
  //simple method that prints the given symbol based on the given number
  //uses character'W' to print a new line so other method doesn't have any println statements
  public static void showCharNTimes(char c, int n){
    int i;
    if (c == 'W'){
      System.out.println("");
    }
    else {
      for (i = 0; i < n; i++){
        System.out.print(c);
      }
    }
}
  //validation using a while loop that contains two separate while loops to validate inputs
  public static void rectangle(Scanner scnr){
    System.out.println("Please write the char that you would like to be used as the contour of the rectangle");
    char chr = scnr.next().charAt(0); 
    boolean hollow;
    int i = 0;
    while (i ==0){
    System.out.println("Do you want the rectangle to be printed hollow?");
    char h = scnr.next().charAt(0);
    
    //contains secondary while loop to validate size
    if (h == 'Y'){
      hollow = true;
      int j = 1; 
    while (j ==1){
    int size;
    System.out.println("What size do you want the Rectangle to be drawn?");
    System.out.println("Please insert any number between 0 and 60");
    size = scnr.nextInt();
    if ((size >=0) && (size <= 60)){
      drawRectangle(chr, size, hollow);
      //breaks out of inner while loop if good
      break;
    }
    else {
      System.out.println("Incorrect option, please try again");
    }
    }
    //breaks out of outer loop if both are good
    break;
    }
    
    //contains secondary while loop to validate size
    else if (h == 'N'){
      hollow = false;
      int j = 1; 
    while (j ==1){
    int size;
    System.out.println("What size do you want the Rectangle to be drawn?");
    System.out.println("Please insert any number between 0 and 60");    
    size = scnr.nextInt();
    if ((size >=0) && (size <= 60)){
      drawRectangle(chr, size, hollow);
      //breaks out of inner while loop if good
      break;
    }
    else {
      System.out.println("Incorrect option, please try again");
    }
    }
    //breaks out of outer loop if both are good
    break;
    }
    else {
      System.out.println("Incorrect option, please try again");
    }
    }
    

  }  
  
  //method that initially separates a hollow rectangle from a solid rectangle
  //runs a for loop that calls the line drawing method based off the size of the rectangle
  public static void drawRectangle(char chr, int size, boolean hollow){
    int i;
    //simpler for loop that prints solid rectangle
    if (hollow == false){
      for (i = 0; i < size; i++){
        drawRectangleLine(chr, size, hollow);
      }
    }
    //more complex for loop that first prints a solid line, switches the draw method back to hollow
    //runs a for loop to make all interior rows hollow
    //switches the boolean gain to run the bottom row which is solid
    else {
      hollow = false;
      drawRectangleLine(chr, size, hollow);
      hollow = true;
      for (i=0; i < (size-2); i++){
        drawRectangleLine(chr, size, hollow);
      }
      hollow = false;
      drawRectangleLine(chr, size, hollow);
    }
        
    
  }
  
  //method that either prints a solid line or hollow line based off the boolean
  //runs off of for loops based on the size of the rectangle
  public static void drawRectangleLine(char chr, int size, boolean hollow){
    int i;
    //prints a solid line
    if (hollow == false){
      for (i=0; i < size; i++){
        System.out.print(chr);
      }
      System.out.println("");
    }
    //prints a hollow line
    else {
      System.out.print(chr);
      for (i=0; i < (size-2); i++){
        System.out.print(" ");
      }
      System.out.print(chr);
      System.out.println("");
    }
  }
  
  //method that uses a forever loop to validate the width of the triangle
  public static void triangle(Scanner scnr){
    int i=0;
    while(i==0){
    System.out.println("What size do you want the Triangle to be drawn?");
    System.out.println("Please insert an even number between 0 and 60");
    int width;
    width = scnr.nextInt();
    if ((width>0) && (width<=60) && (width % 2 ==0)){
      drawTriangle(width);
      //breaks out of loop if correct input so it won't come back here after triangle prints
      break;
    }
    else {    
      System.out.println("Incorrect option, please try again");
    }
  }
  }
  
  //method that prints triangle based off the width, prints the borders and then prints the base line
  public static void drawTriangle(int width){
    int i;
    int j;
    int space;
    int w = width;
    
    //for loop that prints the triangle in four sections, two that are based on the row iteration 
    for (i=0; i<(width/2); i++){
      //prints the left most spaces
      for(space=i; space<(width/2); space++){
        System.out.print(" ");
      }
      //prints the left border
      System.out.print("/");
      //prints the interior spaces
      for(j=0; j<(width-w); j++){
        System.out.print(" ");
      }
      //prints the right border
      System.out.print("\\");
      System.out.println("");
      w = w-2;
    }
    //prints a small gap to align the base, prints out based on width of the triangle
    System.out.print(" ");
    for (i=0; i< width; i++){
      System.out.print("-");
    }
    System.out.println("");
  }
}

