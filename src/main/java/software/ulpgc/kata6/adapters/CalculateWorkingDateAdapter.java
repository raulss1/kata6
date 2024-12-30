package software.ulpgc.kata6.adapters;

import software.ulpgc.kata6.control.CalculateWorkingDateCommand;
import software.ulpgc.kata6.control.CalculateWorkingDaysCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class CalculateWorkingDateAdapter {
    public static CalculateWorkingDateCommand.Input adapt(Request request){
        return new CalculateWorkingDateCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(request.queryParams("from"));
            }

            @Override
            public int days() {
                return Integer.parseInt(request.queryParams("days"));
            }
        };
    }

    public static CalculateWorkingDateCommand.Output adapt(Response response){
        return new CalculateWorkingDateCommand.Output() {
            @Override
            public void endDate(LocalDate localDate) {
                response.body(localDate.toString());
            }
        };
    }
}
