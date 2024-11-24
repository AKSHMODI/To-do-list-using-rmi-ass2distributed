import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class TodoListServer  {

    // Store tasks in a list
    private List<String> tasks = new ArrayList<>();
    private List<String> deadlines = new ArrayList<>();

    // Add a task to the list
    
    public void addTask(String task) throws RemoteException {
        tasks.add(task);
        deadlines.add("No deadline set");
        System.out.println("Task added: " + task);
    }

    // Remove a task from the list
    
    public void removeTask(String task) throws RemoteException {
        int index = tasks.indexOf(task);
        if (index != -1) {
            tasks.remove(index);
            deadlines.remove(index);
            System.out.println("Task removed: " + task);
        }
    }

    // View all tasks
    
    public String[] viewTasks() throws RemoteException {
        return tasks.toArray(new String[0]);
    }

    // Edit an existing task
   
    public void editTask(String oldTask, String newTask) throws RemoteException {
        int index = tasks.indexOf(oldTask);
        if (index != -1) {
            tasks.set(index, newTask);
            System.out.println("Task updated: " + oldTask + " -> " + newTask);
        }
    }

    // Set a deadline for a task
   
    public void setDeadline(String task, String deadline) throws RemoteException {
        int index = tasks.indexOf(task);
        if (index != -1) {
            deadlines.set(index, deadline);
            System.out.println("Deadline for task '" + task + "' set to: " + deadline);
        }
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the server
            TodoListServer server = new TodoListServer();

            

            // Bind the object to the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099); // Default port
            

            System.out.println("Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
