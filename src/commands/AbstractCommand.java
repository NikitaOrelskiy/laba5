package commands;


import com.company.CityStorage;

import java.util.List;

public abstract class AbstractCommand implements Command{
    protected CityStorage storage;
    protected List<String> args;


    public AbstractCommand(CityStorage storage, List<String> args) {
        this.storage = storage;
        this.args = args;
    }
}
