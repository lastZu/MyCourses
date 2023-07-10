public class MessageHistorySaver implements ContentService{
    private ContentService origin;
    private final boolean validateStatus;

    public MessageHistorySaver(ContentService origin, boolean validateStatus) {
        this.origin = origin;
        this.validateStatus = validateStatus;
    }

    public String enrich(Message message) {
        HistorySaver.addToHistory(message, validateStatus);
        return origin.enrich(message);
    }
}
