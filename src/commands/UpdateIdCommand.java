package commands;

import com.company.CityStorage;
import com.company.Climate;
import com.company.Coordinates;
import com.company.Human;
import managers.ConsoleDataManager;

import java.util.Date;
import java.util.List;

public class UpdateIdCommand extends AbstractCommand{
    private ConsoleDataManager consoleDataManager = new ConsoleDataManager();

    public UpdateIdCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        if (this.args.size() == 0) {
            throw new RuntimeException("no such arguments");
        }
        Long id;
        try {
            id = Long.valueOf(this.args.get(0));
        } catch (Exception e) {
            throw new RuntimeException("invalid argument");
        }

        String cityName = consoleDataManager.getCityName();

        storage.updateByKey(
                id,
                cityName
        );
    }
}
