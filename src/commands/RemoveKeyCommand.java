package commands;

import com.company.CityStorage;

import java.util.List;

public class RemoveKeyCommand extends AbstractCommand{

    public RemoveKeyCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        String id = this.args.get(0);

        storage.removeKey(Long.valueOf(id));
    }
}
