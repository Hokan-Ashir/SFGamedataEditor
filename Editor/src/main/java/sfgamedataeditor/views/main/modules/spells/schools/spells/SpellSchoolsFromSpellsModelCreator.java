package sfgamedataeditor.views.main.modules.spells.schools.spells;

import sfgamedataeditor.database.spells.names.SpellNameObject;
import sfgamedataeditor.database.spells.names.SpellNameTableService;
import sfgamedataeditor.database.spells.parameters.SpellParametersObject;
import sfgamedataeditor.database.spells.parameters.SpellParametersTableService;
import sfgamedataeditor.mvc.ModelCreator;
import sfgamedataeditor.views.common.ModuleParameter;
import sfgamedataeditor.views.common.ModulesModel;
import sfgamedataeditor.views.common.ObjectTuple;

public class SpellSchoolsFromSpellsModelCreator implements ModelCreator<ModulesModel, SpellModel> {

    @Override
    public ModulesModel createModel(SpellModel childModel) {
        // no difference which exactly spell we take, cause we WILL select first suitable spell school
        String spellName = childModel.getParameter().getSubViewPanelTuples().get(0).getName();
        // TODO maybe store whole SpellParameter inside SpellPresenter, to limit DB queries
        SpellNameObject spellNameDAO = SpellNameTableService.INSTANCE.getSpellName(spellName);
        Integer spellType = spellNameDAO.spellType;
        SpellParametersObject spellParameter = SpellParametersTableService.INSTANCE.getSpellParametersBySpellType(spellType);
        ObjectTuple tuple = SpellParametersTableService.INSTANCE.getSpellSchoolTuple(spellParameter);
        ModuleParameter parameter = new ModuleParameter(tuple);
        return new ModulesModel(parameter);
    }
}
