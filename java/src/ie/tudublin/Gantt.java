package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet {

	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");

        for(TableRow row:table.rows())
        {
            Task t = new Task(row);
            tasks.add(t);
        }
		
	}

	public void printTasks()
	{
		for(Task t: tasks)
        {
            println(t);
        }
		
	}


	public void displayTasks() {
		
		colorMode(HSB);

		float border = 0.05f * width;

        //float drawable = width - (border * 2.0f);
        // /float gap = drawable / 10.0f;
        for(int i = 1; i < 31; i ++) //displaying numbers and the lines
        {
            float x = map(i, 1, 30, border * 4, width - border);

            fill(255);
            text(i, x, border / 2);

			stroke(225);
			line(x + 4, border, x + 4, height - border);
        }

		//displaying task names 

		for(int i = 0; i < tasks.size(); i++) {

			float x = map(i, 0, 9, border, border);
            float y = map(i, 0, 9, border * 2, height - 200);

			Task t = tasks.get(i);

			fill(225);
			text(t.getTask(), x, y);

		}

		//drawing the gant bars 
		noStroke();
		int numRects = tasks.size();
		float rectsColour = 225 / (float) numRects;
		//float gap = 800 / (float) numRects;

		//COME BACK TO THISSSSSS
		for(int i = 0; i < tasks.size(); i++) {

			Task t = tasks.get(i);

			float x = map(i, 0, 9, border * 4, width - border);
			float y = map(i, 0, 9, border + 15, height - border - 180);
			float x2 = map(t.getStart(), 1, 30, border * 2, width - border);
			float y2 = map(t.getEnd(), 1, 30, border * 2, width - border);

			fill(rectsColour * i, 255, 255);

			//rect(x, y, border * 2, 35, 7);
			rect(x, y, y2 - x2, 35, 7);


		}
	
		
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");

			// //float border = 0.05f * width;
	
			// for(int i = 0; i < tasks.size(); i++) {

			// 	Task t = tasks.get(i);
	
			// 	int taskDuration = (int) t.getStart() - (int) t.getEnd();
				
			// 	if(taskDuration < 1) {
	
			// 		println("Mouse not pressed");
	
			// 	}
	
			// 	// float x = map(i, 0, 9, border * 4, width - border);
			// 	// float y = map(i, 0, 9, border + 15, height - 200);
	
	
			// }

	}

	public void mouseDragged()
	{
		println("Mouse dragged");

		//float border = 0.05f * width;
		
		// for(int i = 0; i < tasks.size(); i++) {

		// 	Task t = tasks.get(i);

		// 	int taskDuration = (int) t.getStart() - (int) t.getEnd();
			
		// 	if(taskDuration < 1) {

		// 		println("Mouse not dragged");

		// 	}

		// 	// float x = map(i, 0, 9, border * 4, width - border);
        //     // float y = map(i, 0, 9, border + 15, height - 200);


		// }
	}

	
	
	public void setup() 
	{
		
		loadTasks();
		printTasks();

	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
		//mousePressed();
		//mouseDragged();
	}
}
