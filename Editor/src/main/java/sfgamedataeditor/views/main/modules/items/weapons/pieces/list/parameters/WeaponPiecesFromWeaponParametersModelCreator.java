package sfgamedataeditor.views.main.modules.items.weapons.pieces.list.parameters;

import sfgamedataeditor.database.items.armor.parameters.ArmorParametersTableService;
import sfgamedataeditor.database.items.price.parameters.ItemPriceParametersTableService;
import sfgamedataeditor.mvc.ModelCreator;
import sfgamedataeditor.views.main.modules.items.weapons.pieces.list.WeaponPiecesModel;
import sfgamedataeditor.views.main.modules.items.weapons.pieces.list.WeaponPiecesModelParameter;
import sfgamedataeditor.views.utility.i18n.I18NService;
import sfgamedataeditor.views.utility.i18n.I18NTypes;

import java.util.Set;

public class WeaponPiecesFromWeaponParametersModelCreator implements ModelCreator<WeaponPiecesModel, WeaponParametersModel> {
    @Override
    public WeaponPiecesModel createModel(WeaponParametersModel childModel) {
        Set<String> itemNames;

        if (childModel.getParameter().getArmorParametersObject() != null
                && childModel.getParameter().getWeaponParametersObject() == null) {
            itemNames = ArmorParametersTableService.INSTANCE.getOrbNames();
        } else {

            Integer typeId = childModel.getParameter().getPriceParametersObject().typeId;
            itemNames = ItemPriceParametersTableService.INSTANCE.getItemsByItemType(typeId);
        }
        Integer itemId = childModel.getParameter().getPriceParametersObject().itemId;
        String selectedItem = I18NService.INSTANCE.getMessage(I18NTypes.ITEMS, String.valueOf(itemId));
        WeaponPiecesModelParameter parameter = new WeaponPiecesModelParameter(itemNames, selectedItem);
        return new WeaponPiecesModel(parameter);
    }
}
