package todo.list;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class TodoList {
    private LinkedList<String> toDoList = new LinkedList<>();
    private LinkedList<String> completedTasks = new LinkedList<>();
    private Stack<Action> undoStack = new Stack<>();

    public static void main(String[] args) {
        TodoList manager = new TodoList();
        manager.run();
    }

    private void run() {
        int choice;

        do {
            String[] options = {"Add Task", "Mark Task as Done", "Undo Last Action", "View To-Do List", "View Completed Tasks", "Exit"};
            choice = JOptionPane.showOptionDialog(null,
                    "--- To-Do List Manager ---",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0 -> addTask();
                case 1 -> markTaskAsDone();
                case 2 -> undoLastAction();
                case 3 -> viewToDoList();
                case 4 -> viewCompletedTasks();
                case 5 -> JOptionPane.showMessageDialog(null, "BYE!!! BYE!!!");
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void addTask() {
        String task = JOptionPane.showInputDialog("Enter a new task:");
        if (task != null && !task.trim().isEmpty()) {
            toDoList.add(task);
            undoStack.push(new Action("add", task));
            JOptionPane.showMessageDialog(null, "Task added.");
        } else {
            JOptionPane.showMessageDialog(null, "Task cannot be empty.");
        }
    }

    private void markTaskAsDone() {
        if (toDoList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks to mark as done.");
            return;
        }

        viewToDoList();
        String input = JOptionPane.showInputDialog("Select a task to mark as done (number):");
        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < toDoList.size()) {
                String task = toDoList.remove(index);
                completedTasks.add(task);
                undoStack.push(new Action("done", task));
                JOptionPane.showMessageDialog(null, "Task marked as done.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid selection.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
        }
    }

    private void undoLastAction() {
        if (undoStack.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No actions to undo.");
            return;
        }

        Action lastAction = undoStack.pop();
        if (lastAction.actionType.equals("add")) {
            toDoList.remove(lastAction.task);
            JOptionPane.showMessageDialog(null, "Last added task removed.");
        } else if (lastAction.actionType.equals("done")) {
            completedTasks.remove(lastAction.task);
            toDoList.add(lastAction.task);
            JOptionPane.showMessageDialog(null, "Last completed task moved back to to-do list.");
        }
    }

    private void viewToDoList() {
        StringBuilder toDoText = new StringBuilder("--- To-Do List ---\n");
        if (toDoList.isEmpty()) {
            toDoText.append("No tasks in the to-do list.");
        } else {
            for (int i = 0; i < toDoList.size(); i++) {
                toDoText.append((i + 1)).append(". ").append(toDoList.get(i)).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, toDoText.toString());
    }

    private void viewCompletedTasks() {
        StringBuilder completedText = new StringBuilder("--- Completed Tasks ---\n");
        if (completedTasks.isEmpty()) {
            completedText.append("No completed tasks.");
        } else {
            for (String task : completedTasks) {
                completedText.append(task).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, completedText.toString());
    }

    private static class Action {
        String actionType;
        String task;

        Action(String actionType, String task) {
            this.actionType = actionType;
            this.task = task;
        }
    }
}
