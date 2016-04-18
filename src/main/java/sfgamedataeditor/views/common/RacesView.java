package sfgamedataeditor.views.common;

import sfgamedataeditor.events.ClassTuple;
import sfgamedataeditor.utils.I18N;

public class RacesView<T extends AbstractView> extends AbstractModulesView<T> {

    public RacesView(T parentView) {
        super(parentView, I18N.INSTANCE.getMessage("races"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void fillComboBoxMapping() {
        ClassTuple tuple = new ClassTuple(NotImplementedView.class, this);
        ShowNotImplementedViewEvent event = new ShowNotImplementedViewEvent(tuple);
        addMapping(I18N.INSTANCE.getMessage("race.humans"), event);
        addMapping(I18N.INSTANCE.getMessage("race.elves"), event);
        addMapping(I18N.INSTANCE.getMessage("race.dwarves"), event);
        addMapping(I18N.INSTANCE.getMessage("race.orcs"), event);
        addMapping(I18N.INSTANCE.getMessage("race.trolls"), event);
        addMapping(I18N.INSTANCE.getMessage("race.darkElves"), event);
    }

}
