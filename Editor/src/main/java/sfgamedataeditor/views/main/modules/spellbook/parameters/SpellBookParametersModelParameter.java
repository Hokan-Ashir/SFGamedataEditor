package sfgamedataeditor.views.main.modules.spellbook.parameters;

import javax.swing.*;

public class SpellBookParametersModelParameter {
    private final String scrollBaseName;
    private int scrollLevel;
    private final Icon icon;

    public SpellBookParametersModelParameter(String scrollBaseName, int scrollLevel, Icon icon) {
        this.scrollBaseName = scrollBaseName;
        this.scrollLevel = scrollLevel;
        this.icon = icon;
    }

    public String getScrollBaseName() {
        return scrollBaseName;
    }

    public int getScrollLevel() {
        return scrollLevel;
    }

    public void setScrollLevel(int scrollLevel) {
        this.scrollLevel = scrollLevel;
    }

    public Icon getIcon() {
        return icon;
    }
}
