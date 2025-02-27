package sfgamedataeditor.views.common;

import sfgamedataeditor.mvc.objects.PresentableView;

import javax.swing.*;

public class SubViewPanel {
    private final JButton button;
    private Class<? extends PresentableView> subViewClass;
    private Integer objectId;

    public SubViewPanel() {
        button = new JButton();
    }

    public void setSubViewClass(Class<? extends PresentableView> subViewClass) {
        this.subViewClass = subViewClass;
    }

    public JButton getButton() {
        return button;
    }

    public Class<? extends PresentableView> getSubViewClass() {
        return subViewClass;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
}
