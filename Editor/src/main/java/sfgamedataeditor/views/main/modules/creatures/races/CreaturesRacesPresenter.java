package sfgamedataeditor.views.main.modules.creatures.races;

import sfgamedataeditor.database.creatures.common.CreatureCommonParametersTableService;
import sfgamedataeditor.views.common.ModuleParameter;
import sfgamedataeditor.views.common.ObjectTuple;
import sfgamedataeditor.views.common.presenters.AbstractModulesPresenter;
import sfgamedataeditor.views.main.modules.creatures.races.creatures.CreaturesModel;
import sfgamedataeditor.views.main.modules.creatures.races.creatures.CreaturesModelParameter;

import java.util.List;

public class CreaturesRacesPresenter extends AbstractModulesPresenter<ModuleParameter, CreaturesRacesView, CreaturesModel> {

    public CreaturesRacesPresenter(CreaturesRacesView view) {
        super(view);
    }

    @Override
    protected CreaturesModel createModel() {
        Integer raceId = getView().getSelectedModuleObjectId();
        List<ObjectTuple> creatureNames = CreatureCommonParametersTableService.INSTANCE.getCreatureNamesByRaceId(raceId);
        CreaturesModelParameter parameter = new CreaturesModelParameter(creatureNames, null);
        return new CreaturesModel(parameter);
    }
}
