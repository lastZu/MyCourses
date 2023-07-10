
public class MessageValidator implements ContentService {
    private ContentService origin;
    private Validator validator;

    public MessageValidator(ContentService origin, Validator validator) {
       this.origin = origin;
       this.validator = validator;
    }

    public String enrich(Message message) {
        if (validator.isCorrect(message)) {
            return origin.enrich(message);
        }
        return message.getContent();
    }
}
