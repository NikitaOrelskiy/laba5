package commands;

import com.company.CityStorage;

import java.util.List;

public class ShowCommand extends AbstractCommand{
    public ShowCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        storage.printAll();
    }
}
