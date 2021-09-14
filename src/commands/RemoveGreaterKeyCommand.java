package commands;

import com.company.CityStorage;

import java.util.List;

public class RemoveGreaterKeyCommand extends AbstractCommand{
    public RemoveGreaterKeyCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        String id = this.args.get(0);

        storage.removeGreaterKey(Long.valueOf(id));
    }
}
