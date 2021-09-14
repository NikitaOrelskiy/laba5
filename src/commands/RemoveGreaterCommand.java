package commands;

import com.company.CityStorage;

import java.util.List;

public class RemoveGreaterCommand extends AbstractCommand{
    public RemoveGreaterCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        storage.removeGreater(Long.valueOf(args.get(0)));
    }
}
