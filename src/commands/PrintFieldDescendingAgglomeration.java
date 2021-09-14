package commands;

import com.company.CityStorage;

import java.util.List;

public class PrintFieldDescendingAgglomeration extends AbstractCommand{
    public PrintFieldDescendingAgglomeration(CityStorage storage, List<String> args) {
        super(storage, args);
    }


    @Override
    public void execute() {
        storage.printAgglomiration();
    }
}
