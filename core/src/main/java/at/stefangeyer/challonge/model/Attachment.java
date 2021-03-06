package at.stefangeyer.challonge.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;

@Data
@Builder
@EqualsAndHashCode(exclude = {"createdAt", "updatedAt"})
public class Attachment {
    private Long id;
    private Long matchId;
    private Long userId;
    private String description;
    private String url;
    private String originalFileName;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String assetFileName;
    private String assetContentType;
    private Long assetFileSize;
    private String assetUrl;
}
