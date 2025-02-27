package sfgamedataeditor.views.main.modules.items.workersrunes;

import sfgamedataeditor.database.items.price.parameters.ItemPriceParametersTableService;
import sfgamedataeditor.views.common.ModuleParameter;
import sfgamedataeditor.views.common.ObjectTuple;
import sfgamedataeditor.views.common.presenters.AbstractModulesPresenter;
import sfgamedataeditor.views.main.modules.items.workersrunes.parameters.WorkersRunesParametersModel;

import java.util.List;

public class WorkersRuneRacesPresenter extends AbstractModulesPresenter<ModuleParameter, WorkersRuneRacesView, WorkersRunesParametersModel> {

    private final WorkerRunesModelCreator modelCreator = new WorkerRunesModelCreator();

    public WorkersRuneRacesPresenter(WorkersRuneRacesView view) {
        super(view);
    }

    @Override
    protected WorkersRunesParametersModel createModel() {
        String selectedModuleName = getView().getSelectedModuleName();
        Integer itemType = WorkerRunesMapping.INSTANCE.getWorkerRuneTypeByName(selectedModuleName);
        List<ObjectTuple> runesNames = ItemPriceParametersTableService.INSTANCE.getItemsByItemType(itemType);
        String runeName = runesNames.get(0).getName();
        Integer itemId = ItemPriceParametersTableService.INSTANCE.getItemIdByItemNameAndType(runeName, itemType);
        return modelCreator.createModel(itemId);
    }
}
