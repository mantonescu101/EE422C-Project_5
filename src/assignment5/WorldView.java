/* CRITTERS Critter.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2015
 */
package assignment5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class WorldView {
	protected static int tileSize = 10;

	/*
	 * Returns a square or a circle, according to shapeIndex
	 */
	static Shape getIcon(Critter.CritterShape shape) {
		Shape s = null;
		int shapeIndex = 0;

		if(shape.equals(Critter.CritterShape.CIRCLE)){
			shapeIndex = 0;
		}
		else if(shape.equals(Critter.CritterShape.SQUARE)){
			shapeIndex = 1;
		}
		else if(shape.equals(Critter.CritterShape.TRIANGLE)){
			shapeIndex = 2;
		}
		else if(shape.equals(Critter.CritterShape.DIAMOND)){
			shapeIndex = 3;
		}
		else if(shape.equals(Critter.CritterShape.STAR)){
			shapeIndex = 4;
		}
		
		switch(shapeIndex) {
			case 0: // Circle
				s = new Circle(tileSize/2);
				break;
			case 1: // square
				s = new Rectangle(tileSize, tileSize);
				break;
			case 2: // triangle
				s = drawTriangle();
				break;
			case 3: // diamond
				s = drawDiamond();
				break;
			case 4: // star
				s = drawStar();
				break;
			default:
				break;

		}
		// set the outline of the shape
		s.setStroke(javafx.scene.paint.Color.WHITE); // outline
		return s;
	}

	public static void drawCritter(int x_coord, int y_coord, Critter.CritterShape shape, Color outline, Color fill){

		Shape sh = getIcon(shape);
		sh.setFill(fill);
		sh.setStroke(outline);

		Main.critGrid.add(sh, x_coord,y_coord);
	}

	public static void drawGrid(){
		for(int i = 0; i < Params.world_height*tileSize; i+=tileSize){
			for (int j = 0; j < Params.world_width*tileSize; j+=tileSize) {
				Rectangle tile = new Rectangle(tileSize, tileSize);
				tile.setStroke(Color.BLACK);
				tile.setFill(Color.OLIVEDRAB);
				Main.worldGrid.add(tile, i, j);
			}
		}
	}

	/* Paints the shape on a grid. */
	public static void paint() {
		Main.critGrid.getChildren().clear();
		drawGrid();
	}

	private static Shape drawTriangle(){
		Polygon triangle = new Polygon();
		triangle.getPoints().addAll(
				1.0, 1.0,
				(double)tileSize - 1.0, 1.0,
				(double)(tileSize/2), (double)tileSize - 1.0);
		return triangle;
	}

	private static Shape drawDiamond(){
		Polygon diamond = new Polygon();
		diamond.getPoints().addAll(
				1.0, (double)(tileSize/2),
				(double)(tileSize/2), (double)tileSize - 1.0,
				(double)tileSize - 1.0, (double)(tileSize/2),
				(double)(tileSize/2), 1.0);
		return diamond;
	}

	private static Shape drawStar(){
		Polygon star = new Polygon();
		star.getPoints().addAll(
				1.0, (double)tileSize/2.0,
				(double)tileSize/3.0, (double)tileSize*(2.0/3.0),
				(double)tileSize/3.0, (double)tileSize-1.0,
				(double)tileSize*(2.0/3.0), (double)tileSize*(2.0/3.0),
				(double)tileSize-1.0, (double)tileSize-1.0,
				(double)tileSize*(2.0/3.0), (double)tileSize/2.0,
				(double)tileSize-1.0, 1.0,
				(double)tileSize*(2.0/3.0), (double)tileSize/3.0,
				(double)tileSize/3.0, 1.0,
				(double)tileSize/3.0,(double)tileSize/3.0);
		return star;
	}
}
