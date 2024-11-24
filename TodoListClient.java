import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class TodoListClient {
    public static void main(String[] args) {
        try {
            // Declare a reference variable of type TodoList
            TodoList todoList;

            // Look up the remote object (TodoListService) from the RMI registry
            todoList = (TodoList) Naming.lookup("//localhost/TodoListService");

            // Now you can use the todoList object to interact with the remote object
            // For example, calling methods on the remote TodoList object:
            todoList.addTask("Complete Java RMI Assignment");
            todoList.addTask("Prepare dinner");
            todoList.addTask("Read a book");

            // View tasks
            System.out.println("Tasks:");
            String[] tasks = todoList.viewTasks();
            for (String task : tasks) {
                System.out.println(task);
            }

            // Edit a task
            todoList.editTask("Prepare dinner", "Prepare lunch");

            // Set a deadline for a task
            todoList.setDeadline("Complete Java RMI Assignment", "Tomorrow");

            // View tasks again to see the changes
            System.out.println("\nUpdated Tasks:");
            tasks = todoList.viewTasks();
            for (String task : tasks) {
                System.out.println(task);
            }

            // Remove a task
            todoList.removeTask("Read a book");

            // Final task list
            System.out.println("\nFinal Task List:");
            tasks = todoList.viewTasks();
            for (String task : tasks) {
                System.out.println(task);
            }

        } catch (MalformedURLException e) {
            System.err.println("URL not valid: " + e);
        } catch (RemoteException e) {
            System.err.println("RemoteException: " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
