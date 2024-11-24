import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TodoList extends Remote {
    void addTask(String task) throws RemoteException;
    void removeTask(String task) throws RemoteException;
    String[] viewTasks() throws RemoteException;
    void editTask(String oldTask, String newTask) throws RemoteException;
    void setDeadline(String task, String deadline) throws RemoteException;
}
