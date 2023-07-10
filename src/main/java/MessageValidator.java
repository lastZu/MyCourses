
public class MessageValidator implements MessageService{
   private MessageService origin;
   private Validator validator;

   public MessageValidator(MessageService origin, Validator validator) {
       this.origin = origin;
       this.validator = validator;
   }

    public String enrich(Message message) {
        if (validator.correct(message)) {
            return origin.enrich(message);
        }
        addToNonEnrichMessages(message);
        return message.getContent();
    }
}
