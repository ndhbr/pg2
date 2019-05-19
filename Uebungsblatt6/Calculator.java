import java.util.Stack;

public class Calculator {

    private Stack<Double> history;

    public Calculator() {
        history = new Stack();
        history.push(Double.valueOf(0.0));
    }

    public void clear() {
        history.clear();
        history.push(Double.valueOf(0.0));
    }

    public void apply(Function f, double y) {
        double newResult = f.getResult(history.lastElement(), y);
        history.push(newResult);
    }

    public void undo() {
        if(canUndo()) {
            history.pop();
        }
    }

    public boolean canUndo() {
        if(history.size() > 1)
            return true;

        return false;
    }

    public double getResult() {
        return history.lastElement();
    }
}