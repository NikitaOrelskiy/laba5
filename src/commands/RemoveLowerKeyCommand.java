package commands;

import com.company.CityStorage;

import java.util.List;

public class RemoveLowerKeyCommand extends AbstractCommand{
    public RemoveLowerKeyCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        String id = this.args.get(0);
        if (id != null)
            storage.removeLowerKey(Long.valueOf(id));
    }
}
