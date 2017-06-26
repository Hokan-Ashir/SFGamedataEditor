package sfgamedataeditor.views.main.modules.items.buildingplans;

import sfgamedataeditor.mvc.objects.AbstractPresenter;
import sfgamedataeditor.mvc.objects.PresentableView;
import sfgamedataeditor.views.common.SubViewPanelTuple;
import sfgamedataeditor.views.common.views.AbstractModulesView;
import sfgamedataeditor.views.common.views.AbstractRacesView;
import sfgamedataeditor.views.main.modules.items.buildingplans.buildings.BuildingsPlanListView;
import sfgamedataeditor.views.main.modules.items.unitplans.UnitRaceToItemPlansMapping;
import sfgamedataeditor.views.main.modules.items.unitplans.units.UnitsPlanListView;
import sfgamedataeditor.views.utility.i18n.I18NService;
import sfgamedataeditor.views.utility.i18n.I18NTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildingPlansRacesView extends AbstractModulesView {

    public BuildingPlansRacesView() {
        super(I18NService.INSTANCE.getMessage(I18NTypes.COMMON, "races"));
    }

    @Override
    public Class<? extends AbstractPresenter> getPresenterClass() {
        return BuildingPlansRacesPresenter.class;
    }

    @Override
    public void fillSubViewsMappings() {
        List<SubViewPanelTuple> mappings = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : BuildingRaceToItemPlansMapping.INSTANCE.mappings.entrySet()) {
            mappings.add(new SubViewPanelTuple(entry.getKey(), entry.getValue()));
        }

        addMappings(mappings, BuildingsPlanListView.class);
    }
}
