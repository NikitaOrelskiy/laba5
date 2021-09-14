package managers;

import com.company.CityStorage;
import commands.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExecutorManager {
    private Scanner scanner;
    private CityStorage cityStorage;

    public ExecutorManager(CityStorage cityStorage, InputStream inputStream) {
        this.cityStorage = cityStorage;
        this.scanner = new Scanner(inputStream); //inputStream === System.in
    }

    public ExecutorManager(CityStorage cityStorage, File file) {
        this.cityStorage = cityStorage;
        try {
            this.scanner = new Scanner(file);  //file === new File("...")
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void execute(){
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager(scanner);

        for (String line: consoleCommandManager) {
            boolean shouldContinue = doCommand(line);
            if (!shouldContinue) {
                break;
            }
        }
    }

    private boolean doCommand(String line) {
        List<String> tokens = Arrays.asList(line.split("\\s+"));
        String commandName = tokens.get(0);
        List<String> args = tokens.subList(1, tokens.size());

        Command command = null;
        if ("exit".equals(commandName)) {
            return false;
        }
        if ("help".equals(commandName)) {
            command = new HelpCommand(cityStorage, args);
        } else if("show".equals(commandName)){
            command = new ShowCommand(cityStorage, args);
        } else if("info".equals(commandName)) {
            command = new InfoCommand(cityStorage, args);
        }else if("insert".equals(commandName)) {
            command = new InsertCommand(cityStorage, args);
        }else if("updateid".equals(commandName)) {
            command = new UpdateIdCommand(cityStorage, args);
        }else if("removekey".equals(commandName)) {
            command = new RemoveKeyCommand(cityStorage, args);
        }else if("clear".equals(commandName)) {
            command = new ClearCommand(cityStorage, args);
        }else if("save".equals(commandName)) {
            command = new SaveCommand(cityStorage, args);
        }else if("execute_script".equals(commandName)) {
            command = new ExecuteScriptCommand(cityStorage, args);
        }else if("remove_greater".equals(commandName)) {
            command = new RemoveGreaterCommand(cityStorage, args);
        }else if("remove_greater_key".equals(commandName)) {
            command = new RemoveGreaterKeyCommand(cityStorage, args);
        }else if("remove_lower_key".equals(commandName)) {
            command = new RemoveLowerKeyCommand(cityStorage, args);
        }else if("remove_all_by_governor".equals(commandName)) {
            command = new RemoveAllByGovernorCommand(cityStorage, args);
        }else if("print_ascending".equals(commandName)) {
            command = new PrintAscendingCommand(cityStorage, args);
        }else if("print_field_descending_agglomeration".equals(commandName)) {
            command = new PrintFieldDescendingAgglomeration(cityStorage, args);
        }
        if (command != null) {
            command.execute();
        }
        return true;
    }

}
