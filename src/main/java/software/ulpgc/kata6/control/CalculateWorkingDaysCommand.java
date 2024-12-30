package software.ulpgc.kata6.control;

import software.ulpgc.kata6.model.Calendar;

import java.lang.ref.PhantomReference;
import java.time.LocalDate;

public class CalculateWorkingDaysCommand implements Command{
    private final Calendar calendar;
    private final Input input;
    private final Output output;

    public CalculateWorkingDaysCommand(Calendar calendar, Input input, Output output) {
        this.calendar = calendar;
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        int days = 0;
        for (LocalDate localDate : calendar.from(input.start())) {
            if(localDate.isAfter(input.end())) break;
            days++;
        }
        output.days(days);
    }

    public interface Input{
        LocalDate start();
        LocalDate end();
    }

    public interface Output{
        void days(int days);
    }
}
