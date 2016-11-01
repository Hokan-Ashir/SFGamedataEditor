package sfgamedataeditor.views.main.modules.skills.schools.parameters;

import sfgamedataeditor.events.processing.ViewRegister;
import sfgamedataeditor.fieldwrapping.FieldsWrapperCreator;
import sfgamedataeditor.fieldwrapping.fields.IDataField;
import sfgamedataeditor.mvc.objects.AbstractController;
import sfgamedataeditor.views.common.RenderableView;
import sfgamedataeditor.views.main.MainView;

import javax.swing.*;
import java.util.Collection;

public class SkillParameterView implements RenderableView {

    private final SkillParameterViewStub stub;
    private final Collection<IDataField> dataFields;

    public SkillParameterView() {
        this.stub = new SkillParameterViewStub();
        this.dataFields = FieldsWrapperCreator.createFieldWrappers(stub);
    }

    public Collection<IDataField> getDataFields() {
        return dataFields;
    }

    public JComboBox<String> getLevelComboBox() {
        return stub.getLevelComboBox();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JPanel getMainPanel() {
        return stub.getMainPanel();
    }

    @Override
    public void render() {
        MainView mainView = ViewRegister.INSTANCE.getView(MainView.class);
        mainView.renderViewInsideContentPanel(this);
    }

    @Override
    public void unrender() {

    }

    @Override
    public Class<? extends AbstractController> getControllerClass() {
        return SkillParameterController.class;
    }
}
