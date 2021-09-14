package commands;

import com.company.CityStorage;

import java.util.List;

public class InfoCommand extends AbstractCommand{

    public InfoCommand(CityStorage storage, List<String> args) {
        super(storage, args);

    }


    @Override
    public void execute() {
        System.out.println("Size " + this.storage.size());
    }


}
