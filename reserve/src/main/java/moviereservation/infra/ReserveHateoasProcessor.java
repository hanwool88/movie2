package moviereservation.infra;

import moviereservation.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReserveHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Reserve>> {

    @Override
    public EntityModel<Reserve> process(EntityModel<Reserve> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/reservecancel")
                .withRel("reservecancel")
        );

        return model;
    }
}
