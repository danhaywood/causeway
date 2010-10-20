package org.apache.isis.extensions.bdd.common.fixtures.perform.checkthat.object;

import org.apache.isis.extensions.bdd.common.CellBinding;
import org.apache.isis.extensions.bdd.common.StoryBoundValueException;
import org.apache.isis.extensions.bdd.common.fixtures.perform.PerformContext;
import org.apache.isis.extensions.bdd.common.fixtures.perform.checkthat.ThatSubcommandAbstract;
import org.apache.isis.metamodel.adapter.ObjectAdapter;

public class Saved extends ThatSubcommandAbstract {

    public Saved() {
        super("is saved", "is persistent", "is persisted", "saved",
                "persistent", "persisted");
    }

    public ObjectAdapter that(final PerformContext performContext) throws StoryBoundValueException {

        final ObjectAdapter onAdapter = performContext.getOnAdapter();
        CellBinding thatItBinding = performContext.getPeer().getThatItBinding();

        if (!onAdapter.isPersistent()) {
        	throw StoryBoundValueException.current(thatItBinding, "(not saved)");
        }

        return null;
    }

}
