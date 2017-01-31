package sfgamedataeditor.events.processing.strategies.content.modelcreators.spells;

import sfgamedataeditor.database.spells.names.SpellNameObject;
import sfgamedataeditor.database.spells.names.SpellNameTableService;
import sfgamedataeditor.database.spells.parameters.SpellParametersObject;
import sfgamedataeditor.database.spells.parameters.SpellParametersTableService;
import sfgamedataeditor.database.spells.school.names.SpellSchoolNameTableService;
import sfgamedataeditor.mvc.ModelCreator;
import sfgamedataeditor.views.common.ModuleParameter;
import sfgamedataeditor.views.common.ModulesModel;
import sfgamedataeditor.views.main.modules.spells.schools.spells.SpellModel;

public class SpellSchoolsFromSpellsModelCreator implements ModelCreator<ModulesModel, SpellModel> {

    @Override
    public ModulesModel createModel(SpellModel childModel) {
        // no difference which exactly spell we take, cause we WILL select first suitable spell school
        String spellName = childModel.getParameter().getSubPanelsNames().iterator().next();
        // TODO maybe store whole SpellParameter inside SpellPresenter, to limit DB queries
        SpellNameObject spellNameDAO = SpellNameTableService.INSTANCE.getSpellName(spellName);
        Integer spellType = spellNameDAO.spellType;
        SpellParametersObject spellParameter = SpellParametersTableService.INSTANCE.getSpellParametersBySpellType(spellType);
        String spellSchoolName = SpellSchoolNameTableService.INSTANCE.getSpellSchoolName(spellParameter);
        ModuleParameter parameter = new ModuleParameter(spellSchoolName);
        return new ModulesModel(parameter);
    }
}
