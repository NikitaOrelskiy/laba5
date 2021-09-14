package commands;

import com.company.City;
import com.company.CityStorage;
import com.company.Human;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class RemoveAllByGovernorCommand extends AbstractCommand{
    public RemoveAllByGovernorCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        String name = args.get(0);
        Long height = Long.valueOf(args.get(1));
        String birthDate = args.get(2);
        Human governor = new Human(
                name,
                height,
                birthDate
        );


        storage.removeByGovernor(governor);
    }

}
