package ie.tudublin;
import processing.data.TableRow;

public class Task {

    private String task;
    private int start;
    private int end;
    
    public Task() {

        //default constructor

    }

    public Task(TableRow row) {

        // Constructor chaining
        this(
            row.getString("Task"),
            row.getInt("Start"),
            row.getInt("End")
        );
    }

    public Task(String task, int start, int end) {
           
        this.task = task;
        this.start = start;
        this.end = end;

    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public float getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public float getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Task [end=" + end + ", start=" + start + ", task=" + task + "]";
    }
}
