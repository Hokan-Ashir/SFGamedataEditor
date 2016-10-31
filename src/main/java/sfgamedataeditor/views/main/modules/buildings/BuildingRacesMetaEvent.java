package sfgamedataeditor.views.main.modules.buildings;

import sfgamedataeditor.events.ClassTuple;
import sfgamedataeditor.events.EventCreator;
import sfgamedataeditor.events.types.AbstractViewableMetaEvent;
import sfgamedataeditor.events.types.ShowViewEvent;
import sfgamedataeditor.views.main.MainView;
import sfgamedataeditor.views.main.modules.common.modules.ModulesView;

public class BuildingRacesMetaEvent extends AbstractViewableMetaEvent<ModulesMetaEvent> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addEvents() {
        SetModuleNameEvent moduleNameEvent = new SetModuleNameEvent(ModulesView.class, MainView.class);
        ShowBuildingRacesViewEvent event = EventCreator.createEvent(BuildingRacesView.class, MainView.class, ShowBuildingRacesViewEvent.class);
        addEvents(moduleNameEvent, event);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModulesMetaEvent createParentMetaEvent() {
        return new ModulesMetaEvent();
    }
}

class ShowBuildingRacesViewEvent extends ShowViewEvent<BuildingRacesView, MainView, Object> {

    public ShowBuildingRacesViewEvent(ClassTuple<BuildingRacesView, MainView> tuple) {
        super(tuple);
    }
}
