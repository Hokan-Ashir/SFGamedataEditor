package sfgamedataeditor.views.common.races;

import sfgamedataeditor.mvc.objects.AbstractPresenter;
import sfgamedataeditor.views.common.AbstractModulesView;
import sfgamedataeditor.views.utility.i18n.I18NService;
import sfgamedataeditor.views.utility.i18n.I18NTypes;

public abstract class AbstractRacesView extends AbstractModulesView {

    protected AbstractRacesView() {
        super(I18NService.INSTANCE.getMessage(I18NTypes.COMMON, "races"));
    }

    @Override
    public Class<? extends AbstractPresenter> getPresenterClass() {
        return AbstractRacesPresenter.class;
    }
}
