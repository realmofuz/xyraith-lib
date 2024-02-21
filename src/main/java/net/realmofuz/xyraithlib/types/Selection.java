package net.realmofuz.xyraithlib.types;

import net.realmofuz.xyraithlib.lambdas.SelectionLambda;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public final class Selection {
    List<Entity> targets;

    public Selection(List<Entity> targets) {
        this.targets = targets;
    }

    public Selection(Entity... targets) {
        this.targets = List.of(targets);
    }

    public void forEach(SelectionLambda lambda) {
        for(Entity entity : targets) {
            var selection = new SingleSelection(entity);
            lambda.run(selection);
        }
    }

    public List<Entity> getTargets() {
        for(Entity entity : targets) {
            if(entity.isDead()) {
                targets.remove(entity);
                continue;
            }
            if(entity instanceof Player && !((Player) entity).isOnline()) {
                targets.remove(entity);
            }
        }
        return targets;
    }
}
