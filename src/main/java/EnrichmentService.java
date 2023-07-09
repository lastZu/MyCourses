import java.util.HashMap;

public class EnrichmentService {
    private MessageValidator messageValidator;
    private ContentEnricher contentEnricher;

    public EnrichmentService(MessageValidator messageValidator,
                             ContentEnricher contentEnricher) {
        this.messageValidator = messageValidator;
        this.contentEnricher = contentEnricher;
    }
    // возвращается обогащенный (или необогащенный content сообщения)
    public String enrich(Message message) {
        if (!messageValidator.correct(message)) {
            addToNonEnrichMessages(message);
            return message.getContent();
        }
        final String content = message.getContent();
        final String msisdn = getMsisdn(content);
        final HashMap<String, String> enrichment = contentEnricher.enrichmentValue(msisdn);
        final String newContent = contentEnricher.enrich(content, enrichment);
        addToEnrichMessages(message);
        return newContent;
    }
}
