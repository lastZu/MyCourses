import java.util.HashMap;

public class EnrichmentService implements ContentService {
    private ContentEnricher contentEnricher;

    public EnrichmentService(ContentEnricher contentEnricher) {
        this.contentEnricher = contentEnricher;
    }
    // возвращается обогащенный (или необогащенный content сообщения)
    public String enrich(Message message) {
        final String content = message.getContent();
        final String msisdn = getMsisdn(content);
        final HashMap<String, String> enrichment = contentEnricher.enrichmentValue(msisdn);
        final String newContent = contentEnricher.enrich(content, enrichment);
        addToEnrichMessages(message);
        return newContent;
    }
}
