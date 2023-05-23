package pages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data // Gettors, settors auto-generator
@JsonIgnoreProperties(ignoreUnknown = true)
public class Support {
    public String url;
    public String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Support(String url, String text) {
        this.url = url;
        this.text = text;
    }
}
