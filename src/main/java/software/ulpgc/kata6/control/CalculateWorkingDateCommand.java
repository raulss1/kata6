package software.ulpgc.kata6.control;

import software.ulpgc.kata6.model.Calendar;

import java.time.LocalDate;

public class CalculateWorkingDateCommand implements Command{
    private final Calendar calendar;
    private final Input input;
    private final Output output;

    public CalculateWorkingDateCommand(Calendar calendar, Input input, Output output) {
        this.calendar = calendar;
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        int days = input.days();
        for (LocalDate localDate : calendar.from(input.start())) {
            if (days == 0) {
                output.endDate(localDate);
                break;
            }
            days--;
        }
    }

    public interface Input{
        LocalDate start();
        int days();
    }

    public interface Output{
        void endDate(LocalDate localDate);
    }
}
