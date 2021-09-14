package commands;

import com.company.*;
import managers.ConsoleDataManager;

import java.util.Date;
import java.util.List;

public class InsertCommand extends AbstractCommand{
    private ConsoleDataManager consoleDataManager = new ConsoleDataManager();

    public InsertCommand(CityStorage storage, List<String> args) {
        super(storage, args);
    }

    @Override
    public void execute() {
        String cityName = consoleDataManager.getCityName();
        Coordinates coordinates = consoleDataManager.getCoordinates();
        Date birthDate = consoleDataManager.getDate();
        Long area = consoleDataManager.getArea();
        Integer population = consoleDataManager.getPopulation();
        Long metersAboveSeaLevel = consoleDataManager.getMetersAboveSeaLevel();
        Date establishmentDate = consoleDataManager.getDate();
        Double agglomiration = consoleDataManager.getAgglomiration();
        Climate climate = consoleDataManager.getClimate();
        Human governor = consoleDataManager.getGovernor();

        storage.createNew(
                cityName,
                coordinates,
                birthDate,
                area,
                population,
                metersAboveSeaLevel,
                establishmentDate,
                agglomiration,
                climate,
                governor
        );

    }
}
