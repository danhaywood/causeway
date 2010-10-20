package org.apache.isis.extensions.bdd.common.fixtures.perform;

import org.apache.isis.metamodel.adapter.ObjectAdapter;
import org.apache.isis.metamodel.spec.feature.ObjectMember;
import org.apache.isis.metamodel.spec.feature.OneToOneAssociation;

public class GetProperty extends PerformAbstractTypeParams {

    private ObjectAdapter result;

    public GetProperty(final Perform.Mode mode) {
        super("get property", Type.PROPERTY, NumParameters.ZERO, mode);
    }

    @Override
    public void doHandle(final PerformContext performContext) {

        final ObjectAdapter onAdapter = performContext.getOnAdapter();
        final ObjectMember nakedObjectMember = performContext
                .getNakedObjectMember();

        final OneToOneAssociation otoa = (OneToOneAssociation) nakedObjectMember;

        result = otoa.get(onAdapter);
    }

    public ObjectAdapter getResult() {
        return result;
    }

}
