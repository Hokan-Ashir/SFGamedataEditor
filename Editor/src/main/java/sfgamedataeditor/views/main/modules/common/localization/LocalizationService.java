package sfgamedataeditor.views.main.modules.common.localization;

import sfgamedataeditor.views.common.ObjectTuple;
import sfgamedataeditor.views.utility.i18n.I18NService;
import sfgamedataeditor.views.utility.i18n.I18NTypes;

import javax.swing.*;
import java.util.*;

public enum LocalizationService {
    INSTANCE;

    private Integer languageId;

    private List<ObjectTuple> availableLanguages;

    private Map<String, String> languageFileMap = new TreeMap<String, String>() {{
        put("en", "English");
        put("ru", "Русский");
        put("fr", "Français");
        put("de", "Deutsch");
        put("es", "Español");
        put("it", "Italiano");
        put("pl", "Polski");
    }};

    // TODO test order of this call with non-US, RU i.e., OS-level locale
    public void initializeLocalization() {
        availableLanguages = createListOfAvailableLanguages();

        Locale locale = Locale.getDefault();
        String language = locale.getLanguage().toLowerCase();

        load18NInfo(locale, language);

        initializeDefaultSwingComponentsI18N();
    }

    private void load18NInfo(Locale locale, String language) {
        if (languageFileMap.containsKey(language)) {
            String languageName = languageFileMap.get(language);
            for (ObjectTuple availableLanguage : availableLanguages) {
                if (availableLanguage.getName().equals(languageName)) {
                    languageId = availableLanguage.getObjectId();
                    break;
                }
            }

            I18NService.INSTANCE.loadBundleMessages(locale);
        } else {
            languageId = 1;
            I18NService.INSTANCE.loadBundleMessages(Locale.ENGLISH);
        }
    }

    private void initializeDefaultSwingComponentsI18N() {
        List<String> componentPropertyList = new ArrayList<String>() {{
            add("FileChooser.openDialogTitleText");
            add("FileChooser.saveDialogTitleText");
            add("FileChooser.lookInLabelText");
            add("FileChooser.saveInLabelText");
            add("FileChooser.upFolderToolTipText");
            add("FileChooser.homeFolderToolTipText");
            add("FileChooser.newFolderToolTipText");
            add("FileChooser.listViewButtonToolTipText");
            add("FileChooser.detailsViewButtonToolTipText");
            add("FileChooser.fileNameHeaderText");
            add("FileChooser.fileSizeHeaderText");
            add("FileChooser.fileTypeHeaderText");
            add("FileChooser.fileDateHeaderText");
            add("FileChooser.fileAttrHeaderText");
            add("FileChooser.fileNameLabelText");
            add("FileChooser.filesOfTypeLabelText");
            add("FileChooser.openButtonText");
            add("FileChooser.openButtonToolTipText");
            add("FileChooser.saveButtonText");
            add("FileChooser.saveButtonToolTipText");
            add("FileChooser.directoryOpenButtonText");
            add("FileChooser.directoryOpenButtonToolTipText");
            add("FileChooser.cancelButtonText");
            add("FileChooser.cancelButtonToolTipText");
            add("FileChooser.newFolderErrorText");
            add("FileChooser.acceptAllFileFilterText");
            add("OptionPane.yesButtonText");
            add("OptionPane.noButtonText");
            add("OptionPane.cancelButtonText");
            add("ProgressMonitor.progressText");
        }};

        for (String s : componentPropertyList) {
            UIManager.put(s, I18NService.INSTANCE.getMessage(I18NTypes.COMMON, s));
        }
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;

        reloadI18N(languageId);
    }

    private void reloadI18N(int languageId) {
        for (ObjectTuple availableLanguage : availableLanguages) {
            if (!availableLanguage.getObjectId().equals(languageId)) {
                continue;
            }

            String availableLanguageName = availableLanguage.getName();
            for (Map.Entry<String, String> entry : languageFileMap.entrySet()) {
                if (!entry.getValue().equals(availableLanguageName)) {
                    continue;
                }
                String language = entry.getKey();
                Locale locale = new Locale(language);
                load18NInfo(locale, language);
                initializeDefaultSwingComponentsI18N();
                return;
            }
        }
    }

    public List<ObjectTuple> getAvailableLanguages() {
        return availableLanguages;
    }

    private List<ObjectTuple> createListOfAvailableLanguages() {
        String language = Locale.getDefault().getLanguage().toLowerCase();

        List<ObjectTuple> result = new ArrayList<>();
        result.add(new ObjectTuple("Deutsch", 0));
        result.add(new ObjectTuple("Français", 2));
        result.add(new ObjectTuple("Español", 3));
        result.add(new ObjectTuple("Italiano", 4));
        // TODO add French localization version
        switch (language) {
            case "pl":
                result.add(new ObjectTuple("Polski", 1));
                break;
            case "ru":
                result.add(new ObjectTuple("Русский", 1));
                break;
            default:
                result.add(new ObjectTuple("English", 1));
                break;
        }

        return result;
    }
}
