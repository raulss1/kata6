package software.ulpgc.kata6;

import software.ulpgc.kata6.adapters.CalculateWorkingDateAdapter;
import software.ulpgc.kata6.adapters.CalculateWorkingDaysAdapter;
import software.ulpgc.kata6.control.CalculateWorkingDateCommand;
import software.ulpgc.kata6.control.CalculateWorkingDaysCommand;
import software.ulpgc.kata6.control.Command;
import software.ulpgc.kata6.model.Calendar;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
        new WebService(commandFactory()).init();
    }

    private static CommandFactory commandFactory() {
        return new CommandFactory()
                .add("working-days", Main::createWorkingDaysCommand)
                .add("working-date", Main::createWorkingDateCommand);
    }

    private static Command createWorkingDaysCommand(Request request, Response response) {
        return new CalculateWorkingDaysCommand(new Calendar(), CalculateWorkingDaysAdapter.adapt(request), CalculateWorkingDaysAdapter.adapt(response));
    }

    private static Command createWorkingDateCommand(Request request, Response response) {
        return new CalculateWorkingDateCommand(new Calendar(), CalculateWorkingDateAdapter.adapt(request), CalculateWorkingDateAdapter.adapt(response));
    }
}
