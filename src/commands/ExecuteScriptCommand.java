package commands;

import com.company.CityStorage;
import com.company.FileManager;
import managers.ConsoleCommandManager;
import managers.ExecutorManager;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }


    @Override
    public void execute() {
        String filename = args.isEmpty() ? "list.txt" : args.get(0);
        File f = new File(filename);
        ExecutorManager executorManager = new ExecutorManager(storage, f);
        executorManager.execute();
    }
}
