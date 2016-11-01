package sfgamedataeditor.events.processing;

import sfgamedataeditor.events.types.UpdateViewModelEvent;
import sfgamedataeditor.mvc.objects.AbstractController;

public class UpdateViewModelEventStrategy implements EventProcessingStrategy<UpdateViewModelEvent> {

    @Override
    public void process(UpdateViewModelEvent event) {
        ViewControllerPair viewControllerPair = ViewRegister.INSTANCE.getViews().get(event.getView());
        AbstractController controller = viewControllerPair.getController();
        if (controller == null) {
            return;
        }

        controller.setModel(event.getModel());
        controller.updateView();
    }
}
