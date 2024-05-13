package hexlet.code.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePage {
    private String flash;
    private String flashType;

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public void setFlashType(String flashType) {
        this.flashType = flashType;
    }
}
