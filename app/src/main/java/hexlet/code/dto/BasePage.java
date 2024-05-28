package hexlet.code.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePage {
    private String flash;
    private String flashType;

    public final void setFlash(String flash) {
        this.flash = flash;
    }

    public final void setFlashType(String flashType) {
        this.flashType = flashType;
    }
}
