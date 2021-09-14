package commands;

import com.company.CityStorage;

import java.util.List;

public class ClearCommand extends AbstractCommand{

    public ClearCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        storage.clear();
        System.out.println("Collection is empty");
    }
}
