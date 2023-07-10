import java.util.ArrayList;
import java.util.List;

public class HistorySaver {
    private final static List<Message> validMessages = new ArrayList<Message>();
    private final static List<Message> nonValidMessages = new ArrayList<Message>();

    public static void addToHistory(Message message, boolean status) {
        if (status) {
            validMessages.add(message);
        } else {
            nonValidMessages.add(message);
        }
    }
}
