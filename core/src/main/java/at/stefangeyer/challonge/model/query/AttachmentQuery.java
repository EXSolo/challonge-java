package at.stefangeyer.challonge.model.query;

import kotlin.Lazy;
import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Data
@Builder
public class AttachmentQuery {
    private Lazy assetMimeType$delegate;
    private File asset;
    private String url;
    private String description;

    public String getAssetMimeType() throws IOException {
        return this.asset != null ? Files.probeContentType(this.asset.toPath()) : null;
    }
}
