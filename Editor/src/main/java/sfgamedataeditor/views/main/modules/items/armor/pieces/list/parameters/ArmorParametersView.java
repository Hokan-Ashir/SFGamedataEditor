package sfgamedataeditor.views.main.modules.items.armor.pieces.list.parameters;

import sfgamedataeditor.common.GUIElement;
import sfgamedataeditor.common.viewconfigurations.item.armor.GUIElements;
import sfgamedataeditor.database.items.armor.parameters.ArmorParametersObject;
import sfgamedataeditor.database.items.price.parameters.ItemPriceParametersObject;
import sfgamedataeditor.database.items.requirements.ItemRequirementsObject;
import sfgamedataeditor.mvc.objects.AbstractPresenter;
import sfgamedataeditor.mvc.objects.PresentableView;
import sfgamedataeditor.views.utility.i18n.I18NService;
import sfgamedataeditor.views.utility.i18n.I18NTypes;

import javax.swing.*;

@SuppressWarnings("unused")
public class ArmorParametersView implements PresentableView {

    private JPanel mainPanel;

    @GUIElement(GUIElementId = GUIElements.SELL_PRICE, DTOColumnNames = "copperSellingPrice", DTOClass = ItemPriceParametersObject.class)
    private JPanel sellPricePanel;

    @GUIElement(GUIElementId = GUIElements.BUY_OUT_PRICE, DTOColumnNames = "copperBuyingPrice", DTOClass = ItemPriceParametersObject.class)
    private JPanel buyoutPricePanel;

    @GUIElement(GUIElementId = GUIElements.STRENGTH, DTOColumnNames = "strength", DTOClass = ArmorParametersObject.class)
    private JPanel strengthPanel;

    @GUIElement(GUIElementId = GUIElements.STAMINA, DTOColumnNames = "stamina", DTOClass = ArmorParametersObject.class)
    private JPanel staminaPanel;

    @GUIElement(GUIElementId = GUIElements.AGILITY, DTOColumnNames = "agility", DTOClass = ArmorParametersObject.class)
    private JPanel agilityPanel;

    @GUIElement(GUIElementId = GUIElements.DEXTERITY, DTOColumnNames = "dexterity", DTOClass = ArmorParametersObject.class)
    private JPanel dexterityPanel;

    @GUIElement(GUIElementId = GUIElements.WISDOM, DTOColumnNames = "wisdom", DTOClass = ArmorParametersObject.class)
    private JPanel wisdomPanel;

    @GUIElement(GUIElementId = GUIElements.INTELLIGENCE, DTOColumnNames = "intelligence", DTOClass = ArmorParametersObject.class)
    private JPanel intelligencePanel;

    @GUIElement(GUIElementId = GUIElements.CHARISMA, DTOColumnNames = "charisma", DTOClass = ArmorParametersObject.class)
    private JPanel charismaPanel;

    @GUIElement(GUIElementId = GUIElements.MANA, DTOColumnNames = "mana", DTOClass = ArmorParametersObject.class)
    private JPanel manaPanel;

    @GUIElement(GUIElementId = GUIElements.ARMOR, DTOColumnNames = "armor", DTOClass = ArmorParametersObject.class)
    private JPanel armorPanel;

    @GUIElement(GUIElementId = GUIElements.FIRE_RESISTANCE, DTOColumnNames = "fireResistance", DTOClass = ArmorParametersObject.class)
    private JPanel fireResistancePanel;

    @GUIElement(GUIElementId = GUIElements.ICE_RESISTANCE, DTOColumnNames = "iceResistance", DTOClass = ArmorParametersObject.class)
    private JPanel iceResistancePanel;

    @GUIElement(GUIElementId = GUIElements.MIND_RESISTANCE, DTOColumnNames = "mindResistance", DTOClass = ArmorParametersObject.class)
    private JPanel mindResistancePanel;

    @GUIElement(GUIElementId = GUIElements.BLACK_RESISTANCE, DTOColumnNames = "blackResistance", DTOClass = ArmorParametersObject.class)
    private JPanel blackResistancePanel;

    @GUIElement(GUIElementId = GUIElements.RUN_SPEED, DTOColumnNames = "runSpeed", DTOClass = ArmorParametersObject.class)
    private JPanel runSpeedPanel;

    @GUIElement(GUIElementId = GUIElements.FIGHT_SPEED, DTOColumnNames = "fightSpeed", DTOClass = ArmorParametersObject.class)
    private JPanel fightSpeedPanel;

    @GUIElement(GUIElementId = GUIElements.CAST_SPEED, DTOColumnNames = "castSpeed", DTOClass = ArmorParametersObject.class)
    private JPanel castSpeedPanel;

    @GUIElement(GUIElementId = GUIElements.REQUIREMENT_CLASS_SUBCLASS, DTOColumnNames = {"schoolRequirementClass", "subSchoolRequirementClass"}, DTOClass = ItemRequirementsObject.class)
    private JPanel requirementClassSubClassPanel;

    @GUIElement(GUIElementId = GUIElements.REQUIREMENT_LEVEL, DTOColumnNames = "level", DTOClass = ItemRequirementsObject.class)
    private JPanel requirementLevelPanel;

    private JComboBox<String> requirementsComboBox;

    // TODO temporary commented, should be processed and made invisible in case object ArmorParametersObject is absent
//    @GUIElement(GUIElementId = GUIElements.CHARACTERISTICS_PANEL, DTOClass = ArmorParametersObject.class)
    private JPanel characteristicsPanel;

//    @GUIElement(GUIElementId = GUIElements.CHARACTERISTICS_LABEL, DTOClass = ArmorParametersObject.class)
    private JLabel characteristicsLabel;

//    @GUIElement(GUIElementId = GUIElements.RESISTANCES_PANEL, DTOClass = ArmorParametersObject.class)
    private JPanel resistancesPanel;

//    @GUIElement(GUIElementId = GUIElements.RESISTANCES_LABEL, DTOClass = ArmorParametersObject.class)
    private JLabel resistancesLabel;

//    @GUIElement(GUIElementId = GUIElements.SPEEDS_PANEL, DTOClass = ArmorParametersObject.class)
    private JPanel speedsPanel;

//    @GUIElement(GUIElementId = GUIElements.SPEEDS_LABEL, DTOClass = ArmorParametersObject.class)
    private JLabel speedsLabel;

    @GUIElement(GUIElementId = GUIElements.ITEM_SET_PANEL, DTOColumnNames = "itemSetId", DTOClass = ItemPriceParametersObject.class)
    private JPanel itemSetPanel;

    public ArmorParametersView() {
        internationalizeCommonLabels();
    }

    private void internationalizeCommonLabels() {
        characteristicsLabel.setText(I18NService.INSTANCE.getMessage(I18NTypes.ARMOR_GUI, "characteristicsLabel"));
        resistancesLabel.setText(I18NService.INSTANCE.getMessage(I18NTypes.ARMOR_GUI, "resistancesLabel"));
        speedsLabel.setText(I18NService.INSTANCE.getMessage(I18NTypes.ARMOR_GUI, "speedsLabel"));
    }

    public JComboBox<String> getRequirementsComboBox() {
        return requirementsComboBox;
    }

    @Override
    public Class<? extends AbstractPresenter> getPresenterClass() {
        return ArmorParametersPresenter.class;
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void localize() {

    }
}
