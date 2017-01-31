package sfgamedataeditor.views.main.modules.merchants;

import sfgamedataeditor.database.creatures.common.CreatureCommonParametersTableService;
import sfgamedataeditor.mvc.objects.AbstractPresenter;
import sfgamedataeditor.views.common.AbstractModulesView;
import sfgamedataeditor.views.main.modules.merchants.inventory.MerchantInventoryView;
import sfgamedataeditor.views.utility.i18n.I18NService;
import sfgamedataeditor.views.utility.i18n.I18NTypes;

import java.util.Set;

public class MerchantsView extends AbstractModulesView {

    private static final Integer MERCHANTS_RACE_ID = 168;

    public MerchantsView() {
        super(I18NService.INSTANCE.getMessage(I18NTypes.COMMON, "merchantLocations"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void fillSubViewsMappings() {
        Set<String> creatureNames = CreatureCommonParametersTableService.INSTANCE.getCreatureNamesByRaceId(MERCHANTS_RACE_ID);
        addMappings(creatureNames, MerchantInventoryView.class);
    }

    @Override
    public Class<? extends AbstractPresenter> getPresenterClass() {
        return MerchantsPresenter.class;
    }
}
