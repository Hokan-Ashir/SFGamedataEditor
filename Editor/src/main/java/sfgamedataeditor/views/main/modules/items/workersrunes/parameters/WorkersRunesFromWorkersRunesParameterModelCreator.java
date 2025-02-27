package sfgamedataeditor.views.main.modules.items.workersrunes.parameters;


import sfgamedataeditor.database.items.price.parameters.ItemPriceParametersTableService;
import sfgamedataeditor.mvc.ModelCreator;
import sfgamedataeditor.views.common.ModuleParameter;
import sfgamedataeditor.views.common.ModulesModel;
import sfgamedataeditor.views.common.ObjectTuple;
import sfgamedataeditor.views.main.modules.items.workersrunes.WorkerRunesMapping;

public class WorkersRunesFromWorkersRunesParameterModelCreator implements ModelCreator<ModulesModel, WorkersRunesParametersModel> {

    @Override
    public ModulesModel createModel(WorkersRunesParametersModel childModel) {
        String runeName = childModel.getParameter().getRuneName();
        Integer itemId = ItemPriceParametersTableService.INSTANCE.getItemIdByItemName(runeName);
        int itemType = ItemPriceParametersTableService.INSTANCE.getItemTypeIdByItemId(itemId);
        String raceName = WorkerRunesMapping.INSTANCE.getWorkerRuneRaceName(itemType);
        ModuleParameter parameter = new ModuleParameter(new ObjectTuple(raceName));
        return new ModulesModel(parameter);
    }
}
