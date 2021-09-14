package commands;

import com.company.CityStorage;

import java.util.List;

public class SaveCommand extends AbstractCommand{
    public SaveCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        storage.saveToFile();
    }
}
