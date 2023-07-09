public class Message {
    private String content;
    private EnrichmentType enrichmentType;

    public enum EnrichmentType {
        MSISDN;
    }
}