package commands;

import com.company.CityStorage;

import java.util.List;

public class PrintAscendingCommand extends AbstractCommand{

    public PrintAscendingCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }


    @Override
    public void execute() {
        storage.sortById();
    }
}
