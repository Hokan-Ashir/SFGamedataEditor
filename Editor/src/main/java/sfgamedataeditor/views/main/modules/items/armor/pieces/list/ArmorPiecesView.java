package sfgamedataeditor.views.main.modules.items.armor.pieces.list;

import sfgamedataeditor.mvc.objects.AbstractPresenter;
import sfgamedataeditor.views.common.managers.AbstractModulePanelManager;
import sfgamedataeditor.views.common.managers.NameModulesPanelManager;
import sfgamedataeditor.views.common.views.AbstractModulesView;
import sfgamedataeditor.views.utility.i18n.I18NService;
import sfgamedataeditor.views.utility.i18n.I18NTypes;

public class ArmorPiecesView extends AbstractModulesView {

    public ArmorPiecesView() {
        super(I18NService.INSTANCE.getMessage(I18NTypes.ARMOR_GUI, "items"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fillSubViewsMappings() {
    }

    @Override
    public Class<? extends AbstractPresenter> getPresenterClass() {
        return ArmorPiecesPresenter.class;
    }

    @Override
    protected Class<? extends AbstractModulePanelManager> getModulesPanelManagerClass() {
        return NameModulesPanelManager.class;
    }

    @Override
    public void localize() {
        setModuleName(I18NService.INSTANCE.getMessage(I18NTypes.ARMOR_GUI, "items"));
    }
}
