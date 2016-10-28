package sfgamedataeditor.views.main.modules.items.buildingplans;

import sfgamedataeditor.events.ClassTuple;
import sfgamedataeditor.events.EventCreator;
import sfgamedataeditor.events.types.AbstractViewableMetaEvent;
import sfgamedataeditor.events.types.ClearViewEvent;
import sfgamedataeditor.events.types.SetModuleNameEvent;
import sfgamedataeditor.events.types.ShowViewEvent;
import sfgamedataeditor.views.main.MainView;
import sfgamedataeditor.views.main.modules.items.ItemTypesMetaEvent;
import sfgamedataeditor.views.main.modules.items.ItemTypesView;

public class BuildingPlansMetaEvent extends AbstractViewableMetaEvent<ItemTypesMetaEvent> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addEvents() {
        SetModuleNameEvent moduleNameEvent = new SetModuleNameEvent(ItemTypesView.class, MainView.class);
        ShowBuildingPlansViewEvent event = EventCreator.createEvent(BuildingPlansListView.class, MainView.class, ShowBuildingPlansViewEvent.class);
        ClearViewEvent clearViewEvent = new ClearViewEvent<>(BuildingPlansListView.class, MainView.class);
        addEvents(moduleNameEvent, event, clearViewEvent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemTypesMetaEvent createParentMetaEvent() {
        return new ItemTypesMetaEvent();
    }
}

class ShowBuildingPlansViewEvent extends ShowViewEvent<BuildingPlansListView, MainView, Object> {

    public ShowBuildingPlansViewEvent(ClassTuple<BuildingPlansListView, MainView> tuple) {
        super(tuple);
    }
}
