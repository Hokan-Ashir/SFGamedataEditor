package sfgamedataeditor.views.main.modules.creatures.races;

import sfgamedataeditor.database.creatures.parameters.CreatureParametersTableService;
import sfgamedataeditor.mvc.objects.AbstractPresenter;
import sfgamedataeditor.views.common.ObjectTuple;
import sfgamedataeditor.views.common.managers.AbstractModulePanelManager;
import sfgamedataeditor.views.common.managers.NameModulesPanelManager;
import sfgamedataeditor.views.common.views.AbstractModulesView;
import sfgamedataeditor.views.main.modules.creatures.races.creatures.CreaturesView;
import sfgamedataeditor.views.utility.i18n.I18NService;
import sfgamedataeditor.views.utility.i18n.I18NTypes;

import java.util.List;

public class CreaturesRacesView extends AbstractModulesView {

    public CreaturesRacesView() {
        super(I18NService.INSTANCE.getMessage(I18NTypes.COMMON, "races"));
    }

    @Override
    public void fillSubViewsMappings() {
        List<ObjectTuple> mappings = CreatureParametersTableService.INSTANCE.getListOfCreatureRaces();
        addMappings(mappings, CreaturesView.class);
    }

    @Override
    public Class<? extends AbstractPresenter> getPresenterClass() {
        return CreaturesRacesPresenter.class;
    }

    @Override
    protected Class<? extends AbstractModulePanelManager> getModulesPanelManagerClass() {
        return NameModulesPanelManager.class;
    }

    @Override
    protected String getIconPath() {
        return "/images/races/";
    }

    @Override
    public void localize() {
        setModuleName(I18NService.INSTANCE.getMessage(I18NTypes.COMMON, "races"));
    }
}
